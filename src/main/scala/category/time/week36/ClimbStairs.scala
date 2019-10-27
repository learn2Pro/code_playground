/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36

/**
  *
  * @author derong.tdr
  * @version ClimbStairs.scala, v 0.1 2019年09月08日 12:04 tang Exp $
  */
object ClimbStairs {

  def climbStairs(n: Int): Int = {
    if (n == 1) 1
    else if (n == 2) 2
    else {
      val dp = Array.tabulate(n)(_ => 0)
      dp(0) = 1
      dp(1) = 2
      for (i <- 2 until n) {
        dp(i) = dp(i - 1) + dp(i - 2)
      }
      dp(n - 1)
    }
  }
}
