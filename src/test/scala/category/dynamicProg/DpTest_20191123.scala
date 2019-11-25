/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.dynamicProg

import category.dp._400_500.{_416_PartitionEqualSubset, _466_CountTheRepetitions, _486_PredictTheWinner, _494_TargetSum}
import category.dp._500_600.{_516_LongestPalindromicSubseq, _523_ContinuousSubArraySum, _576_OutOfBoundaryPaths}
import category.dp._600_700.{_638_ShoppingOffers, _647_PalindromicSubstrings, _650_2KeysKeyBoard, _688_KnightProbInChessBoard}
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version DpTest.scala, v 0.1 2019年11月10日 18:11 tang Exp $
  */
class DpTest_20191123 extends FunSuite {
  
  test("416. Partition Equal Subset Sum") {
    assert(_416_PartitionEqualSubset.canPartition(Array(23, 13, 11, 7, 6, 5, 5)) == true)
    assert(_416_PartitionEqualSubset.canPartition(Array(1, 5, 5, 8, 7)) == true)
    assert(_416_PartitionEqualSubset.canPartition(Array(1, 5, 11, 5)) == true)
    assert(_416_PartitionEqualSubset.canPartition(Array(1, 2, 3, 5)) == false)
  }
  
  test("466. Count The Repetitions") {
    assert(_466_CountTheRepetitions.getMaxRepetitions("aaa", 20, "aaaaa", 1) == 12)
    assert(_466_CountTheRepetitions.getMaxRepetitions("baba", 11, "baab", 1) == 7)
    assert(_466_CountTheRepetitions.getMaxRepetitions("aaa", 3, "aa", 1) == 4)
    assert(_466_CountTheRepetitions.getMaxRepetitions("acb", 1, "acb", 1) == 1)
    assert(_466_CountTheRepetitions.getMaxRepetitions("acb", 4, "ab", 2) == 2)
    assert(_466_CountTheRepetitions.getMaxRepetitions("acb", 4, "abc", 2) == 1)
  }
  
  test("494. Target Sum") {
    assert(_494_TargetSum.findTargetSumWays(Array(14, 23, 35, 48, 10, 39, 34, 40, 36, 45, 11, 14, 41, 6, 4, 17, 42, 22, 0, 35), 44) == 5844)
    assert(_494_TargetSum.findTargetSumWays(Array(1, 1, 1, 1, 1), 3) == 5)
  }
  
  test("486. Predict the Winner") {
    assert(_486_PredictTheWinner.PredictTheWinner(Array(3606449, 6, 5, 9, 452429, 7, 9580316, 9857582,
      8514433, 9, 6, 6614512, 753594, 5474165, 4, 2697293, 8, 7, 1)) == false)
    assert(_486_PredictTheWinner.PredictTheWinner(Array(1, 1)) == true)
    assert(_486_PredictTheWinner.PredictTheWinner(Array(1)) == true)
    assert(_486_PredictTheWinner.PredictTheWinner(Array(1, 5, 2)) == false)
    assert(_486_PredictTheWinner.PredictTheWinner(Array(1, 5, 233, 7)) == true)
  }
  
  test("516. Longest Palindromic Subsequence") {
    assert(_516_LongestPalindromicSubseq.longestPalindromeSubseq("bbbab") == 4)
  }
  
  test("523. Continuous Subarray Sum") {
    assert(_523_ContinuousSubArraySum.checkSubarraySum(Array(0, 1, 0), 0) == false)
    assert(_523_ContinuousSubArraySum.checkSubarraySum(Array(0, 0), -1) == true)
    assert(_523_ContinuousSubArraySum.checkSubarraySum(Array(23, 2, 6, 4, 7), 0) == false)
    assert(_523_ContinuousSubArraySum.checkSubarraySum(Array(23, 2, 4, 6, 7), 6) == true)
    assert(_523_ContinuousSubArraySum.checkSubarraySum(Array(23, 2, 6, 4, 7), 6) == true)
  }
  
