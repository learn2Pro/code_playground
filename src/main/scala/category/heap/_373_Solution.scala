package category.heap

import java.util.{Comparator, PriorityQueue}

/**
  * 373. Find K Pairs with Smallest Sums
  *
  * [1,7,11]
  * [2,4,6]
  * 3
  * [1,1,2]
  * [1,2,3]
  * 2
  * [1,2]
  * [3]
  * 3
  * [1,2]
  * []
  * 2
  * [1,1,1,1]
  * [2,2,2,2,3]
  * 7
  * []
  * []
  * 2
  */
object _373_Solution {
  def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[List[Int]] = {
    if (nums1.isEmpty || nums2.isEmpty) return Nil
    val heap = new PriorityQueue[Array[Int]](new Comparator[Array[Int]] {
      override def compare(o1: Array[Int], o2: Array[Int]): Int = o1(0) + o1(1) - o2(0) - o2(1)
    })
    for (i <- 0 until Math.min(k, nums1.length)) heap.add(Array(nums1(i), nums2(0), 0))
    var ans: List[List[Int]] = Nil
    for (t <- 0 until k if !heap.isEmpty) {
      val Array(l, r, idx) = heap.poll()
      ans ::= List(l, r)
      if (idx + 1 < nums2.length) heap.add(Array(l, nums2(idx + 1), idx + 1))
    }
    ans.reverse
  }
  
  //    def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[List[Int]] = {
  //      val heap = new PriorityQueue[(Int, List[Int])](new Comparator[(Int, List[Int])] {
  //        override def compare(o1: (Int, List[Int]), o2: (Int, List[Int])): Int = o1._1 - o2._1
  //      })
  //      val M = nums1.length
  //      val N = nums2.length
  //
  //      def gen: List[List[Int]] = {
  //        var ans: List[List[Int]] = Nil
  //        for (_ <- 0 until k if !heap.isEmpty) {ans ::= heap.poll()._2}
  //        ans.reverse
  //      }
  //
  //      for (i <- 0 until M)
  //        for (j <- 0 until N) {
  //          heap.add((nums1(i) + nums2(j), List(nums1(i), nums2(j))))
  //        }
  //      gen
  //    }
}