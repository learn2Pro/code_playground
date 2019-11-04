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
  
  test("457. Circular Array Loop") {
    assert(ArrayCircular.circularArrayLoop(Array(3, 1, 2)) == true)
    assert(ArrayCircular.circularArrayLoop(Array(2, -1, 1, 2, 2)) == true)
    assert(ArrayCircular.circularArrayLoop(Array(-1, 2)) == false)
    assert(ArrayCircular.circularArrayLoop(Array(-2, 1, -1, -2, -2)) == false)
  }
  
  test("1004. Max Consecutive Ones III") {
    assert(MaxConsecOnesIII.longestOnes(Array(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2) == 6)
    assert(MaxConsecOnesIII.longestOnes(Array(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3) == 10)
  }
  
  test("532. K-diff Pairs in an Array") {
    assert(KDiffPairInArray.findPairs(Array(3, 1, 4, 1, 5), 2) == 2)
    assert(KDiffPairInArray.findPairs(Array(1, 3, 1, 5, 4), 0) == 1)
    assert(KDiffPairInArray.findPairs(Array(1, 1, 1, 2, 2), 0) == 2)
  }
  
  test("560. Subarray Sum Equals K") {
    assert(SubArrSumEqK.subarraySum(Array(-1, -1, 1), 0) == 1)
  }
  
  test("581. Shortest Unsorted Continuous Subarray") {
    assert(ShortestUnsortedSubArray.findUnsortedSubarray(Array(1)) == 0)
    assert(ShortestUnsortedSubArray.findUnsortedSubarray(Array(1, 2, 3, 4)) == 0)
    assert(ShortestUnsortedSubArray.findUnsortedSubarray(Array(2, 6, 4, 8, 10, 9, 15)) == 5)
  }
  
  test("605. Can Place Flowers") {
    //    assert(PlaceFlowers.canPlaceFlowers(Array(1), 0) == true)
    //    assert(PlaceFlowers.canPlaceFlowers(Array(1, 0, 0, 0, 1), 1) == true)
    //    assert(PlaceFlowers.canPlaceFlowers(Array(1, 0, 0, 0, 1), 2) == false)
    assert(PlaceFlowers.canPlaceFlowers(Array(0, 0, 1, 0, 0), 1) == true)
  }
  
  test("621. Task Scheduler") {
    assert(TaskScheduler.leastInterval(Array('A', 'A', 'A', 'B', 'B', 'B'), 2) == 8)
    assert(TaskScheduler.leastInterval(Array('A', 'A', 'A', 'B', 'B', 'B', 'C', 'C'), 1) == 8)
    assert(TaskScheduler.leastInterval(Array('A', 'A', 'A', 'B', 'B', 'B', 'C', 'C'), 3) == 10)
    assert(TaskScheduler.leastInterval(Array('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'), 2) == 16)
  }
  
  test("643. Maximum Average Subarray I") {
    //    assert(MaximumAverage.findMaxAverage(Array(1, 12, -5, -6, 50, 3), 4) == 12.75)
    assert(MaximumAverage.findMaxAverage(Array(4, 2, 1, 3, 3), 2) == 3.0)
  }
  
  test("665. Non-decreasing Array") {
    assert(NonDscArray.checkPossibility(Array(4, 2, 3)) == true)
    assert(NonDscArray.checkPossibility(Array(3, 4, 2, 3)) == false)
    assert(NonDscArray.checkPossibility(Array(2, 3, 3, 2, 4)) == true)
  }
  
  test("667. Beautiful Arrangement II") {
    assert(BeautifulArrange.constructArray(3, 2) sameElements Array(1, 3, 2))
    assert(BeautifulArrange.constructArray(6, 3) sameElements Array(1, 2, 3, 6, 4, 5))
  }
  
  test("670. Maximum Swap") {
    assert(MaximumSwap.maximumSwap(9973) == 9973)
    assert(MaximumSwap.maximumSwap(9793) == 9973)
    assert(MaximumSwap.maximumSwap(2736) == 7236)
  }
  
  
}
