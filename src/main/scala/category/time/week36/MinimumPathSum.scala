/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36

/**
  *
  * @author derong.tdr
  * @version MinimumPathSum.scala, v 0.1 2019年09月07日 18:33 tang Exp $
  */
class MinimumPathSum {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length
    for (j <- 1 until m) {
      grid(j)(0) += grid(j - 1)(0)
    }
    for (i <- 1 until n) {
      grid(0)(i) += grid(0)(i - 1)
    }
    for (i <- 1 until m) {
      for (j <- 1 until n) {
        grid(i)(j) = Math.min(grid(i)(j) + grid(i - 1)(j), grid(i)(j) + grid(i)(j - 1))
      }
    }
    grid(m - 1)(n - 1)
  }
}
