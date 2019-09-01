package weekTest20


import org.scalatest.FunSuite
import week29.TreeNode
import week32._
import week33.{CombinationSum, CombinationSum3, FirstMissPositive}

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
    assert(SearchInRotatedArray.search(Array(4, 5, 6, 7, 0, 1, 2), 0) == 4)
    assert(SearchInRotatedArray.search(Array(4, 5, 6, 7, 0, 1, 2), 3) == -1)
    assert(SearchInRotatedArray.search(Array(4, 5, 6, 7, 0, 1, 3), 3) == 6)
    assert(SearchInRotatedArray.search(Array(1), 1) == 0)
    assert(SearchInRotatedArray.search(Array(1), 0) == -1)
    assert(SearchInRotatedArray.search(Array(1, 3), 3) == 1)
    assert(SearchInRotatedArray.search(Array(1, 3, 5), 5) == 2)
    assert(SearchInRotatedArray.search(Array(5, 1, 3), 1) == 1)
    assert(SearchInRotatedArray.search(Array(5, 1, 3), 3) == 2)
    assert(SearchInRotatedArray.search(Array(1, 2, 3, 4, 6), 4) == 3)
    assert(SearchInRotatedArray.search(Array(1, 2, 3, 4, 6), 6) == 4)
    assert(SearchInRotatedArray.search(Array(1, 2, 3, 4, 6, 7, 8, 9), 9) == 7)
    assert(SearchInRotatedArray.search(Array(9, 10, 1, 2, 3, 4, 5, 6, 7), 7) == 8)
    assert(SearchInRotatedArray.search(Array(4, 5, 6, 7, 8, 9, 1, 2, 3), 1) == 6)
    assert(SearchInRotatedArray.search(Array(6, 8, 9, 1, 2, 3, 4, 5), 9) == 2)
    assert(SearchInRotatedArray.search(Array(7, 8, 1, 2, 3, 4, 5, 6), 2) == 3)
  }

  /**
    * Given a sorted array and a target value, return
    * the index if the target is found. If not, return the index where it would be if it were inserted in order.
    * You may assume no duplicates in the array.
    * *
    * Example 1:
    * *
    * Input: [1,3,5,6], 5
    * Output: 2
    * Example 2:
    * *
    * Input: [1,3,5,6], 2
    * Output: 1
    * Example 3:
    * *
    * Input: [1,3,5,6], 7
    * Output: 4
    * Example 4:
    * *
    * Input: [1,3,5,6], 0
    * Output: 0
    */
  test(" Search Insert Position") {
    assert(SearchInsertPosition.searchInsert(Array(1, 3, 5, 6), 5) == 2)
    assert(SearchInsertPosition.searchInsert(Array(1, 3, 5, 6), 2) == 1)
    assert(SearchInsertPosition.searchInsert(Array(1, 3, 5, 6), 7) == 4)
    assert(SearchInsertPosition.searchInsert(Array(1, 3, 5, 6), 0) == 0)
  }

  /**
    * The count-and-say sequence is the sequence of integers with the first five terms as following:
    * *
    *1.     1
    *2.     11
    *3.     21
    *4.     1211
    *5.     111221
    * 1 is read off as "one 1" or 11.
    * 11 is read off as "two 1s" or 21.
    * 21 is read off as "one 2, then one 1" or 1211.
    * *
    * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
    * *
    * Note: Each term of the sequence of integers will be represented as a string.
    * *
    *
    *
    * Example 1:
    * *
    * Input: 1
    * Output: "1"
    * Example 2:
    * *
    * Input: 4
    * Output: "1211"
    */
  test("38. Count and Say") {
    CountAndSay.countAndSay(30)
  }

  test("34. Find First and Last Position of Element in Sorted Array") {
    println(SearchRangeInSortedArr.searchRange(Array(2, 2), 3).toList)
    println(SearchRangeInSortedArr.searchRange(Array(1, 3), 1).toList)
    println(SearchRangeInSortedArr.searchRange(Array(5, 7, 7, 8, 8, 10), 8).toList)
    println(SearchRangeInSortedArr.searchRange(Array(5, 7, 7, 8, 8, 10), 6).toList)
  }

  test("94. Binary Tree Inorder Traversal") {
    val root = new TreeNode(1)
    val right = new TreeNode(2)
    val rightLeft = new TreeNode(3)
    root.right = right
    right.left = rightLeft
    assert(BTreeTraversal.inorderTraversal(root) == List(1, 3, 2))
  }

  test("98. Validate Binary Search Tree") {
    val root = new TreeNode(3)
    val left = new TreeNode(1)
    val right = new TreeNode(5)
    val left0 = new TreeNode(0)
    val left1 = new TreeNode(2)
    val right0 = new TreeNode(4)
    val right1 = new TreeNode(6)
    root.right = right
    root.left = left
    right.left = right0
    right.right = right1
    left.left = left0
    left.right = left1
    assert(BSTValidate.isValidBST(root) == true)
  }

  test("36. Valid Sudoku") {
    val board = Array(
      Array("8", "3", ".", ".", "7", ".", ".", ".", "."),
      Array("6", ".", ".", "1", "9", "5", ".", ".", "."),
      Array(".", "9", "8", ".", ".", ".", ".", "6", "."),
      Array("8", ".", ".", ".", "6", ".", ".", ".", "3"),
      Array("4", ".", ".", "8", ".", "3", ".", ".", "1"),
      Array("7", ".", ".", ".", "2", ".", ".", ".", "6"),
      Array(".", "6", ".", ".", ".", ".", "2", "8", "."),
      Array(".", ".", ".", "4", "1", "9", ".", ".", "5"),
      Array(".", ".", ".", ".", "8", ".", ".", "7", "9")
    )
    assert(ValidSudoku.isValidSudoku(board.map(_.map(_.charAt(0)))) == true)
  }

  test("37. Sudoku Solver") {
    //    val board = Array(
    //      Array("5", "3", ".", ".", "7", ".", ".", ".", "."),
    //      Array("6", ".", ".", "1", "9", "5", ".", ".", "."),
    //      Array(".", "9", "8", ".", ".", ".", ".", "6", "."),
    //      Array("8", ".", ".", ".", "6", ".", ".", ".", "3"),
    //      Array("4", ".", ".", "8", ".", "3", ".", ".", "1"),
    //      Array("7", ".", ".", ".", "2", ".", ".", ".", "6"),
    //      Array(".", "6", ".", ".", ".", ".", "2", "8", "."),
    //      Array(".", ".", ".", "4", "1", "9", ".", ".", "5"),
    //      Array(".", ".", ".", ".", "8", ".", ".", "7", "9")
    //    )
    val board = Array(
      Array(".", ".", ".", "2", ".", ".", ".", "6", "3"),
      Array("3", ".", ".", ".", ".", "5", "4", ".", "1"),
      Array(".", ".", "1", ".", ".", "3", "9", "8", "."),
      Array(".", ".", ".", ".", ".", ".", ".", "9", "."),
      Array(".", ".", ".", "5", "3", "8", ".", ".", "."),
      Array(".", "3", ".", ".", ".", ".", ".", ".", "."),
      Array(".", "2", "6", "3", ".", ".", "5", ".", "."),
      Array("5", ".", "3", "7", ".", ".", ".", ".", "8"),
      Array("4", "7", ".", ".", ".", "1", ".", ".", ".")
    )
    val transform = board.map(_.map(_.charAt(0)))
    new SolveSudoku(transform).solveSudoku()
    //    SolveSudoku.solveSudoku(board.map(_.map(_.charAt(0))))
    println(transform.map(_.toList).toList)
  }

  test("39. Combination Sum") {
    //    println(CombinationSum.combinationSum(Array(2, 3, 6, 7), 7))
    //    println(CombinationSum.combinationSum(Array(2, 3, 5, 7), 8))
    //    println(CombinationSum.combinationSum(Array(3, 5, 7), 9))
    //    println(CombinationSum.combinationSum(Array(8, 7, 4, 3), 11))
    println(CombinationSum.combinationSum(Array(10, 1, 2, 7, 6, 1, 5), 8))
  }

  test("216. Combination Sum III") {
    println(CombinationSum3.combinationSum3(3, 7))
    println(CombinationSum3.combinationSum3(3, 9))
  }

  test("41. First Missing Positive") {
//    assert(FirstMissPositive.firstMissingPositive(Array(1, 2, 0)) == 3)
//    assert(FirstMissPositive.firstMissingPositive(Array(3, 4, -1, 1)) == 2)
//    assert(FirstMissPositive.firstMissingPositive(Array(7, 8, 9, 11, 12)) == 1)
    assert(FirstMissPositive.firstMissingPositive(Array(0,2,2,4,0,1,0,1,3)) == 5)
  }

}
