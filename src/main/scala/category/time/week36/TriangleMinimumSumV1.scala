/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36

/**
  *
  * @author derong.tdr
  * @version TriangleMinimumSum.scala, v 0.1 2019年09月02日 23:37 tang Exp $
  */
object TriangleMinimumSumV1 {
  /**
    * lower to upper
    * dp[j],dp[j+1] use the same ancestor triangle(i)(j-1)
    * then we choose the min(dp[j]+dp[j+1])
    * as the minimum in location (i,j-1)
    */
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val dp = triangle.last.toArray
    var i = triangle.size - 2
    while (i >= 0) {
      var j = 0
      while (j <= i) {
        dp(j) = Math.min(dp(j), dp(j + 1)) + triangle(i)(j)
        j += 1
        j
      }
      i -= 1
      i
    }
    dp(0)
  }


}
