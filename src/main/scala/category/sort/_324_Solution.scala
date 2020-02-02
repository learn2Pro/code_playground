package category.sort

/**
  * 324. Wiggle Sort II
  */
object _324_Solution {
  def swap(arr: Array[Int], i: Int, j: Int) = {
    val tmp = arr(j)
    arr(j) = arr(i)
    arr(i) = tmp
  }
  
  def findKthLargest(input: Array[Int], k: Int): Int = {
    def partition(lo: Int, hi: Int): Int = {
      val pivot = input(lo)
      var start = lo
      var end = hi + 1
      while (start < end) {
        while (start < hi && {start += 1; input(start) < pivot}) {}
        while (end > lo && {end -= 1; input(end) > pivot}) {}
        if (start >= end) {swap(input, lo, end); return end}
        swap(input, start, end)
      }
      throw new IllegalStateException("can not be here!")
    }
    
    var l = 0
    var r = input.length - 1
    val previous = input.length - k
    while (l < r) {
      val idx = partition(l, r)
      if (idx == previous) return input(idx)
      else if (idx < previous) l = idx + 1
      else r = idx - 1
    }
    input(previous)
  }
  
  def newIndex(index: Int, n: Int): Int = {
    (1 + 2 * index) % (n | 1)
  }
  
  def wiggleSort(nums: Array[Int]): Unit = {
    if (nums.isEmpty) return
    val n: Int = nums.length
    val median = findKthLargest(nums, (n + 1) / 2)
    
    var left: Int = 0
    var i: Int = 0
    var right: Int = n - 1
    
    
    while ( {i <= right}) {
      if (nums(newIndex(i, n)) > median) {
        swap(nums, newIndex({left += 1; left - 1}, n), newIndex({i += 1; i - 1}, n))
      } else {
        if (nums(newIndex(i, n)) < median) {
          swap(nums, newIndex({right -= 1; right + 1}, n), newIndex(i, n))
        }
        else {
          i += 1
        }
      }
    }
  }
}