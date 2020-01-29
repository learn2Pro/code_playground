/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.dfs._600_700

/**
  * 664. Strange Printer
  */
object _664_Solution {
  def strangePrinter(s: String): Int = {
    if (s == null || s.isEmpty) return 0
    val N = s.length
    val dp = Array.ofDim[Int](N, N)
    for (i <- Range(N - 1, -1, -1)) {
      dp(i)(i) = 1
      for (j <- i + 1 until N) {
        dp(i)(j) = dp(i + 1)(j) + 1
        for (k <- i + 1 until N) {
          if (s(k) == s(i)) dp(i)(j) = Math.min(dp(i)(j), dp(i + 1)(k - 1) + dp(k)(j))
        }
      }
    }
    dp(0)(N - 1)
  }
}
