/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.dp._200_300

/**
  *
  * 279. Perfect Squares
  *
  * @author derong.tdr
  * @version Solution.scala, v 0.1 2019年11月10日 20:49 tang Exp $
  */
object _279_PerfectSquares {
  
  def numSquares(n: Int): Int = {
    var tmp = n
    while (tmp % 4 == 0) tmp /= 4
    if (tmp % 8 == 7) return 4
    var i = 0
    while (i * i < tmp) {
      val sqrt = Math.sqrt(tmp - i * i).toInt
      if (i * i + sqrt * sqrt == tmp) {
        if (i > 0 && sqrt > 0) return 2
        else return 1
      }
      i += 1
    }
    3
  }
  
  def numSquaresV0(n: Int): Int = {
    val dp = Array.tabulate(n + 1)(_ => Int.MaxValue)
    dp(0) = 0
    dp(1) = 1
    for (i <- 2 to n) {
      var j = 1
      while (j * j < i) {
        dp(i) = Math.min(dp(i), dp(i - j * j) + 1)
        j += 1
      }
    }
    dp(n)
  }
}
