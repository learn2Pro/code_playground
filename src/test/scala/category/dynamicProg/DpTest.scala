/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.dynamicProg

import category.dp._100_200._188_BestTimeBuyAndSellStockIV
import category.dp._200_300.{_279_PerfectSquares, _300_LongestIncreasingSubSeq}
import category.dp._300_400._
import category.dp._400_500._
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
  
  test("343. Integer Break") {
    assert(_343_IntegerBreak.integerBreak(2) == 1)
    assert(_343_IntegerBreak.integerBreak(10) == 36)
  }
  
  test("357. Count Numbers with Unique Digits") {
    assert(_357_CountNumbersWithUniqueDigits.countNumbersWithUniqueDigits(4) == 5275)
    assert(_357_CountNumbersWithUniqueDigits.countNumbersWithUniqueDigits(2) == 91)
    assert(_357_CountNumbersWithUniqueDigits.countNumbersWithUniqueDigits(3) == 739)
  }
  
  test("375. Guess Number Higher or Lower II") {
    //    assert(_375_GuessNumberII.getMoneyAmount(1) == 0)
    //    assert(_375_GuessNumberII.getMoneyAmount(2) == 1)
    //    assert(_375_GuessNumberII.getMoneyAmount(3) == 2)
    //    assert(_375_GuessNumberII.getMoneyAmount(4) == 4)
    //    assert(_375_GuessNumberII.getMoneyAmount(5) == 6)
    assert(_375_GuessNumberII.getMoneyAmount(10) == 16)
    assert(_375_GuessNumberII.getMoneyAmount(11) == 18)
    assert(_375_GuessNumberII.getMoneyAmount(1) == 0)
    assert(_375_GuessNumberII.getMoneyAmount(20) == 49)
  }
  
  test("376. Wiggle Subsequence") {
    assert(_376_WiggleSubSequence.wiggleMaxLength(Array(0, 0)) == 1)
    assert(_376_WiggleSubSequence.wiggleMaxLength(Array(1, 2, 3, 4, 5, 6, 7, 8, 9)) == 2)
    assert(_376_WiggleSubSequence.wiggleMaxLength(Array(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)) == 7)
    assert(_376_WiggleSubSequence.wiggleMaxLength(Array(1, 7, 4, 9, 2, 5)) == 6)
  }
  
  test("377. Combination Sum IV") {
    assert(_377_CombinationSumIV.combinationSum4(Array(1, 2, 3), 4) == 7)
  }
  
  test("403. Frog Jump") {
    assert(_403_FrogJump.canCross(Array(0, 1, 3, 5, 6, 8, 12, 17)) == true)
    assert(_403_FrogJump.canCross(Array(0, 1, 2, 3, 4, 8, 9, 11)) == false)
  }
  
  test("446. Arithmetic Slices II - Subsequence") {
    assert(_446_ArithmeticSlicesII.numberOfArithmeticSlices(Array(1, 1, 1, 1, 1, 1, 1)) == 99)
    assert(_446_ArithmeticSlicesII.numberOfArithmeticSlices(Array(1, 1, 1, 1, 1, 1)) == 42)
    assert(_446_ArithmeticSlicesII.numberOfArithmeticSlices(Array(1, 1, 1, 1, 1)) == 16)
    assert(_446_ArithmeticSlicesII.numberOfArithmeticSlices(Array(1, 1, 1, 1)) == 5)
    assert(_446_ArithmeticSlicesII.numberOfArithmeticSlices(Array(2, 4, 6, Int.MinValue, Int.MaxValue)) == 1)
    assert(_446_ArithmeticSlicesII.numberOfArithmeticSlices(Array(-2147483648, 2, 4, 6, 8, 10, 2147483647)) == 7)
    assert(_446_ArithmeticSlicesII.numberOfArithmeticSlices(Array(2, 4, 6, 8, 10)) == 7)
  }
  
  test("464. Can I Win") {
    assert(_464_CanIWin.canIWin(10, 11) == false)
  }
  
  test("467. Unique Substrings in Wraparound String") {
    assert(_467_UniqueSubstrInWrapAround.findSubstringInWraproundString("zaba") == 6)
    assert(_467_UniqueSubstrInWrapAround.findSubstringInWraproundString("cac") == 2)
    assert(_467_UniqueSubstrInWrapAround.findSubstringInWraproundString("abaab") == 3)
    assert(_467_UniqueSubstrInWrapAround.findSubstringInWraproundString("zab") == 6)
    assert(_467_UniqueSubstrInWrapAround.findSubstringInWraproundString("zabcdz") == 15)
  }
  
  test("474. Ones and Zeroes") {
    assert(_474_OnesAndZeros.findMaxForm(Array("10", "0001", "111001", "1", "0"), 3, 4) == 3)
    assert(_474_OnesAndZeros.findMaxForm(Array("10", "0001", "111001", "1", "0"), 5, 3) == 4)
    assert(_474_OnesAndZeros.findMaxForm(Array("10", "0001", "111001", "1", "0"), 6, 7) == 4)
    assert(_474_OnesAndZeros.findMaxForm(Array("10", "0", "1"), 1, 1) == 2)
  }
  
  
}
