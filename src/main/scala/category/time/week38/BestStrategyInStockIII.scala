package category.time.week38


/**
  * 122. Best Time to Buy and Sell Stock II
  */
object BestStrategyInStockIII {
  
  def maxProfit(prices: Array[Int]): Int = {
    var buy1 = Int.MinValue
    var buy2 = Int.MinValue
    var sell1 = 0
    var sell2 = 0
    for (i <- prices) {
      buy1 = Math.max(buy1, -i)
      sell1 = Math.max(sell1, buy1 + i)
      buy2 = Math.max(buy2, sell1 - i)
      sell2 = Math.max(sell2, buy2 + i)
    }
    sell2
  }
  
}