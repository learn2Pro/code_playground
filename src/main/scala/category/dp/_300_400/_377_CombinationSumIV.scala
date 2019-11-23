package category.dp._300_400

/**
  * 377. Combination Sum IV
  */
object _377_CombinationSumIV {
  def combinationSum4(nums: Array[Int], target: Int): Int = {
    if (target <= 0 || nums.isEmpty) return 0
    val dp = Array.tabulate(target + 1)(_ => 0)
    dp(0) = 1
    for (i <- 1 to target) {
      for (num <- nums if i >= num) {
        dp(i) += dp(i - num)
      }
    }
    dp(target)
  }
}