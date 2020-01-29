package category.bsearch._700_800

import java.util.Comparator


/**
  * 786. K-th Smallest Prime Fraction
  */
object _786_Solution {
  def kthSmallestPrimeFraction(A: Array[Int], K: Int): Array[Int] = {
    val heap = new java.util.PriorityQueue[(Int, Int, BigDecimal)](new Comparator[(Int, Int, BigDecimal)] {
      override def compare(o1: (Int, Int, BigDecimal), o2: (Int, Int, BigDecimal)): Int = if (o1._3 > o2._3) 1 else -1
    })
    val N = A.length
    for (i <- 0 until N) {
      heap.add((i, N - 1, BigDecimal.apply(A(i)) / BigDecimal.apply(A(N - 1))))
    }
    for (i <- 0 until K - 1) {
      val (x, y, _) = heap.poll()
      if (y - 1 > x) heap.add((x, y - 1, BigDecimal.apply(A(x)) / BigDecimal.apply(A(y - 1))))
    }
    val (a0, a1, _) = heap.poll()
    Array(A(a0), A(a1))
  }
}