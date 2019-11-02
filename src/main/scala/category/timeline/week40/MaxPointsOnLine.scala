package category.timeline.week40

/**
  * 149. Max Points on a Line
  */
object MaxPointsOnLine {
  def maxPoints(points: Array[Array[Int]]): Int = {
    if (points == null || points.isEmpty) return 0
    var res = 1
    val len = points.length
    for (i <- 0 until len) {
      var dup = 1
      for (j <- i + 1 until len) {
        var partial = 0
        if (x(points(i)) == x(points(j)) && y(points(i)) == y(points(j))) {
          dup += 1
        } else {
          points.foreach { point =>
            if (isLine(points(i), points(j), point)) {
              partial += 1
            }
          }
        }
        res = Math.max(partial, res)
      }
      res = Math.max(dup, res)
    }
    res
  }
  
  private def isLine(first: Array[Int], second: Array[Int], three: Array[Int]): Boolean = {
    x(first) * y(second) + x(second) * y(three) + x(three) * y(first) - x(three) * y(second) - x(second) * y(first) - x(first) * y(three) == 0
  }
  
  private def x(arr: Array[Int]): Long = {
    arr(0).toLong
  }
  
  private def y(arr: Array[Int]): Long = {
    arr(1).toLong
  }
}