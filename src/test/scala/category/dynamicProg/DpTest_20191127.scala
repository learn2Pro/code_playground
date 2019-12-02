/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.dynamicProg

import category.bfs._900_1000._909_SnakesAndLadders
import category.dp._300_400.{_321_CreateMaximumNumber, _354_RussianDollEnvelopes, _363_MaxSumOfRectangleNoLargerThanK}
import category.dp._400_500._472_ConcatenatedWords
import category.dp._500_600.{_514_FreedomTrail, _546_RemoveBoxes, _552_StudentAttendanceRecordII}
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
  
}
