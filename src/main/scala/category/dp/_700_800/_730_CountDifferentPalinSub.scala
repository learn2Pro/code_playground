package category.dp._700_800

/**
  * 730. Count Different Palindromic Subsequences
  */
object _730_CountDifferentPalinSub {
  
  def countPalindromicSubsequences(S: String): Int = {
    val N = S.length
    val MOD = 1000000007
    val dp = Array.tabulate(N, N)((_, _) => 0L)
    for (i <- Range(N - 1, -1, -1)) {
      dp(i)(i) = 1
      for (j <- i + 1 until N) {
        if (S(j) == S(i)) {
          var left = i + 1
          var right = j - 1
          while (left <= right && S(left) != S(i)) left += 1
          while (left <= right && S(right) != S(i)) right -= 1
          if (left > right) {
            dp(i)(j) = (dp(i + 1)(j - 1) * 2 + 2) % MOD
          } else if (left < right) {
            dp(i)(j) = ((dp(i + 1)(j - 1) * 2) % MOD - dp(left + 1)(right - 1)) % MOD
          } else {
            dp(i)(j) = (dp(i + 1)(j - 1) * 2 + 1) % MOD
          }
        } else {
          dp(i)(j) = ((dp(i + 1)(j) + dp(i)(j - 1)) % MOD - dp(i + 1)(j - 1)) % MOD
        }
        if (dp(i)(j) < 0) {
          dp(i)(j) += MOD
        }
      }
    }
    dp(0)(N - 1).toInt
  }
}