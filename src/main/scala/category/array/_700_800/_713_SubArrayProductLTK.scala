package category.array._700_800

/**
  * 713. Subarray Product Less Than K
  */
object _713_SubArrayProductLTK {
  
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    var product = 1
    var left, ans = 0
    for (i <- nums.indices) {
      product *= nums(i)
      while (product >= k && left < nums.length) {
        product /= nums(left)
        left += 1
      }
      if (left >= nums.length) return ans
      ans += (i - left + 1)
    }
    ans
  }
}