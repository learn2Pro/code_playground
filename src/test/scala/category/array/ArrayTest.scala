/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array

import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version ArrayTest.scala, v 0.1 2019年10月28日 23:18 tang Exp $
  */
class ArrayTest extends FunSuite {
  
  test("209. Minimum Size Subarray Sum") {
    assert(MiniSubArraySum.minSubArrayLen(1, Array(1, 2)) == 1)
    assert(MiniSubArraySum.minSubArrayLen(1, Array(1)) == 1)
    assert(MiniSubArraySum.minSubArrayLen(7, Array(2, 3, 1, 2, 4, 3)) == 2)
  }
  
  test("219. Contains Duplicate II") {
    assert(ContainsDuplicateII.containsNearbyDuplicate(Array(1, 0, 1, 1), 1) == true)
  }
  
  test("289. Game of Life") {
    val b = Array(
      Array(0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0), Array(0, 0, 1, 1, 1, 0),
      Array(0, 1, 1, 1, 0, 0), Array(0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0)
    )
    GameOfLife.gameOfLife(b)
    assert(b sameElements b)
  }
  
  test("381. Insert Delete GetRandom O(1) - Duplicates allowed") {
    val col = new RandomizedCollection
    col.insert(0)
    col.remove(0)
    col.insert(-1)
    col.remove(0)
    col.getRandom()
    col.getRandom()
    col.getRandom()
    col.getRandom()
    col.getRandom()
    //    col.insert(0)
    //    col.insert(1)
    //    col.remove(0)
    //    col.insert(2)
    //    col.remove(1)
    //    col.getRandom()
  }
  
  test("442. Find All Duplicates in an Array") {
    assert(DuplicateNumberFinderII.findDuplicates(Array(4, 3, 2, 7, 8, 2, 3, 1)) == List(3, 2))
    assert(DuplicateNumberFinderII.findDuplicates(Array(1, 1)) == List(1))
    assert(DuplicateNumberFinderII.findDuplicates(Array(2, 2)) == List(2))
    assert(DuplicateNumberFinderII.findDuplicates(Array(2, 1)) == Nil)
  }
  
  
}
