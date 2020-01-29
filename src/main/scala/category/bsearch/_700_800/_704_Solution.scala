package category.bsearch._700_800

/**
  * 704. Binary Search
  */
object _704_Solution {
  def search(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) return -1
    var lo = 0
    var hi = nums.length - 1
    while (lo <= hi) {
      val mid = (lo + hi) >>> 1
      if (nums(mid) == target) return mid
      else if (nums(mid) < target) lo = mid + 1
      else hi = mid - 1
    }
    -1
  }
}