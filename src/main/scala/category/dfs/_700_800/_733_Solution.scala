package category.dfs._700_800


/**
  * 733. Flood Fill
  */
object _733_Solution {
  
  import java.util
  
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val M = image.length
    val N = image(0).length
    val origin = image(sr)(sc)
    val visited = new util.HashSet[(Int, Int)]()
    val queue = new util.LinkedList[(Int, Int)]()
    val shift = Array((-1, 0), (1, 0), (0, 1), (0, -1))
    queue.add((sr, sc))
    while (!queue.isEmpty) {
      val head = queue.remove()
      if (!visited.contains(head)) {
        visited.add(head)
        image(head._1)(head._2) = newColor
        shift.foreach { case (sx, sy) =>
          val x = sx + head._1
          val y = sy + head._2
          val boarder = x < 0 || x >= M || y < 0 || y >= N
          if (!boarder && image(x)(y) == origin) queue.add((x, y))
        }
      }
    }
    image
  }
}