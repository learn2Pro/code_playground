package category.string._500_600

/**
  * 583. Delete Operation for Two Strings
  */
object _583_DelOperationForTwoStr {
  def minDistance(word1: String, word2: String): Int = {
    val N0 = word1.length
    val N1 = word2.length
    val dp = Array.tabulate(N0 + 1, N1 + 1)((_, _) => Int.MaxValue)
    dp(0)(0) = 0
    for (i <- 1 to N0) dp(i)(0) = dp(i - 1)(0) + 1
    for (j <- 1 to N1) dp(0)(j) = dp(0)(j - 1) + 1
    for (i <- 1 to N0)
      for (j <- 1 to N1) {
        val incr = if (word1(i - 1) == word2(j - 1)) 0 else 2
        dp(i)(j) = Math.min(dp(i - 1)(j - 1) + incr, Math.min(dp(i)(j - 1), dp(i - 1)(j)) + 1)
      }
    dp(N0)(N1)
  }
}