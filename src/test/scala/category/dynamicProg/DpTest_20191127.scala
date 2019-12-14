/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.dynamicProg

import category.bfs._900_1000._909_SnakesAndLadders
import category.dp._300_400.{_321_CreateMaximumNumber, _354_RussianDollEnvelopes, _363_MaxSumOfRectangleNoLargerThanK}
import category.dp._400_500._472_ConcatenatedWords
import category.dp._500_600.{_514_FreedomTrail, _546_RemoveBoxes, _552_StudentAttendanceRecordII}
import category.dp._600_700.{_691_StickersToSpellWord, _698_PartitionToKEqSumSubsets}
import category.dp._700_800._
import category.dp._800_900._801_MinimumSwapsToMakeSeqIncr
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version DpTest.scala, v 0.1 2019年11月10日 18:11 tang Exp $
  */
class DpTest_20191127 extends FunSuite {
  
  test("321. Create Maximum Number") {
    assert(_321_CreateMaximumNumber.maxNumber(
      Array(6, 4, 7, 8, 6, 5, 5, 3, 1, 7, 4, 9, 9, 5, 9, 6, 1, 7, 1, 3, 6, 3, 0, 8, 2, 1, 8, 0, 0, 7, 3, 9, 3, 1, 3, 7, 5, 9, 4, 3, 5, 8, 1, 9, 5, 6, 5, 7, 8, 6, 6, 2, 0, 9, 7, 1, 2, 1, 7, 0, 6, 8, 5, 8, 1, 6, 1, 5, 8, 4),
      Array(3, 0, 0, 1, 4, 3, 4, 0, 8, 5, 9, 1, 5, 9, 4, 4, 4, 8, 0, 5, 5, 8, 4, 9, 8, 3, 1, 3, 4, 8, 9, 4, 9, 9, 6, 6, 2, 8, 9, 0, 8, 0, 0, 0, 1, 4, 8, 9, 7, 6, 2, 1, 8, 7, 0, 6, 4, 1, 8, 1, 3, 2, 4, 5, 7, 7, 0, 4, 8, 4),
      70) sameElements Array(7, 3, 8, 2, 5, 6, 4, 4, 0, 6, 5, 7, 6, 2, 0))
    assert(_321_CreateMaximumNumber.maxNumber(Array(2, 5, 6, 4, 4, 0), Array(7, 3, 8, 0, 6, 5, 7, 6, 2), 15)
            sameElements Array(7, 3, 8, 2, 5, 6, 4, 4, 0, 6, 5, 7, 6, 2, 0))
    assert(_321_CreateMaximumNumber.maxNumber(Array(1, 2), Array.empty, 1)
            sameElements Array(2))
    assert(_321_CreateMaximumNumber.maxNumber(Array(1), Array.empty, 1)
            sameElements Array(1))
    assert(_321_CreateMaximumNumber.maxNumber(Array.empty, Array(1), 1)
            sameElements Array(1))
    assert(_321_CreateMaximumNumber.maxNumber(Array(5, 2, 2), Array(6, 4, 1), 3)
            sameElements Array(6, 5, 4))
    assert(_321_CreateMaximumNumber.maxNumber(Array.empty, Array(9, 1, 2, 5, 8, 3), 4)
            sameElements Array(9, 5, 8, 3))
    assert(_321_CreateMaximumNumber.maxNumber(Array(3, 4, 6, 5), Array(9, 1, 2, 5, 8, 3), 5)
            sameElements Array(9, 8, 6, 5, 3))
    assert(_321_CreateMaximumNumber.maxNumber(Array(6, 7), Array(6, 0, 4), 5)
            sameElements Array(6, 7, 6, 0, 4))
    assert(_321_CreateMaximumNumber.maxNumber(Array(3, 9), Array(8, 9), 3)
            sameElements Array(9, 8, 9))
  }
  
