/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36

/**
  *
  * @author derong.tdr
  * @version EditDistance.scala, v 0.1 2019年09月08日 18:11 tang Exp $
  */
object EditDistance {
  def minDistance(word1: String, word2: String): Int = {
    if (word1 == null || word1.isEmpty) return word2.length
    if (word2 == null || word2.isEmpty) return word1.length
    val m = word1.length + 1
    val n = word2.length + 1
    val dp = Array.tabulate(m, n)((_, _) => 0)
    //init first row
    for (i <- 1 until m) {
      dp(i)(0) = dp(i - 1)(0) + 1
    }
    //init first column
    for (j <- 1 until n) {
      dp(0)(j) = dp(0)(j - 1) + 1
    }

    for (i <- 1 until m)
      for (j <- 1 until n) {
        if (word1(i - 1) == word2(j - 1)) dp(i)(j) = dp(i - 1)(j - 1)
        else {
          dp(i)(j) = Math.min(dp(i - 1)(j - 1) + 1, Math.min(dp(i)(j - 1) + 1, dp(i - 1)(j) + 1))
        }
      }
    dp(m - 1)(n - 1)
  }
}