  test("576. Out of Boundary Paths") {
    assert(_576_OutOfBoundaryPaths.findPaths(8, 50, 23, 5, 26) == 914783380)
    assert(_576_OutOfBoundaryPaths.findPaths(1, 1, 1, 0, 0) == 4)
    assert(_576_OutOfBoundaryPaths.findPaths(2, 2, 0, 0, 0) == 0)
    assert(_576_OutOfBoundaryPaths.findPaths(2, 2, 2, 0, 0) == 6)
    assert(_576_OutOfBoundaryPaths.findPaths(1, 3, 3, 0, 1) == 12)
  }
  
  test("688. Knight Probability in Chessboard") {
    assert(_688_KnightProbInChessBoard.knightProbability(1, 1, 0, 0) == 0.0)
    assert(_688_KnightProbInChessBoard.knightProbability(1, 0, 0, 0) == 1.0)
    assert(_688_KnightProbInChessBoard.knightProbability(3, 2, 0, 0) == 0.0625)
  }
  
  test("638. Shopping Offers") {
    assert(_638_ShoppingOffers.shoppingOffers(
      List(9, 6, 1, 5, 3, 4), List(
        List(1, 2, 2, 1, 0, 4, 14),
        List(6, 3, 4, 0, 0, 1, 16),
        List(4, 5, 6, 6, 2, 4, 26),
        List(1, 1, 4, 3, 4, 3, 15),
        List(4, 2, 5, 4, 4, 5, 15),
        List(4, 0, 0, 2, 3, 5, 13),
        List(2, 4, 6, 4, 3, 5, 7),
        List(3, 3, 4, 2, 2, 6, 21),
        List(0, 3, 0, 2, 3, 3, 15),
        List(0, 2, 4, 2, 2, 5, 24),
        List(4, 1, 5, 4, 5, 4, 25),
        List(6, 0, 5, 0, 1, 1, 14),
        List(4, 0, 5, 2, 1, 5, 8),
        List(4, 1, 4, 4, 3, 1, 10),
        List(4, 4, 2, 1, 5, 0, 14),
        List(2, 4, 4, 1, 3, 1, 16),
        List(4, 2, 3, 1, 2, 1, 26),
        List(2, 4, 1, 6, 5, 3, 2),
        List(0, 2, 0, 4, 0, 0, 19),
        List(3, 1, 6, 3, 3, 1, 23),
        List(6, 2, 3, 2, 4, 4, 16),
        List(5, 3, 5, 5, 0, 4, 5),
        List(5, 0, 4, 3, 0, 2, 20),
        List(5, 3, 1, 2, 2, 5, 8),
        List(3, 0, 6, 1, 0, 2, 10),
        List(5, 6, 6, 1, 0, 4, 12),
        List(0, 6, 6, 4, 6, 4, 21),
        List(0, 4, 6, 5, 0, 0, 22),
        List(0, 4, 2, 4, 4, 6, 16),
        List(4, 2, 1, 0, 6, 5, 14),
        List(0, 1, 3, 5, 0, 3, 8),
        List(5, 5, 3, 3, 2, 0, 4),
        List(1, 0, 3, 6, 2, 3, 18),
        List(4, 2, 6, 2, 2, 5, 2),
        List(0, 2, 5, 5, 3, 6, 12),
        List(1, 0, 6, 6, 5, 0, 10),
        List(6, 0, 0, 5, 5, 1, 24),
        List(1, 4, 6, 5, 6, 3, 19),
        List(2, 2, 4, 2, 4, 2, 20),
        List(5, 6, 1, 4, 0, 5, 3),
        List(3, 3, 2, 2, 1, 0, 14),
        List(0, 1, 3, 6, 5, 0, 9),
        List(5, 3, 6, 5, 3, 3, 11),
        List(5, 3, 3, 1, 0, 2, 26),
        List(0, 1, 1, 4, 2, 1, 16),
        List(4, 2, 3, 2, 1, 4, 6),
        List(0, 2, 1, 3, 3, 5, 15),
        List(5, 6, 4, 1, 2, 5, 18),
        List(1, 0, 0, 1, 6, 1, 16),
        List(2, 0, 6, 6, 2, 2, 17),
        List(4, 4, 0, 2, 4, 6, 12),
        List(0, 5, 2, 5, 4, 6, 6),
        List(5, 2, 1, 6, 2, 1, 24),
        List(2, 0, 2, 2, 0, 1, 14),
        List(1, 1, 0, 5, 3, 5, 16),
        List(0, 2, 3, 5, 5, 5, 6),
        List(3, 2, 0, 6, 4, 6, 8),
        List(4, 0, 1, 4, 5, 1, 6),
        List(5, 0, 5, 6, 6, 3, 7),
        List(2, 6, 0, 0, 2, 1, 25),
        List(0, 4, 6, 1, 4, 4, 6),
        List(6, 3, 1, 4, 1, 1, 24),
        List(6, 2, 1, 2, 1, 4, 4),
        List(0, 1, 2, 3, 0, 1, 3),
        List(0, 2, 5, 6, 5, 2, 13),
        List(2, 6, 4, 2, 2, 3, 17),
        List(3, 4, 5, 0, 5, 4, 20),
        List(6, 2, 3, 4, 1, 3, 4),
        List(6, 4, 0, 0, 0, 5, 16),
        List(3, 1, 2, 5, 0, 6, 11),
        List(1, 3, 2, 2, 5, 6, 14),
        List(1, 3, 4, 5, 3, 5, 18),
        List(2, 1, 1, 2, 6, 1, 1),
        List(4, 0, 4, 0, 6, 6, 8),
        List(4, 6, 0, 5, 0, 2, 1),
        List(3, 1, 0, 5, 3, 2, 26),
        List(4, 0, 4, 0, 6, 6, 6),
        List(5, 0, 0, 0, 0, 4, 26),
        List(4, 3, 2, 2, 0, 2, 14),
        List(5, 2, 4, 0, 2, 2, 26),
        List(3, 4, 6, 0, 2, 4, 25),
        List(2, 1, 5, 5, 1, 3, 26),
        List(0, 5, 2, 4, 0, 2, 24),
        List(5, 2, 5, 4, 5, 0, 1),
        List(5, 3, 0, 1, 5, 4, 15),
        List(6, 1, 5, 1, 2, 1, 21),
        List(2, 5, 1, 2, 1, 4, 15),
        List(1, 4, 4, 0, 0, 0, 1),
        List(5, 0, 6, 1, 1, 4, 22),
        List(0, 1, 1, 6, 1, 4, 1),
        List(1, 6, 0, 3, 2, 2, 17),
        List(3, 4, 3, 3, 1, 5, 17),
        List(1, 5, 5, 4, 5, 2, 27),
        List(0, 6, 5, 5, 0, 0, 26),
        List(1, 4, 0, 3, 1, 0, 13),
        List(1, 0, 3, 5, 2, 4, 5),
        List(2, 2, 2, 3, 0, 0, 11),
        List(3, 2, 2, 1, 1, 1, 6),
        List(6, 6, 1, 1, 1, 6, 26),
        List(1, 5, 1, 2, 5, 2, 1)), List(6, 6, 6, 1, 6, 6)) == 34)
    assert(_638_ShoppingOffers.shoppingOffers(List(1, 1, 1), List(List(1, 1, 0, 0), List(2, 2, 1, 9)), List(1, 1, 0)) == 0)
    assert(_638_ShoppingOffers.shoppingOffers(List(2, 5), List(List(3, 0, 5), List(1, 2, 10)), List(3, 2)) == 14)
    assert(_638_ShoppingOffers.shoppingOffers(List(2, 3, 4), List(List(1, 1, 0, 4), List(2, 2, 1, 9)), List(1, 2, 1)) == 11)
  }
  
  test("647. Palindromic Substrings") {
    assert(_647_PalindromicSubstrings.countSubstrings("abc") == 3)
    assert(_647_PalindromicSubstrings.countSubstrings("aaa") == 6)
    assert(_647_PalindromicSubstrings.countSubstrings("") == 1)
    assert(_647_PalindromicSubstrings.countSubstrings("a") == 1)
  }
  
  test("650. 2 Keys Keyboard") {
    assert(_650_2KeysKeyBoard.minSteps(100) == 14)
    assert(_650_2KeysKeyBoard.minSteps(3) == 3)
    assert(_650_2KeysKeyBoard.minSteps(4) == 4)
    assert(_650_2KeysKeyBoard.minSteps(9) == 6)
  }
}
