package category.heap

import java.util.Comparator

/**
  * 480. Sliding Window Median
  */
object _480_Solution {
  
  class MedianWindow {
    var innerSize = 0
    val maxHeap   = new java.util.PriorityQueue[Int](new Comparator[Int] {
      override def compare(o1: Int, o2: Int): Int = -o1.compareTo(o2)
    })
    val minHeap   = new java.util.PriorityQueue[Int]()
    
    def add(num: Int): Unit = {
      minHeap.add(num)
      maxHeap.add(minHeap.poll())
      while (maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.poll())
      innerSize += 1
    }
    
    def remove(target: Int): Unit = {
      if (maxHeap.remove(target)) {
        maxHeap.add(minHeap.poll())
      } else {
        minHeap.remove(target)
      }
      while (maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.poll())
      innerSize -= 1
    }
    
    def median(): Double = {
      if (minHeap.size() == maxHeap.size()) (minHeap.peek().toLong + maxHeap.peek().toLong) / 2.0
      else minHeap.peek()
    }
    
    def size: Int = innerSize
  }
  
  /*[-2147483648,-2147483648,2147483647
  ,-2147483648,-2147483648,-2147483648,
  2147483647,2147483647,2147483647,
  2147483647,-2147483648,
  2147483647,-2147483648]*/
  def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {
    val win = new MedianWindow
    val ans = new Array[Double](Math.max(0, nums.length - k + 1))
    var t = 0
    for (i <- nums.indices) {
      win.add(nums(i))
      if (win.size > k) win.remove(nums(i - k))
      if (win.size == k) {ans(t) = win.median(); t += 1}
    }
    ans
  }
}