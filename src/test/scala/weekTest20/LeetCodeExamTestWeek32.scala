package weekTest20

import org.scalatest.FunSuite
import week32.SearchInRotatedArray

/**
  * @author tang
  * @date 2019/08/03
  */
class LeetCodeExamTestWeek32 extends FunSuite {

  /**
    * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    *
    * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
    *
    * You are given a target value to search. If found in the array return its index, otherwise return -1.
    *
    * You may assume no duplicate exists in the array.
    *
    * Your algorithm's runtime complexity must be in the order of O(log n).
    *
    * Example 1:
    *
    * Input: nums = [4,5,6,7,0,1,2], target = 0
    * Output: 4
    * Example 2:
    *
    * Input: nums = [4,5,6,7,0,1,2], target = 3
    * Output: -1
    */
  test("Search in Rotated Sorted Array") {
//    assert(SearchInRotatedArray.search(Array(4, 5, 6, 7, 0, 1, 2), 0) == 4)
//        assert(SearchInRotatedArray.search(Array(4, 5, 6, 7, 0, 1, 2), 3) == -1)
//        assert(SearchInRotatedArray.search(Array(4, 5, 6, 7, 0, 1, 3), 3) == 6)
        assert(SearchInRotatedArray.search(Array(1), 1) == 0)
//        assert(SearchInRotatedArray.search(Array(1, 3), 3) == 1)
//    assert(SearchInRotatedArray.search(Array(1, 3,5), 5) == 2)
  }

}
