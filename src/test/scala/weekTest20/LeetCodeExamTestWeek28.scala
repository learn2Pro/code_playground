package weekTest20

import org.scalatest.FunSuite
import week28._

/**
  * @author tang
  * @date 2019/07/13
  */
class LeetCodeExamTestWeek28 extends FunSuite {

  test("3Sum") {
    //    val ans = ThreeSumSolution.threeSum(Array(-1, 0, 1, 2, -1, -4))
    //    val ans = ThreeSumSolution.threeSum(Array(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6))
    //    val ans = ThreeSumSolution.threeSum(Array(-1, 0, 1, 2, -1, -4))
    //    val ans = ThreeSumSolution.threeSum(Array(-1, 0, 1, 0))
    val ans = ThreeSumSolution.threeSum(Array(-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0))
    ans
  }

  test("3Sum Closest") {
    //    val ans = ThreeSumSolution.threeSum(Array(-1, 0, 1, 2, -1, -4))
    //    val ans = ThreeSumSolution.threeSum(Array(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6))
    //    val ans = ThreeSumSolution.threeSum(Array(-1, 0, 1, 2, -1, -4))
    //    val ans = ThreeSumSolution.threeSum(Array(-1, 0, 1, 0))
    //    val ans = ThreeSumClosetSolution.threeSumClosest(Array(-1, 2, 1, 4), 1)
    val ans = ThreeSumClosetSolution.threeSumClosest(Array(-1, -5, -3, -4, 2, -2), 0)
    ans
  }

  test("Letter Combinations of a Phone Number") {
    val ans = LetterCombinationSolution.letterCombinations("23")
    ans
  }

  test("Binary Watch") {
    val ans = BinaryWatchSolution.readBinaryWatch(1)
    ans
  }

  test("4Sum") {
    //    val ans = FourSumSolution.fourSum(Array(1, 0, -1, 0, -2, 2), 0)
    val ans = FourSumSolution.fourSum(Array(2, 1, 0, -1), 0)
    ans
  }

  test("Remove Nth Node From End of List") {
    //    val l0 = new week27.ListNode(1)
    //    val l1 = new week27.ListNode(2)
    //    val l2 = new week27.ListNode(3)
    //    val l3 = new week27.ListNode(4)
    //    val l4 = new week27.ListNode(5)
    //    l0.next = l1
    //    l1.next = l2
    //    l2.next = l3
    //    l3.next = l4
    //    RemoveNthBackNodeSolution.removeNthFromEnd(l0, 2)

    val l0 = new week27.ListNode(1)
    RemoveNthBackNodeSolution.removeNthFromEnd(l0, 1)
  }

  test(" Valid Parentheses") {
    //    ValidParenthesesSolution.isValid("()")
    ValidParenthesesSolution.isValid("]")
  }

  test(" Longest Valid Parentheses") {
    //        assert(LongestValidParenthesesSolution.longestValidParentheses("(()") == 2)
    //        assert(LongestValidParenthesesSolution.longestValidParentheses(")()())") == 4)
    //        assert(LongestValidParenthesesSolution.longestValidParentheses("()(())") == 6)
    //        assert(LongestValidParenthesesSolution.longestValidParentheses("(()())") == 6)
    assert(LongestValidParenthesesSolution.longestValidParentheses("((()))())") == 8)
    //    assert(LongestValidParenthesesSolution.longestValidParentheses(")(((((()())()()))()(()))(") == 22)
  }

  test("Generate Parentheses") {
    val ans = GenerateParenthesesSolution.generateParenthesis(3)
    ans
  }

  test(" N-Queens") {
    //    val ans = NQueenSolution.solveNQueens(4)
    val ans = NQueenSolution.solveNQueens(5)
    ans
  }

  test(" N-Queens 2") {
    //    val ans = NQueenSolution.solveNQueens(4)
    val ans = NQueen2_Solution.totalNQueens(5)
    ans
  }

  test("Relative Sort Array") {
    RelativeSortArrSolution.relativeSortArray(Array(33, 22, 48, 4, 39, 36, 41, 47, 15, 45), Array(
      22, 33, 48, 4))
  }

  /**
    * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    *
    * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
    *
    * The replacement must be in-place and use only constant extra memory.
    *
    * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    */
  test("Next Permutation") {
    NextPermutationSolution.nextPermutation(Array(1, 3, 2))
    NextPermutationSolution.nextPermutation(Array(1, 2, 3))
    NextPermutationSolution.nextPermutation(Array(4, 2, 0, 2, 3, 2, 0))
    NextPermutationSolution.nextPermutation(Array(2, 3, 1))
    NextPermutationSolution.nextPermutation(Array(3, 2, 1))
    NextPermutationSolution.nextPermutation(Array(1, 1, 5))
    NextPermutationSolution.nextPermutation(Array(1, 2, 6, 5, 5, 4))
    println("end")
  }

}
