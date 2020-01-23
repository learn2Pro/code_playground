package category.dfs._400_500

/**
  * 494. Target Sum
  */
object _494_Solution {
  def findTargetSumWays(nums: Array[Int], S: Int): Int = {
    /*dynamic solution*/
    if (S > 1000 || S < -1000) return 0
    val MAX, OFFSET = 1000
    val N = nums.length
    val dp = Array.ofDim[Int](N, 2 * MAX + 1)
    dp(0)(nums(0) + OFFSET) += 1
    dp(0)(OFFSET - nums(0)) += 1
    for (i <- 1 until N)
      for (sum <- -1000 to 1000 if dp(i - 1)(sum + OFFSET) > 0) {
        dp(i)(sum + nums(i) + OFFSET) += dp(i - 1)(sum + OFFSET)
        dp(i)(sum - nums(i) + OFFSET) += dp(i - 1)(sum + OFFSET)
      }
    dp(N - 1)(S + OFFSET)
  }
}