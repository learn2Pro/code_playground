/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.heap

import category.greedy._
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version HeapTest.scala, v 0.1 2020年01月27日 13:44 tang Exp $
  */
class HeapTest extends FunSuite {
  
  test("_215_Solution") {
    assert(_215_Solution.findKthLargest(Array(3, 3, 3, 3, 3, 3, 3, 3, 3), 1) == 3)
    assert(_215_Solution.findKthLargest(Array(7, 6, 5, 4, 3, 2, 1), 5) == 3)
    assert(_215_Solution.findKthLargest(Array(3, 2, 3, 1, 2, 4, 5, 5, 6), 9) == 1)
    assert(_215_Solution.findKthLargest(Array(2, 1), 1) == 2)
    assert(_215_Solution.findKthLargest(Array(1), 1) == 1)
    assert(_215_Solution.findKthLargest(Array(3, 2, 3, 1, 2, 4, 5, 5, 6), 4) == 4)
    assert(_215_Solution.findKthLargest(Array(3, 2, 1, 5, 6, 4), 2) == 5)
  }
  
  test("QuickSort") {
    assert(QuickSort.sort(Array(3, 3, 3, 3, 3)) sameElements Array(3, 3, 3, 3, 3))
    assert(QuickSort.sort(Array(1)) sameElements Array(1))
    assert(QuickSort.sort(Array(2, 1)) sameElements Array(1, 2))
    assert(QuickSort.sort(Array(3, 2, 3, 1, 2, 4, 5, 5, 6)) sameElements Array(1, 2, 2, 3, 3, 4, 5, 5, 6))
  }
  
  test("_402_Solution") {
    assert(_402_Solution.removeKdigits("10200", 4) == "0")
    assert(_402_Solution.removeKdigits("10200", 5) == "0")
    assert(_402_Solution.removeKdigits("10200", 1) == "200")
    assert(_402_Solution.removeKdigits("1432219", 3) == "1219")
    assert(_402_Solution.removeKdigits("10", 2) == "0")
  }
  
  test("_435_Solution") {
    assert(_435_Solution.eraseOverlapIntervals(Array(
      Array(1, 3), Array(0, 2), Array(2, 4), Array(3, 5), Array(4, 6)
    )) == 2)
    assert(_435_Solution.eraseOverlapIntervals(Array(
      Array(1, 3), Array(0, 2), Array(3, 5), Array(2, 4), Array(4, 6)
    )) == 2)
    assert(_435_Solution.eraseOverlapIntervals(Array(
      Array(0, 2), Array(1, 3), Array(2, 4), Array(3, 5), Array(4, 6)
    )) == 2)
  }
  test("_649_Solution") {
    assert(_649_Solution.predictPartyVictory(
      "DRDDRRRDDDDDRRRRRRRRDDDDDDDDDDDDD" +
              "RRRRRRRRRRRRRRRRRRRRRDDDDDDDDDDDD" +
              "DDDDDDDDDDDDDDDDDDDDDDRRRRRRRRRRR" +
              "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" +
              "RRRRRRRRRRRDDDDDDDDDDDDDDDDDDDDDD" +
              "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" +
              "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" +
              "DRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" +
              "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" +
              "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" +
              "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" +
              "RRRRRRRRRRRRRDDDDDDDDDDDDDDDDDDDD" +
              "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" +
              "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" +
              "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" +
              "DDDDDDDDDD"
    ) == "Dire")
  }
  
  test("_757_Solution") {
    assert(_757_Solution.intersectionSizeTwo(Array(
      Array(1, 3), Array(1, 4), Array(2, 5), Array(3, 5)
    )) == 3)
    assert(_757_Solution.intersectionSizeTwo(Array(
      Array(1, 2), Array(2, 3), Array(2, 4), Array(4, 5)
    )) == 5)
  }
  
  test("_763_Solution") {
    assert(_763_Solution.partitionLabels("caedbdedda") == List(1, 9))
    assert(_763_Solution.partitionLabels("ababcbacadefegdehijhklij") == List(9, 7, 8))
  }
  
  test("_765_Solution") {
    assert(_765_Solution.minSwapsCouples(Array(0, 2, 1, 3)) == 1)
    assert(_765_Solution.minSwapsCouples(Array(3, 2, 0, 1)) == 0)
  }
}