  test("354. Russian Doll Envelopes") {
    assert(_354_RussianDollEnvelopes.maxEnvelopes(Array(
      Array(4, 5), Array(4, 6), Array(6, 7), Array(2, 3), Array(1, 1)
    )) == 4)
    assert(_354_RussianDollEnvelopes.maxEnvelopes(Array(
      Array(5, 4), Array(6, 4), Array(6, 7), Array(2, 3)
    )) == 3)
    assert(_354_RussianDollEnvelopes.maxEnvelopes(Array(Array(1, 1))) == 1)
    assert(_354_RussianDollEnvelopes.maxEnvelopes(Array.empty) == 0)
  }
  
  test("363. Max Sum of Rectangle No Larger Than K") {
    assert(_363_MaxSumOfRectangleNoLargerThanK.maxSumSubmatrix(Array(Array(1, 0, 1), Array(0, -2, 3)), 2) == 2)
    assert(_363_MaxSumOfRectangleNoLargerThanK.maxSumSubmatrix(Array(Array(2, 2, -1)), 0) == -1)
  }
  
  test("472. Concatenated Words") {
    assert(_472_ConcatenatedWords.findAllConcatenatedWordsInADict(Array.empty) == Nil)
    assert(_472_ConcatenatedWords.findAllConcatenatedWordsInADict(Array(
      "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"
    )) == List("catsdogcats", "dogcatsdog", "ratcatdogcat"))
  }
  
  test("MockExam_20191130_3") {
    assert(_909_SnakesAndLadders.snakesAndLadders(Array(
      Array(-1, -1, -1, -1, -1, -1),
      Array(-1, -1, -1, -1, -1, -1),
      Array(-1, -1, -1, -1, -1, -1),
      Array(-1, 35, -1, -1, 13, -1),
      Array(-1, -1, -1, -1, -1, -1),
      Array(-1, 15, -1, -1, -1, -1)
    )) == 4)
    /*[[-1,-1,2,-1],[14,2,12,3],[4,9,1,11],[-1,2,1,16]]*/
    assert(_909_SnakesAndLadders.snakesAndLadders(Array(
      Array(-1, -1, 2, -1),
      Array(14, 2, 12, 3),
      Array(4, 9, 1, 11),
      Array(-1, 2, 1, 16)
    )) == 1)
    /*[[-1,-1,30,14,15,-1],[23,9,-1,-1,-1,9],
    [12,5,7,24,-1,30],[10,-1,-1,-1,25,17],
    [32,-1,28,-1,-1,32],
    [-1,-1,23,-1,13,19]]*/
    assert(_909_SnakesAndLadders.snakesAndLadders(Array(
      Array(-1, -1, 30, 14, 15, -1),
      Array(23, 9, -1, -1, -1, 9),
      Array(12, 5, 7, 24, -1, 30),
      Array(10, -1, -1, -1, 25, 17),
      Array(32, -1, 28, -1, -1, 32),
      Array(-1, -1, 23, -1, 13, 19)
    )) == 2)
  }
  
  test("514. Freedom Trail") {
    assert(_514_FreedomTrail.findRotateSteps("pqwcx", "cpqwx") == 13)
    assert(_514_FreedomTrail.findRotateSteps("godding", "gd") == 4)
    assert(_514_FreedomTrail.findRotateSteps("abcde", "ade") == 6)
  }
  
  test("546. Remove Boxes") {
    assert(_546_RemoveBoxes.removeBoxes(Array(1, 3, 2, 2, 2, 3, 4, 3, 1)) == 23)
  }
  
  test("552. Student Attendance Record II") {
    assert(_552_StudentAttendanceRecordII.checkRecord(2) == 8)
    assert(_552_StudentAttendanceRecordII.checkRecord(100) == 985598218)
  }
  
