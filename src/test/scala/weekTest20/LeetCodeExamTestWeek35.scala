package weekTest20

import org.scalatest.FunSuite
import category.timeline.week27.ListNode
import category.timeline.week35.RotateImage
import category.timeline.week36._

/**
  * @author tang
  * @date 2019/08/03
  */
class LeetCodeExamTestWeek35 extends FunSuite {

  test("48. Rotate Image 1.0") {
    //    val input0 = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
    //    RotateImage.rotate(input0)
    //    assert(input0 == Array(Array(7, 4, 1), Array(8, 5, 2), Array(9, 6, 3)))
    val input1 = Array(Array(5, 1, 9, 11), Array(2, 4, 8, 10), Array(13, 3, 6, 7), Array(15, 14, 12, 16))
    RotateImage.rotate(input1)
    assert(input1 == Array(Array(15, 13, 2, 5), Array(14, 3, 4, 1), Array(12, 6, 8, 9), Array(16, 7, 10, 11)))
  }

  test("120. Triangle") {
    assert(TriangleMinimumSumV1.minimumTotal(List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3))) == 11)
  }

  test("49. Group Anagrams") {
    println(GroupAnagrams.groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")))
    println(GroupAnagrams.groupAnagrams(Array("ray", "cod", "abe", "ned", "arc", "jar", "owl", "pop", "paw", "sky", "yup", "fed", "jul", "woo", "ado", "why", "ben", "mys", "den", "dem", "fat", "you", "eon", "sui", "oct", "asp", "ago", "lea", "sow", "hus", "fee", "yup", "eve", "red", "flo", "ids", "tic", "pup", "hag", "ito", "zoo")))
  }

  test("54. Spiral Matrix") {
    assert(SpiralMatrix.spiralOrder(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))) == List(1, 2, 3, 6, 9, 8, 7, 4, 5))
    assert(SpiralMatrix.spiralOrder(Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12))) == List(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
    assert(SpiralMatrix.spiralOrder(Array(Array(6, 9, 7))) == List(6, 9, 7))
  }

  test("59. Spiral Matrix II") {
    assert(SpiralMatrixII.generateMatrix(3).map(_.toList).toList == List(List(1, 2, 3), List(8, 9, 4), List(7, 6, 5)))
    assert(SpiralMatrixII.generateMatrix(1).map(_.toList).toList == List(List(1)))
    assert(SpiralMatrixII.generateMatrix(2).map(_.toList).toList == List(List(1, 2), List(4, 3)))
    assert(SpiralMatrixII.generateMatrix(4).map(_.toList).toList == List(List(1, 2), List(4, 3)))
    assert(SpiralMatrixII.generateMatrix(5).map(_.toList).toList == List(List(1, 2), List(4, 3)))
  }

  test("57. Insert Interval") {
    assert(InsertInterval.insert(Array(Array(1, 3), Array(6, 9)), Array(2, 5)).map(_.toList).toList == List(List(1, 5), List(6, 9)))
    assert(InsertInterval.insert(Array(
      Array(1, 2), Array(3, 5),
      Array(6, 7), Array(8, 10),
      Array(12, 16)
    ), Array(4, 8)
    ).map(_.toList).toList == List(List(1, 2), List(3, 10), List(12, 16)))
    assert(InsertInterval.insert(Array(
      Array(1, 5)
    ), Array(0, 3)
    ).map(_.toList).toList == List(List(0, 5)))

    assert(InsertInterval.insert(Array(
      Array(1, 5)
    ), Array(0, 8)
    ).map(_.toList).toList == List(List(0, 8)))

    assert(InsertInterval.insert(Array(
      Array(1, 5)
    ), Array(0, 0)
    ).map(_.toList).toList == List(List(0, 0), List(1, 5)))
    assert(InsertInterval.insert(Array(
      Array(2, 5)
    ), Array(0, 1)
    ).map(_.toList).toList == List(List(0, 1), List(2, 5)))
  }

  test("60. Permutation Sequence") {
    assert(PermutationSequence.getPermutation(3, 1) == "123")
    assert(PermutationSequence.getPermutation(3, 2) == "132")
    assert(PermutationSequence.getPermutation(3, 3) == "213")
    assert(PermutationSequence.getPermutation(3, 4) == "231")
    assert(PermutationSequence.getPermutation(3, 5) == "312")
    assert(PermutationSequence.getPermutation(3, 6) == "321")
    assert(PermutationSequence.getPermutation(4, 9) == "2314")
    assert(PermutationSequence.getPermutation(1, 1) == "1")
    assert(PermutationSequence.getPermutation(5, 0) == "12345")
    assert(PermutationSequence.getPermutation(5, 100) == "51342")
    assert(PermutationSequence.getPermutation(5, 120) == "54321")
    assert(PermutationSequence.getPermutation(4, 0) == "1234")
    assert(PermutationSequence.getPermutation(4, 24) == "4321")
  }

  test("63. Unique Paths II") {
    assert(UniquePathsII.uniquePathsWithObstacles(Array(Array(1, 0))) == 0)
    assert(UniquePathsII.uniquePathsWithObstacles(Array(Array(0, 0, 0), Array(0, 1, 0), Array(0, 0, 0))) == 2)
  }

  test("61. Rotate List") {
    val p0 = new ListNode(1)
    val p1 = new ListNode(2)
    val p2 = new ListNode(3)
    val p3 = new ListNode(4)
    val p4 = new ListNode(5)
    p0.next = p1
    p1.next = p2
    p2.next = p3
    p3.next = p4
    //    RotateList.rotateRight(p0, 1)
    RotateList.rotateRight(p0, 6)
    RotateList.rotateRight(p0, 1)
    RotateList.rotateRight(p0, 3)
    RotateList.rotateRight(p0, 4)
    RotateList.rotateRight(p0, 5)
  }

  test("65. Valid Number") {
    assert(ValidNumber.isNumber(".") == false)
  }

  test("68. Text Justification") {
    assert(TextJustification.fullJustify(
      Array("This", "is", "an", "example", "of", "text", "justification."), 16
    ) == List("This    is    an", "example  of text", "justification.  "))

    assert(TextJustification.fullJustify(
      Array("What", "must", "be", "acknowledgment", "shall", "be"), 16
    ) == List("What   must   be", "acknowledgment  ", "shall be        "))

    assert(TextJustification.fullJustify(
      Array("Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
        "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"), 20
    ) == List(
      "Science  is  what we", "understand      well",
      "enough to explain to", "a  computer.  Art is",
      "everything  else  we", "do                  ")
    )
  }

  test("70. Climbing Stairs") {
    assert(ClimbStairs.climbStairs(1) == 3)
    assert(ClimbStairs.climbStairs(2) == 3)
    assert(ClimbStairs.climbStairs(3) == 3)
    assert(ClimbStairs.climbStairs(4) == 3)
  }

  test("69. Sqrt(x)") {
    assert(SqrtX.mySqrt(4) == 2)
    assert(SqrtX.mySqrt(5) == 2)
  }

  test("71. Simplify Path") {
    //    assert(SimplifyPath.simplifyPath("/home/") == "/home")
    //    assert(SimplifyPath.simplifyPath("/../") == "/")
    assert(SimplifyPath.simplifyPath("/home//foo/") == "/home/foo")
    assert(SimplifyPath.simplifyPath("/a/./b/../../c/") == "/c")
    assert(SimplifyPath.simplifyPath("/a//b////c/d//././/..") == "/a/b/c")
    assert(SimplifyPath.simplifyPath("/...") == "/...")
  }

  test("72. Edit Distance") {
    assert(EditDistance.minDistance("horse", "ros") == 3)
    assert(EditDistance.minDistance("sea", "eat") == 2)
  }

  test("73. Set Matrix Zeroes") {
    //    println(SetMatrixZeroes.setZeroes(Array(Array(0, 1, 2, 0), Array(3, 4, 5, 2), Array(1, 3, 1, 5))))
    println(SetMatrixZeroes.setZeroes(Array(Array(1, 1, 1), Array(1, 0, 1), Array(1, 1, 1))))
  }

  test("74. Search a 2D Matrix") {
    //    assert(Search2DMatrix.searchMatrix(Array(
    //      Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 50)), 3) == true)

    assert(Search2DMatrix.searchMatrix(Array(
      Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 50)), 13) == false)
    assert(Search2DMatrix.searchMatrix(Array(
      Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 50)), 1) == true)
    assert(Search2DMatrix.searchMatrix(Array(
      Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 50)), 16) == true)

    assert(Search2DMatrix.searchMatrix(Array.empty[Array[Int]], 1) == false)
  }

  test("76. Minimum Window Substring") {
    assert(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC") == "BANC")
    assert(MinimumWindowSubstring.minWindow("a", "b") == "")
    assert(MinimumWindowSubstring.minWindow("a", "a") == "a")
    assert(MinimumWindowSubstring.minWindow("abc", "cba") == "abc")
    assert(MinimumWindowSubstring.minWindow("cabefgecdaecf", "cae") == "aec")
  }
}
