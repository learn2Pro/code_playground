package category.timeline.week38

/**
  * 115. Distinct Subsequences
  */
object DistinctSubsequences {
  def numDistinct(s: String, t: String): Int = {
    val m = s.length
    val n = t.length
    if (m == 0) return 0
    if (n == 0) return 1
    val dp = Array.tabulate(n, m)((_, _) => 0)
    if (s(0) == t(0)) dp(0)(0) = 1
    for (i <- 1 until m) {
      if (t(0) == s(i)) {
        dp(0)(i) = dp(0)(i - 1) + 1
      } else {
        dp(0)(i) = dp(0)(i - 1)
      }
    }
    for (i <- 1 until m)
      for (j <- 1 until n) {
        if (s(i) == t(j)) {
          dp(j)(i) = dp(j - 1)(i - 1) + dp(j)(i - 1)
        } else {
          dp(j)(i) = dp(j)(i - 1)
        }
      }
    dp(n - 1)(m - 1)
  }
}