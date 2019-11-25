package category.dp._500_600

/**
  * 516. Longest Palindromic Subsequence
  */
object _516_LongestPalindromicSubseq {
  def longestPalindromeSubseq(s: String): Int = {
    if (s.isEmpty) return 0
    val n = s.length
    val dp = Array.tabulate(n, n)((_, _) => 0)
    for (i <- Range(n - 1, -1, -1)) {
      dp(i)(i) = 1
      for (j <- i + 1 until s.length) {
        if (s(i) == s(j)) dp(i)(j) = dp(i + 1)(j - 1) + 2
        else dp(i)(j) = Math.max(dp(i + 1)(j), dp(i)(j - 1))
      }
    }
    dp(0)(n - 1)
  }
}