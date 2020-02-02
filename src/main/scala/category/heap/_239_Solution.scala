package category.heap

import java.util.Comparator

/**
  * 239. Sliding Window Maximum
  */
object _239_Solution {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    if (nums.isEmpty) return Array.empty
    val heap = new java.util.PriorityQueue[Int](new Comparator[Int] {
      override def compare(o1: Int, o2: Int): Int = o2 - o1
    })
    val N = nums.length
    for (i <- 0 until Math.min(k, N)) heap.add(nums(i))
    val ans = new Array[Int](Math.max(N - k + 1, 0))
    for (j <- k until N) {
      ans(j - k) = heap.peek()
      heap.remove(nums(j - k))
      heap.add(nums(j))
    }
    ans(N - k) = heap.peek()
    ans
  }
}