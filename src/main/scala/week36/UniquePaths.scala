/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week36

/**
  *
  * @author derong.tdr
  * @version UniquePaths.scala, v 0.1 2019年09月07日 16:54 tang Exp $
  */
object UniquePaths {
  def uniquePaths(m: Int, n: Int): Int = {
    val dp = Array.tabulate(m, n) { (_, _) => 1 }
    for (i <- 1 until m) {
      for (j <- 1 until n) {
        dp(i)(j) = dp(i - 1)(j) + dp(i)(j - 1)
      }
    }
    dp(m - 1)(n - 1)
  }
}
