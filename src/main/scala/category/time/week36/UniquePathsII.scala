/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36

/**
  *
  * @author derong.tdr
  * @version UniquePaths.scala, v 0.1 2019年09月07日 16:54 tang Exp $
  */
object UniquePathsII {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    val m = obstacleGrid.length
    val n = obstacleGrid(0).length
    val dp = Array.tabulate(m, n) { (x, y) => 1 }
    for (j <- 0 until m) {
      dp(j)(0) = if (obstacleGrid(j)(0) == 1) {
        0
      } else {
        if (j >= 1) dp(j - 1)(0) else 1
      }
    }
    for (i <- 0 until n) {
      dp(0)(i) = if (obstacleGrid(0)(i) == 1) {
        0
      } else {
        if (i >= 1) dp(0)(i - 1) else 1
      }
    }
    for (i <- 1 until m) {
      for (j <- 1 until n) {
        dp(i)(j) = if (obstacleGrid(i)(j) == 1) {
          0
        } else {
          dp(i - 1)(j) + dp(i)(j - 1)
        }
      }
    }
    dp(m - 1)(n - 1)
  }
}
