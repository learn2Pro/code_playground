package category.dfs._400_500

/**
  * 529. Minesweeper
  */
object _529_Solution {
  val position = Array(
    (1, 1), (1, 0), (1, -1),
    (0, 1), (0, -1),
    (-1, 1), (-1, 0), (-1, -1)
  )
  
  def updateBoard(board: Array[Array[Char]], click: Array[Int]): Array[Array[Char]] = {
    val M = board.length
    val N = board(0).length
    
    def get(x: Int, y: Int): Char = {
      if (x < 0 || x >= M || y < 0 || y >= N) return ' '
      board(x)(y)
    }
    
    def mineNeibour(x: Int, y: Int): Int = {
      position.count { case (shift0, shift1) =>
        get(x + shift0, y + shift1) == 'M' || get(x + shift0, y + shift1) == 'X'
      }
    }
    
    val visited = new java.util.HashSet[(Int, Int)]
    val queue = new java.util.LinkedList[(Int, Int)]
    queue.add((click(0), click(1)))
    var entry = true
    while (!queue.isEmpty) {
      val (x, y) = queue.remove()
      if (x < 0 || x >= M || y < 0 || y >= N || visited.contains((x, y))) {}
      else if (get(x, y) == 'M') {
        if (entry) board(x)(y) = 'X'
      } else if (mineNeibour(x, y) > 0) {
        board(x)(y) = ('0' + mineNeibour(x, y)).toChar
      } else {
        board(x)(y) = 'B'
        position.foreach { case (shift0, shift1) =>
          queue.add((x + shift0, y + shift1))
        }
        entry = false
      }
      visited.add((x, y))
    }
    board
  }
}