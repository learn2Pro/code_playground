package category.timeline.week27

/**
  * @author tang
  * @date 2019/07/02
  */
object StockSellSolution {

  //  def maxProfit(prices: Array[Int]): Int = {
  //    if (prices.isEmpty) {
  //      0
  //    } else {
  //      var left = 0
  //      var right = prices.length - 1
  //      var ans = Math.max(0, prices(right) - prices(left))
  //      while (left < right) {
  //        if (prices(right - 1) - prices(left) > prices(right) - prices(left + 1)) {
  //          ans = Math.max(ans, prices(right - 1) - prices(left))
  //          right -= 1
  //        } else {
  //          ans = Math.max(ans, prices(right) - prices(left + 1))
  //          left += 1
  //        }
  //      }
  //      ans
  //    }
  //
  //  }

  def maxProfit(prices: Array[Int]): Int = {
    prices.foldLeft(0 -> Int.MaxValue) {
      case ((maxProfit, minPrice), price) =>
        val newMinPrice = minPrice min price
        val newMaxProfit = maxProfit max (price - newMinPrice)
        newMaxProfit -> newMinPrice
    }._1

  }

}