  test("_801_MinimumSwapsToMakeSeqIncr") {
    assert(_801_MinimumSwapsToMakeSeqIncr.minSwap(Array(0, 3, 4, 9, 10), Array(2, 3, 7, 5, 6)) == 1)
    assert(_801_MinimumSwapsToMakeSeqIncr.minSwap(Array(0, 1, 8, 9, 10), Array(0, 5, 5, 8, 9)) == 1)
    assert(_801_MinimumSwapsToMakeSeqIncr.minSwap(Array(0, 4, 4, 5, 9), Array(0, 1, 6, 8, 10)) == 1)
  }
  
  test("740. Delete and Earn") {
    assert(_740_DeleteAndEarn.deleteAndEarn(Array(1, 1, 1, 2, 4, 5, 5, 5, 6)) == 18)
    assert(_740_DeleteAndEarn.deleteAndEarn(Array(3, 4, 2)) == 6)
    assert(_740_DeleteAndEarn.deleteAndEarn(Array(2, 2, 3, 3, 3, 4)) == 9)
  }
  
  test("698. Partition to K Equal Sum Subsets") {
    assert(_698_PartitionToKEqSumSubsets.canPartitionKSubsets(Array(4, 3, 2, 3, 5, 2, 1), 4))
  }
  
  test("712. Minimum ASCII Delete Sum for Two Strings") {
    assert(_712_MinimumAsciiDel.minimumDeleteSum("", "") == 0)
    assert(_712_MinimumAsciiDel.minimumDeleteSum("sea", "eat") == 231)
    assert(_712_MinimumAsciiDel.minimumDeleteSum("delete", "leet") == 403)
  }
  
  test("790. Domino and Tromino Tiling") {
    //    assert(_790_DominoAndTrominoTiling.numTilings(3) == 5)
    //    assert(_790_DominoAndTrominoTiling.numTilings(4) == 11)
    assert(_790_DominoAndTrominoTiling.numTilings(5) == 24)
    assert(_790_DominoAndTrominoTiling.numTilings(6) == 53)
    assert(_790_DominoAndTrominoTiling.numTilings(7) == 117)
    assert(_790_DominoAndTrominoTiling.numTilings(1000) == 979232805)
  }
  
  test("787. Cheapest Flights Within K Stops") {
    assert(_787_CheapestFlightsWithKStops.findCheapestPrice(3, Array(
      Array(0, 1, 100), Array(1, 2, 100), Array(0, 2, 500)
    ), 0, 2, 1) == 200)
    assert(_787_CheapestFlightsWithKStops.findCheapestPrice(3, Array(
      Array(0, 1, 100), Array(1, 2, 100), Array(0, 2, 500)
    ), 0, 2, 0) == 500)
    assert(_787_CheapestFlightsWithKStops.findCheapestPrice(5, Array(
      Array(4, 1, 1), Array(1, 2, 3), Array(0, 3, 2), Array(0, 4, 10), Array(3, 1, 1), Array(1, 4, 3)
    ), 2, 1, 1) == -1)
  }
  
