package category.dp._400_500

/**
  * 494. Target Sum
  */
object _494_TargetSum {
  def findTargetSumWays(nums: Array[Int], S: Int): Int = {
    val dp = Array.tabulate(nums.length, 2001)((_, _) => 0)
    val offset = 1000
    dp(0)(nums(0) + offset) = 1
    dp(0)(-nums(0) + offset) += 1
    for (i <- 1 until nums.length) {
      for (sum <- -1000 to 1000 if dp(i - 1)(sum + offset) > 0) {
        dp(i)(sum + nums(i) + offset) += dp(i - 1)(sum + offset)
        dp(i)(sum - nums(i) + offset) += dp(i - 1)(sum + offset)
      }
    }
    if (S > 1000) 0 else dp(nums.length - 1)(S + 1000)
  }
  
  def findTargetSumWaysV1(nums: Array[Int], S: Int): Int = {
    val dp = Array.tabulate[List[Long]](nums.length + 1)(_ => Nil)
    dp(0) = List(0)
    var ans = 0
    for (i <- 1 to nums.length) {
      dp(i) = dp(i - 1).flatMap { curr =>
        val t0 = curr + nums(i - 1)
        val t1 = curr - nums(i - 1)
        var tmp: List[Long] = Nil
        if (i == nums.length && t0 == S) ans += 1
        if (i == nums.length && t1 == S) ans += 1
        if (t0 >= -1000 && t0 <= 1000) {
          tmp ::= t0
        }
        if (t1 >= -1000 && t1 <= 1000) {
          tmp ::= t1
        }
        tmp
      }
    }
    ans
  }
}