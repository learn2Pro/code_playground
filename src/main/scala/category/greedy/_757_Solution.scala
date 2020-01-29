package category.greedy

/**
  * 757. Set Intersection Size At Least Two
  */
object _757_Solution {
  def intersectionSizeTwo(intervals: Array[Array[Int]]): Int = {
    val sorted = intervals.sorted(new Ordering[Array[Int]] {
      override def compare(x: Array[Int], y: Array[Int]): Int = {
        if (x(1) == y(1)) y(0) - x(0) else x(1) - y(1)
      }
    })
    var ans = 0
    var largest, secondLarge = -1
    for (_@Array(s, e) <- sorted) {
      val in0 = largest >= s
      val in1 = secondLarge >= s
      if (in0 && !in1) {ans += 1; secondLarge = largest; largest = e}
      else if (!in0 && !in1) {ans += 2; largest = e; secondLarge = e - 1}
    }
    ans
  }
  
  //  def intersectionSizeTwo(intervals: Array[Array[Int]]): Int = {
  //    val sorted = intervals.sorted(new Ordering[Array[Int]] {
  //      override def compare(x: Array[Int], y: Array[Int]): Int = {
  //        if (x(0) != y(0)) x(0) - y(0) else y(1) - x(1)
  //      }
  //    })
  //    var ans = 0
  //    val todo = Array.tabulate(intervals.length)(_ => 2)
  //    for (t <- Range(intervals.length - 1, -1, -1)) {
  //      val s = sorted(t)(0)
  //      val e = sorted(t)(1)
  //      val m = todo(t)
  //      for (p <- s until s + m) {
  //        for (i <- 0 to t if todo(i) > 0 && p <= sorted(i)(1)) todo(i) -= 1
  //        ans += 1
  //      }
  //    }
  //    ans
  //  }
  
  //  def intersectionSizeTwo(intervals: Array[Array[Int]]): Int = {
  //    def union(interval0: Array[Int], interval1: Array[Int]): Array[Int] = {
  //      if (interval0 == null) return interval1
  //      if (interval1 == null) return interval0
  //      Array(Math.min(interval0(0), interval1(0)), Math.max(interval0(1), interval1(1)))
  //    }
  //
  //    def select(smaller: Array[Int], bigger: Array[Int], set: Array[Int]): Array[Int] = {
  //      val gap0 = Array(smaller(1) - 1, Math.max(bigger(0) + 1, smaller(1)))
  //      val union0 = union(set, gap0)
  //      if (smaller(1) - bigger(0) >= 1) {
  //        val union1 = union(set, Array(bigger(0), bigger(0) + 1))
  //        if (union1(1) - union1(0) < union0(1) - union0(0)) return union1
  //      }
  //      union0
  //    }
  //
  //    var set: Array[Int] = null
  //    val sorted = intervals.sorted(new Ordering[Array[Int]] {
  //      override def compare(x: Array[Int], y: Array[Int]): Int = x(1) - y(1)
  //    })
  //    sorted.reduce[Array[Int]] { case (previous, current) =>
  //      set = select(previous, current, set)
  //      current
  //    }
  //    set(1) - set(0) + 1
  //  }
}