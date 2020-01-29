package category.bsearch._600_700

/**
  * 668. Kth Smallest Number in Multiplication Table
  */
object _668_Solution {
  def findKthNumber(m: Int, n: Int, k: Int): Int = {
    var lo = 1
    var hi = m * n
    while (lo < hi) {
      var cnt = 0
      val mid = (lo + hi) >>> 1
      for (i <- 1 to m) {
        var j = n
        while (j >= 1 && i * j > mid) j -= 1
        cnt += j
      }
      if (cnt < k) lo = mid + 1
      else hi = mid
    }
    lo
  }
  
  //  def findKthNumber(m: Int, n: Int, k: Int): Int = {
  //    val queue = new mutable.PriorityQueue[(Int, Int, Int)]()(new Ordering[(Int, Int, Int)] {
  //      override def compare(x: (Int, Int, Int), y: (Int, Int, Int)): Int = y._3 - x._3
  //    })
  //    for (j <- 1 to n) queue.enqueue((1, j, j))
  //    for (_ <- 0 until k - 1) {
  //      val (x, y, _) = queue.dequeue()
  //      if (x + 1 <= m) queue.enqueue((x + 1, y, y * (x + 1)))
  //    }
  //    queue.dequeue()._3
  //  }
}