/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.heap

import category.backtrack._282_Solution
import category.greedy._
import category.segment_tree.{MyCalendarThree, MyCalendarTwo, _699_Solution}
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
  
  test("_218_Solution") {
    assert(_218_Solution.getSkyline(Array(
      Array(2, 9, 10), Array(3, 7, 15), Array(5, 12, 12), Array(15, 20, 10), Array(19, 24, 8)
    )) == List(List(2, 10), List(3, 15), List(7, 12), List(12, 0), List(15, 10), List(20, 8), List(24, 0)))
  }
  
  test("_699_Solution") {
    assert(_699_Solution.fallingSquares(Array(Array(1, 2), Array(2, 3), Array(4, 8), Array(6, 1))) == List(2, 5, 13, 14))
    assert(_699_Solution.fallingSquares(Array(Array(1, 2), Array(2, 3), Array(6, 1))) == List(2, 5, 5))
    assert(_699_Solution.fallingSquares(Array(Array(100, 100), Array(200, 100))) == List(100, 100))
    assert(_699_Solution.fallingSquares(Array(Array(1, 1), Array(2, 3), Array(6, 1))) == List(1, 3, 3))
  }
  
  test("MyCalendarThree") {
    val instance = new MyCalendarThree
    assert(instance.book(10, 20) == 1)
    assert(instance.book(50, 60) == 1)
    assert(instance.book(10, 40) == 2)
    assert(instance.book(5, 15) == 3)
    assert(instance.book(5, 10) == 3)
    assert(instance.book(25, 55) == 3)
  }
  
  /**
    * ["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book"]
    * [[],[24,40],[43,50],[27,43],[5,21],[30,40],[14,29],[3,19],[3,14],[25,39],[6,19]]
    *
    * [null,true,true,true,true,false,false,true,false,false,false]
    */
  test("MyCalendarTwo") {
    val instance = new MyCalendarTwo
    /*[[],[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]*/
    /*[null,true,true,true,false,true,true]*/
    assert(instance.book(10, 20))
    assert(instance.book(50, 60))
    assert(instance.book(10, 40))
    assert(!instance.book(5, 15))
    assert(instance.book(5, 10))
    assert(instance.book(25, 55))
    //    assert(instance.book(24, 40) == true)
    //    assert(instance.book(43, 50) == true)
    //    assert(instance.book(27, 43) == true)
    //    assert(instance.book(5, 21) == true)
    //    assert(instance.book(30, 40) == false)
    //    assert(instance.book(14, 29) == false)
    //    assert(instance.book(3, 19) == true)
    //    assert(instance.book(3, 14) == false)
    //    assert(instance.book(25, 39) == false)
    //    assert(instance.book(6, 19) == false)
  }
  
  test("_480_Solution") {
    assert(_480_Solution.medianSlidingWindow(Array(2147483647, 2147483647), 2) sameElements Array(2147483647))
    assert(_480_Solution.medianSlidingWindow(Array(
      -2147483648, -2147483648, 2147483647, -2147483648, -2147483648,
      -2147483648, 2147483647, 2147483647, 2147483647, 2147483647,
      -2147483648, 2147483647, -2147483648), 3) sameElements
            Array(-2147483648.0, -2147483648.0, -2147483648.0, -2147483648.0, -2147483648.0, 2147483647.0, 2147483647.0, 2147483647.0, 2147483647.0, 2147483647.0, -2147483648.0))
    assert(_480_Solution.medianSlidingWindow(Array(1, 2, 3, 4, 2, 3, 1, 4, 2), 3) sameElements Array(2.0, 3.0, 3.0, 3.0, 2.0, 3.0, 2.0))
    assert(_480_Solution.medianSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 3) sameElements Array(1, -1, -1, 3, 5, 6))
  }
  
  test("_282_Solution") {
    assert(_282_Solution.addOperators("105", 5) == List("10-5", "1*0+5"))
    assert(_282_Solution.addOperators("232", 8) == List("2*3+2", "2+3*2"))
    assert(_282_Solution.addOperators("123", 6) == List("1*2*3", "1+2+3"))
    assert(_282_Solution.addOperators("00", 0) == List("0*0", "0-0", "0+0"))
    assert(_282_Solution.addOperators("3456237490", 9191) == Nil)
  }
}