  test("_764_LargestPlusSign") {
    assert(_764_LargestPlusSign.orderOfLargestPlusSign(5, Array(Array(4, 2))) == 2)
    assert(_764_LargestPlusSign.orderOfLargestPlusSign(2, Array.empty) == 1)
    assert(_764_LargestPlusSign.orderOfLargestPlusSign(1, Array(Array(0, 0))) == 0)
    assert(_764_LargestPlusSign.orderOfLargestPlusSign(10, Array(
      Array(0, 0), Array(0, 1), Array(0, 2), Array(0, 7),
      Array(1, 2), Array(1, 3), Array(1, 9),
      Array(2, 3), Array(2, 5), Array(2, 7), Array(2, 8),
      Array(3, 2), Array(3, 5), Array(3, 7),
      Array(4, 2), Array(4, 3), Array(4, 5), Array(4, 7),
      Array(5, 1), Array(5, 4), Array(5, 8), Array(5, 9),
      Array(7, 2), Array(7, 5), Array(7, 7), Array(7, 8),
      Array(8, 5), Array(8, 8),
      Array(9, 0), Array(9, 1), Array(9, 2), Array(9, 8)
    )) == 4)
    assert(_764_LargestPlusSign.orderOfLargestPlusSign(10, Array(
      Array(1, 2), Array(1, 8),
      Array(2, 4),
      Array(4, 7),
      Array(5, 0), Array(5, 6),
      Array(6, 4), Array(6, 9)
    )) == 4)
    assert(_764_LargestPlusSign.orderOfLargestPlusSign(10, Array(
      Array(0, 0), Array(0, 1), Array(0, 2), Array(0, 4), Array(0, 5), Array(0, 8), Array(0, 9),
      Array(1, 0), Array(1, 1), Array(1, 3), Array(1, 5), Array(1, 6), Array(1, 7), Array(1, 9),
      Array(2, 0), Array(2, 1), Array(2, 2), Array(2, 4), Array(2, 5), Array(2, 6), Array(2, 7), Array(2, 8),
      Array(3, 0), Array(3, 1), Array(3, 2), Array(3, 4), Array(3, 5), Array(3, 7), Array(3, 8),
      Array(4, 0), Array(4, 1), Array(4, 2), Array(4, 4), Array(4, 8), Array(4, 9),
      Array(5, 0), Array(5, 1), Array(5, 2), Array(5, 3), Array(5, 4), Array(5, 6), Array(5, 8), Array(5, 9),
      Array(6, 0), Array(6, 1), Array(6, 2), Array(6, 3), Array(6, 5), Array(6, 7), Array(6, 8), Array(6, 9),
      Array(7, 0), Array(7, 1), Array(7, 6), Array(7, 7), Array(7, 8), Array(7, 9),
      Array(8, 0), Array(8, 1), Array(8, 2), Array(8, 5), Array(8, 9),
      Array(9, 1), Array(9, 3), Array(9, 4), Array(9, 5), Array(9, 6), Array(9, 8)
    )) == 2)
  }
  
  test("730. Count Different Palindromic Subsequences") {
    assert(_730_CountDifferentPalinSub.countPalindromicSubsequences("a") == 1)
    assert(_730_CountDifferentPalinSub.countPalindromicSubsequences("bccb") == 6)
    assert(_730_CountDifferentPalinSub.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba") == 104860361)
    assert(_730_CountDifferentPalinSub.countPalindromicSubsequences("bddaabdbbccdcdcbbdbddccbaaccabbcacbadbdadbccddccdbdbdbdabdbddcccadddaaddbcbcbabdcaccaacabdbdaccbaacc") == 744991227)
  }
  
  test("691. Stickers to Spell Word") {
    assert(_691_StickersToSpellWord.minStickers(Array("notice", "possible"), "basicbasic") == -1)
    assert(_691_StickersToSpellWord.minStickers(Array("with", "example", "science"), "thehat") == 3)
    assert(_691_StickersToSpellWord.minStickers(Array("these", "guess", "about", "garden", "him"), "atomher") == 3)
    assert(_691_StickersToSpellWord.minStickers(Array("and","pound","force","human","fair",
      "back","sign","course","sight","world","close","saw","best","fill","late","silent",
      "open","noon","seat","cell","take","between","it","hundred","hat","until","either",
      "play","triangle","stay","separate","season","tool","direct","part","student","path","ear","grow",
      "ago","main","was","rule","element","thing","place","common","led","support","mean"), "quietchord") == -1)
    assert(_691_StickersToSpellWord.minStickers(Array("sail", "just", "point", "over", "hard", "share", "say", "distant",
      "proper", "occur", "before", "whose", "guess", "lead", "prove", "pattern",
      "six", "fat", "add", "music", "grand", "show", "final", "hope", "listen",
      "week", "picture", "buy", "run", "though", "between", "serve", "here",
      "nation", "forward", "stick", "decide", "post", "ear", "than", "he",
      "word", "would", "band", "many", "well", "gun", "wish", "toward", "think"), "governgreat") == 3)
  }
  
}
