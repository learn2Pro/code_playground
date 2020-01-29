package category.bfs

import scala.collection.mutable.ArrayBuffer

/**
  * 773. Sliding Puzzle
  */
object _773_Solution {
  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    val position = Array((-1, 0), (1, 0), (0, -1), (0, 1))
    
    val queue = new java.util.LinkedList[String]
    val visited = new java.util.HashSet[String]
    queue.add("123450")
    visited.add("123450")
    
    def ser(input: Array[Array[Int]]): String = {
      input.map(_.mkString).mkString
    }
    
    def move(s: String): ArrayBuffer[String] = {
      val i = s.indexOf('0')
      val (x, y) = (i / 3, i % 3)
      val buffer = new ArrayBuffer[String]()
      position.foreach { case (sx, sy) =>
        val px = x + sx
        val py = y + sy
        val boarder = px < 0 || px >= 2 || py < 0 || py >= 3
        if (!boarder) {
          val chars = s.toCharArray
          val tmp = chars(px * 3 + py)
          chars(px * 3 + py) = chars(x * 3 + y)
          chars(x * 3 + y) = tmp
          val next = new String(chars)
          if (!visited.contains(next)) {
            visited.add(next)
            buffer += next
          }
          
        }
      }
      buffer
    }
    
    val input = ser(board)
    var depth = 0
    while (!queue.isEmpty) {
      val len = queue.size()
      for (i <- 0 until len) {
        val curr = queue.remove()
        if (curr == input) return depth
        move(curr).foreach { s => queue.add(s) }
      }
      depth += 1
    }
    -1
  }
}