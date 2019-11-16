/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.dynamicProg

import category.dp._100_200._188_BestTimeBuyAndSellStockIV
import category.dp._200_300.{_279_PerfectSquares, _300_LongestIncreasingSubSeq}
import category.dp._300_400._312_BurstBalloons
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version DpTest.scala, v 0.1 2019年11月10日 18:11 tang Exp $
  */
class DpTest extends FunSuite {
  
  test("188. Best Time to Buy and Sell Stock IV") {
    //    assert(_188_BestTimeBuyAndSellStockIV.maxProfit(2, Array(2, 4, 1)) == 2)
    //    assert(_188_BestTimeBuyAndSellStockIV.maxProfit(1, Array(1, 2)) == 1)
    assert(_188_BestTimeBuyAndSellStockIV.maxProfit(2, Array(3, 2, 6, 5, 0, 3)) == 7)
  }
  
  test("279. Perfect Squares") {
    assert(_279_PerfectSquares.numSquares(12) == 3)
  }
  
  test("300. Longest Increasing Subsequence") {
    assert(_300_LongestIncreasingSubSeq.lengthOfLIS(Array(10, 9, 2, 5, 3, 7, 101, 18)) == 4)
  }
  
  test("312. Burst Balloons") {
    assert(_312_BurstBalloons.maxCoins(Array(3, 1, 5, 8)) == 167)
  }
  
}
