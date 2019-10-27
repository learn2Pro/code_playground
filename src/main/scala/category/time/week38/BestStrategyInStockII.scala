package category.time.week38

import java.util

/**
  * 122. Best Time to Buy and Sell Stock II
  */
object BestStrategyInStockII {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices == null || prices.isEmpty) return 0
    val stack = new util.Stack[Int]()
    var profit = 0
    prices.foreach { price =>
      if (!stack.empty() && price >= stack.peek()) {
        profit += price - stack.peek()
      }
      if (!stack.empty()) {
        stack.pop()
      }
      stack.push(price)
    }
    profit
  }
}