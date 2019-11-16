/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.dp._100_200

/**
  * 188. Best Time to Buy and Sell Stock IV
  */
object _188_BestTimeBuyAndSellStockIV {
  def maxProfit(k: Int, prices: Array[Int]): Int = {
    if (k >= (prices.length >>> 1)) {
      var t_ik0 = 0
      var t_ik1 = Int.MinValue
      for (price <- prices) {
        val old = t_ik0
        t_ik0 = Math.max(t_ik0, t_ik1 + price)
        t_ik1 = Math.max(t_ik1, old - price)
      }
      return t_ik0
    }
    val d_ik_0 = Array.tabulate(k + 1) { _ => 0 }
    val d_ik_1 = Array.tabulate(k + 1) { _ => Int.MinValue }
    for (price <- prices) {
      for (i <- Range(k, 0, -1)) {
        d_ik_0(i) = Math.max(d_ik_0(i), d_ik_1(i) + price)
        d_ik_1(i) = Math.max(d_ik_1(i), d_ik_0(i - 1) - price)
      }
    }
    d_ik_0.last
  }
}
