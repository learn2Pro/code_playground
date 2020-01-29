package category.bsearch._300_400

import java.util.Comparator

/**
  * 378. Kth Smallest Element in a Sorted Matrix
  */
object _378_Solution {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    val N = matrix.length
    val heap = new java.util.PriorityQueue[(Int, Int, Int)](new Comparator[(Int, Int, Int)] {
      override def compare(o1: (Int, Int, Int), o2: (Int, Int, Int)): Int = o1._3 - o2._3
    })
    for (i <- 0 until N) heap.add((0, i, matrix(0)(i)))
    for (j <- 0 until k - 1) {
      val (x, y, _) = heap.poll()
      if (x != N - 1) {
        heap.add((x + 1, y, matrix(x + 1)(y)))
      }
    }
    heap.poll()._3
  }
  
  //  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
  //    val N = matrix.length
  //    val pointers = Array.tabulate(N)(_ => 0)
  //    var remove, ans = 0
  //    while (remove < k) {
  //      val (min, idx) = (for (i <- pointers.indices) yield {
  //        if (pointers(i) < N) matrix(i)(pointers(i)) -> i else null
  //      }).filter(_ != null).min
  //      pointers(idx) += 1
  //      ans = min
  //      remove += 1
  //    }
  //    ans
  //  }
}