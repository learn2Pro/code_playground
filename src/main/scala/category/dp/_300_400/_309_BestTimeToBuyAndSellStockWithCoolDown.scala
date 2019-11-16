package category.dp._300_400

/**
  * 309. Best Time to Buy and Sell Stock with Cooldown
  */
object _309_BestTimeToBuyAndSellStockWithCoolDown {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices == null || prices.isEmpty) return 0
    var t_ik_0, t_ik0_pre = 0
    var t_ik_1 = Int.MinValue
    for (price <- prices) {
      val tmp = t_ik_0
      t_ik_0 = Math.max(t_ik_0, t_ik_1 + price)
      t_ik_1 = Math.max(t_ik_1, t_ik0_pre - price)
      t_ik0_pre = tmp
    }
    t_ik_0
  }
}