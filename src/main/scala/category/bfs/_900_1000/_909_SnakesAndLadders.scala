package category.bfs._900_1000


/**
  * 909. Snakes and Ladders
  */
object _909_SnakesAndLadders {
  
  import java.util
  
  def snakesAndLadders(board: Array[Array[Int]]): Int = {
    val N = board.length
    
    def coord(where: Int): (Int, Int) = {
      val row = (where - 1) / N
      val col = (where - 1) % N
      if (row % 2 == 0) {
        (N - row - 1, col)
      } else {
        (N - row - 1, N - col - 1)
      }
    }
    
    val q = new util.LinkedList[Int]
    val movedUsage = new util.HashMap[Int, Int]()
    movedUsage.put(1, 0)
    q.add(1)
    while (!q.isEmpty) {
      val head = q.removeFirst()
      for (i <- head + 1 to Math.min(head + 6, N * N)) {
        val location = coord(i)
        val where = if (board(location._1)(location._2) != -1) {
          board(location._1)(location._2)
        } else {
          i
        }
        if (!movedUsage.containsKey(where)) {
          q.add(where)
          movedUsage.put(where, movedUsage.get(head) + 1)
          if (where == N * N) return movedUsage.get(where)
        }
      }
    }
    -1
  }
}