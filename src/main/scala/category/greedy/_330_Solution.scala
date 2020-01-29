package category.greedy

/**
  * 330. Patching Array
  */
object _330_Solution {
  def minPatches(nums: Array[Int], n: Int): Int = {
    var miss = 1L
    var ans = 0
    var idx = 0
    while (miss <= n) {
      if (idx < nums.length && nums(idx) <= miss.toInt) {miss += nums(idx); idx += 1}
      else {miss += miss; ans += 1}
    }
    ans
  }
}