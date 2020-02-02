package category.sort

import java.util


/**
  * 220. Contains Duplicate III
  *
  * [1,2,3,1]
  * 3
  * 0
  * [1,5,9,1,5,9]
  * 2
  * 3
  * [1,0,1,1]
  * 1
  * 2
  * [1,2,3]
  * 0
  * 0
  * []
  * 1
  * 1
  * [1]
  * 1
  * 1
  * [1]
  * 0
  * 0
  * [1,2]
  * 0
  * 1
  * [1,2]
  * 1
  * 1
  * [1,2,5,7,8,10,22,1,2,36,7,8,4,32,100,2]
  * 3
  * 10
  * [2,2]
  * 3
  * 0
  * [1,2,5,7,8,10,22,1,2,36,7,8,4,32,100,2]
  * 100
  * 10
  * [-1,2147483647]
  * 1
  * 2147483647
  */
object _220_Solution {
  
  case class Win(input: Array[Int], init: Int) {
    val arr: Array[Int] = input.clone()
    java.util.Arrays.sort(arr, 0, Math.min(input.length, init))
    var lo = 0
    var hi = Math.min(init - 1, input.length - 1)
    
    def add(target: Int): Unit = {
      var index = java.util.Arrays.binarySearch(arr, lo, hi + 1, target)
      if (index < 0) index = -index - 1
      System.arraycopy(arr, index, arr, index + 1, hi - index + 1)
      arr(index) = target
      hi += 1
    }
    
    def remove(target: Int): Unit = {
      var index = java.util.Arrays.binarySearch(arr, lo, hi + 1, target)
      if (index < 0) index = -index - 1
      System.arraycopy(arr, lo, arr, lo + 1, index - lo)
      lo += 1
    }
    
    def search(target: Int): Int = {
      java.util.Arrays.binarySearch(arr, lo, hi + 1, target)
    }
    
    def gap(i: Int): Long = {
      var gap = Long.MaxValue
      if (i - 1 >= lo && i - 1 <= hi) {
        gap = Math.min(gap, Math.abs(arr(i - 1).toLong - arr(i).toLong))
      }
      if (i + 1 >= lo && i + 1 <= hi) {
        gap = Math.min(gap, Math.abs(arr(i + 1).toLong - arr(i).toLong))
      }
      gap
    }
    
    def size: Int = hi - lo + 1
    
  }
  
  //  def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
  //    if (nums == null || nums.isEmpty) return false
  //    val window = Win(nums, k)
  //
  //    def move(idx: Int) = {
  //      if (idx + k < nums.length) window.add(nums(idx + k))
  //      if (window.lo < idx - k) window.remove(nums(idx - k - 1))
  //    }
  //
  //    for (i <- nums.indices) {
  //      move(i)
  //      val index = window.search(nums(i))
  //      if (window.gap(index) <= t) return true
  //    }
  //    false
  //  }
  def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
    if (nums == null || nums.isEmpty || k < 0) return false
    val tree = new util.TreeSet[java.lang.Long]()
    for (i <- nums.indices) {
      val f = tree.floor(nums(i).toLong + t)
      val c = tree.ceiling(nums(i).toLong - t)
      if ((f != null && f >= nums(i)) || (c != null && c <= nums(i))) return true
      tree.add(nums(i).toLong)
      if (i >= k) tree.remove(nums(i - k).toLong)
    }
    false
  }
}