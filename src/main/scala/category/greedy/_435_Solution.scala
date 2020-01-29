package category.greedy

/**
  * 435. Non-overlapping Intervals
  */
object _435_Solution {
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    if (intervals.isEmpty || intervals(0).isEmpty) return 0
    val sorted = intervals.sortWith { case (_@Array(s0, s1), _@Array(t0, t1)) => s1 < t1 }
    val N = sorted.length
    var end = sorted(0).last
    var count = 1
    for (i <- 1 until N) {
      if (sorted(i).head >= end) {end = sorted(i).last; count += 1}
    }
    N - count
  }
  
  //  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
  //    if (intervals.isEmpty || intervals(0).isEmpty) return 0
  //    val tree = new util.TreeMap[Integer, Array[Int]]()
  //    val N = intervals.length
  //
  //    def search(index: Int, previous: Int): Int = {
  //      if (index >= N) return previous
  //      val interval = intervals(index)
  //      val lo = tree.floorKey(interval(0))
  //      val hi = tree.floorKey(interval(1))
  //      if (lo != null && hi != null && lo != hi) search(index + 1, previous + 1)
  //      else if (lo != null && hi != null && lo == hi && tree.get(lo).last > interval(0)) {
  //        if (tree.get(lo).last >= interval(1)) {tree.remove(lo); tree.put(interval(0), interval); search(index + 1, previous + 1)}
  //        else {
  //          val ans0 = search(index + 1, previous + 1)
  //          val v = tree.remove(lo)
  //          tree.put(interval(0), interval)
  //          val ans1 = search(index + 1, previous + 1)
  //          if (ans0 < ans1) {tree.remove(interval(0)); tree.put(lo, v); ans0} else ans1
  //        }
  //      } else {
  //        tree.put(interval(0), interval)
  //        search(index + 1, previous)
  //      }
  //    }
  //
  //    search(0, 0)
  //  }
}