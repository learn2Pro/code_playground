package category.greedy

/**
  * 452. Minimum Number of Arrows to Burst Balloons
  */
object _452_Solution {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    if (points.isEmpty || points(0).isEmpty) return 0
    val sorted = points.sortWith { case (_@Array(_, s1), _@Array(_, t1)) => s1 < t1 }
    var end = sorted(0).last
    var count = 1
    for (i <- 1 until sorted.length) {
      if (sorted(i).head > end) {count += 1; end = sorted(i).last}
    }
    count
  }
}