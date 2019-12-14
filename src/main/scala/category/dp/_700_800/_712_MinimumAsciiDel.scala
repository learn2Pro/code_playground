package category.dp._700_800

/**
  * 712. Minimum ASCII Delete Sum for Two Strings
  */
object _712_MinimumAsciiDel {
  def minimumDeleteSum(s1: String, s2: String): Int = {
    val M = s1.length
    val N = s2.length
    val dp = Array.tabulate(s1.length + 1, s2.length + 1)((_, _) => 0)
    for (i <- 1 to M) {
      dp(i)(0) = dp(i - 1)(0) + s1(i - 1)
    }
    for (j <- 1 to N) {
      dp(0)(j) = dp(0)(j - 1) + s2(j - 1)
    }
    for (i <- 1 to M)
      for (j <- 1 to N) {
        val incr = if (s1(i - 1) == s2(j - 1)) 0 else s1(i - 1) + s2(j - 1)
        dp(i)(j) = Math.min(dp(i - 1)(j - 1) + incr, Math.min(dp(i - 1)(j) + s1(i - 1), dp(i)(j - 1) + s2(j - 1)))
      }
    dp(M)(N)
  }
}