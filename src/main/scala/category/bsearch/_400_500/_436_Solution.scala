package category.bsearch._400_500


/**
  * 436. Find Right Interval
  */
object _436_Solution {
  def findRightInterval(intervals: Array[Array[Int]]): Array[Int] = {
    if (intervals.isEmpty || intervals(0).isEmpty) return Array.empty
    val bst = new java.util.TreeMap[Integer, Int]()
    val ans = new Array[Int](intervals.length)
    for (i <- intervals.indices) {
      bst.put(intervals(i)(0), i)
    }
    var i = 0
    intervals.foreach { case a@Array(s, e) =>
      val entry = bst.ceilingEntry(e)
      if (entry != null) ans(i) = entry.getValue else ans(i) = -1
      i += 1
    }
    ans
  }
}