package category.array._700_800

/**
  * 714. Best Time to Buy and Sell Stock with Transaction Fee
  */
object _714_BestBuyOrSellStock {
  def maxProfit(prices: Array[Int], fee: Int): Int = {
    var t_ik0:Long = 0L
    var t_ik1:Long = Int.MinValue
    for (price <- prices) {
      t_ik0 = Math.max(t_ik0, t_ik1 + price - fee)
      t_ik1 = Math.max(t_ik1, t_ik0 - price)
    }
    t_ik0.toInt
  }
}