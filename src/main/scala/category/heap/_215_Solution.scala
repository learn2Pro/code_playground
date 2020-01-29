package category.heap

/**
  * 215. Kth Largest Element in an Array
  */
object _215_Solution {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    val N = nums.length
    var lo = 0
    var hi = N - 1
    val previousSize = N - k
    val rnd = new java.util.Random()
    
    def partition(start: Int, end: Int): Int = {
      val pivot = nums(start)
      var i = start
      var j = end + 1
      while (true) {
        while (i < end && {i += 1; nums(i) < pivot}) {}
        while (j > lo && {j -= 1; nums(j) > pivot}) {}
        if (i >= j) return swap(start, j)
        swap(i, j)
      }
      throw new RuntimeException("can not be here")
    }
    
    def swap(i: Int, j: Int): Int = {
      val tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
      j
    }
    
    def shuffle(array: Array[Int]): Unit = {
      val N = array.length
      for (i <- 0 until N) {
        swap(i, rnd.nextInt(i + 1))
      }
    }
    
    shuffle(nums)
    while (lo < hi) {
      val idx = partition(lo, hi)
      if (idx == previousSize) return nums(idx)
      else if (idx < previousSize) lo = idx + 1
      else hi = idx - 1
    }
    nums(previousSize)
  }
  
  //  def findKthLargest(nums: Array[Int], k: Int): Int = {
  //    val heap = new mutable.PriorityQueue[Int]()(new Ordering[Int] {
  //      override def compare(x: Int, y: Int): Int = y - x
  //    })
  //    nums.foreach { num =>
  //      heap.enqueue(num)
  //      if (heap.size > k) heap.dequeue()
  //    }
  //    heap.dequeue()
  //  }
}