package weekTest20

import org.scalatest.FunSuite
import week20.KnightDialer
import week22.{Add2Num, ListNode}
import week24._
import week26._

import scala.io.Source

class LeetcodeExamTestWeek20 extends FunSuite {

  test("knight dialer") {
    for (i <- 0 until 20) {
      println(KnightDialer.knightDialer(i))
    }
  }

  test("test add 2 num list") {
    /**
      * left
      */
    val l1 = new ListNode(5)

    /**
      * right
      */
    val r1 = new ListNode(5)

    val rs = Add2Num.addTwoNumbers(l1, r1)
    println(rs)
  }

  test("two sum use sorted arr") {
    TwoSumSolution.twoSumSorted(Array(2, 7, 11, 15), 9)
  }

  /**
    * input:abcabcbb
    * input:bbbbb
    * input:pwwkew
    */
  test("Longest Substring Without Repeating Characters") {
    assert(LongestUniqueSubStrSolution.lengthOfLongestSubstring("abcabcbb") == 3)
    assert(LongestUniqueSubStrSolution.lengthOfLongestSubstring("bbbbb") == 1)
    assert(LongestUniqueSubStrSolution.lengthOfLongestSubstring("pwwkew") == 3)
  }

  /**
    * Input: A = [1,2,1,2,3], K = 2 Output: 7
    * Input: A = [1,2,1,3,4], K = 3 Output: 3
    * 360
    */
  test(" Subarrays with K Different Integers") {
    assert(SubArrKDistinctSolution.subarraysWithKDistinct(Array(1, 2, 1, 2, 3), 2) == 7)

    val source = Source.fromFile("/Users/tang/export/leetcode-items/leetcode-weekend-dur/src/test/resource/intArr")
    val arr = source.mkString("")
    val integers = arr.substring(1, arr.length - 1).split(",").map(_.toInt)
    println(SubArrKDistinctSolution.subarraysWithKDistinct(integers, 360))
    source.close()
  }

  /**
    * nums1 = [1, 3]
    * nums2 = [2]
    *
    * The median is 2.0
    *
    * nums1 = [1, 2]
    * nums2 = [3, 4]
    *
    * The median is (2 + 3)/2 = 2.5
    */
  test("Median of Two Sorted Arrays") {
    assert(MedianOfTwoSorted.findMedianSortedArrays(Array(1, 3), Array(2)) == 2.0)
    assert(MedianOfTwoSorted.findMedianSortedArrays(Array(1, 2), Array(3, 4)) == 2.5)
    assert(MedianOfTwoSorted.findMedianSortedArrays(Array(1, 3), Array(2, 4)) == 2.5)
    assert(MedianOfTwoSorted.findMedianSortedArrays(Array(2), Array()) == 2)
    assert(MedianOfTwoSorted.findMedianSortedArrays(Array(), Array(2, 3)) == 2.5)
  }

  /**
    * Input: "babad"
    * Output: "bab"
    * Note: "aba" is also a valid answer.
    *
    * Input: "cbbd"
    * Output: "bb"
    */
  test("Longest Palindromic Substring") {
    assert(LongestPalindromicSubStrSolution.longestPalindrome("babad") == "bab")
    assert(LongestPalindromicSubStrSolution.longestPalindrome("cbbd") == "bb")
    assert(LongestPalindromicSubStrSolution.longestPalindrome("babadada") == "adada")
    assert(LongestPalindromicSubStrSolution.longestPalindrome("cbbbbbc") == "cbbbbbc")
    assert(LongestPalindromicSubStrSolution.longestPalindrome("aaabaaaa") == "aaabaaa")
    assert(LongestPalindromicSubStrSolution.longestPalindrome("bb") == "bb")
    assert(LongestPalindromicSubStrSolution.longestPalindrome("ababababababa") == "ababababababa")
  }

  test("ZigZag Conversion") {
    assert(ZigZagConvSolution.convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
    assert(ZigZagConvSolution.convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
    assert(ZigZagConvSolution.convert("PAYPALISHIRING", 5) == "PHASIYIRPLIGAN")
    assert(ZigZagConvSolution.convert("A", 1) == "A")
    assert(ZigZagConvSolution.convert("AB", 2) == "AB")
  }

  test("Reverse Integer") {
    assert(ReverseIntegerSolution.reverse(123) == 321)
    assert(ReverseIntegerSolution.reverse(-123) == -321)
    assert(ReverseIntegerSolution.reverse(120) == 21)
    assert(ReverseIntegerSolution.reverse(1534236469) == 0)
    assert(ReverseIntegerSolution.reverse(-2147483412) == -2143847412)
  }

  test("Positions of Large Groups") {
    assert(LargeGroupSolution.largeGroupPositions("aa") == List.empty[List[Int]])
    //    assert(LargeGroupSolution.largeGroupPositions("abbxxxxzzy") == List(List(3, 6)))
    //    assert(LargeGroupSolution.largeGroupPositions("abc") == List.empty[List[Int]])
    //    assert(LargeGroupSolution.largeGroupPositions("abcdddeeeeaabbbcd") == List(List(3, 5), List(6, 9), List(12, 14)))
  }

  test("Max Chunks To Make Sorted II") {
    assert(MaxChunkSolution.maxChunksToSorted(Array(0, 4, 7, 5, 3, 6, 9, 2, 1, 8)) == 2)
    assert(MaxChunkSolution.maxChunksToSorted(Array(2, 0, 1, 7, 3, 4, 5, 6)) == 2)
    assert(MaxChunkSolution.maxChunksToSorted(Array(0, 3, 0, 3, 2)) == 2)
    assert(MaxChunkSolution.maxChunksToSorted(Array(5, 1, 1, 8, 1, 6, 5, 9, 7, 8)) == 1)
    assert(MaxChunkSolution.maxChunksToSorted(Array(1, 2, 4, 2, 2)) == 3)
    assert(MaxChunkSolution.maxChunksToSorted(Array(0, 0, 1, 1, 1)) == 5)
    assert(MaxChunkSolution.maxChunksToSorted(Array(4, 0, 0, 2, 4)) == 2)
    assert(MaxChunkSolution.maxChunksToSorted(Array(1, 0, 1, 3, 2)) == 3)
    assert(MaxChunkSolution.maxChunksToSorted(Array(5, 4, 3, 2, 1)) == 1)
    assert(MaxChunkSolution.maxChunksToSorted(Array(5, 5, 4, 3, 2, 1)) == 1)
    assert(MaxChunkSolution.maxChunksToSorted(Array(2, 1, 3, 4, 4)) == 4)
  }

  test("String to Integer (atoi)") {
    assert(AtoiSolution.myAtoi("42") == 42)
    assert(AtoiSolution.myAtoi("   -42") == -42)
    assert(AtoiSolution.myAtoi("4193 with words") == 4193)
    assert(AtoiSolution.myAtoi("words and 987") == 0)
    assert(AtoiSolution.myAtoi("-91283472332") == -2147483648)
    assert(AtoiSolution.myAtoi("  +2 12") == 2)
    assert(AtoiSolution.myAtoi("9223372036854775808") == 2147483647)
    assert(AtoiSolution.myAtoi("0-1") == 0)
    assert(AtoiSolution.myAtoi("    -88827   5655  U") == -88827)
    assert(AtoiSolution.myAtoi("-5-") == -5)
    assert(AtoiSolution.myAtoi("-13+8") == -13)
    assert(AtoiSolution.myAtoi("18446744073709551617") == 2147483647)
  }

  test("Palindrome Number") {
    assert(PalindromeNumberSolution.isPalindrome(121))
  }

  /**
    * mississippi
    * mis*is*ip*.
    *
    * mississippi
    * mis*is*p*.
    */
  test("Regular Expression Matching") {
    assert(RegExpSolution.isMatch("aa", "a") == false)
    assert(RegExpSolution.isMatch("aa", "a*") == true)
    assert(RegExpSolution.isMatch("ab", ".*") == true)
    assert(RegExpSolution.isMatch("aab", "c*a*b") == true)
    assert(RegExpSolution.isMatch("mississippi", "mis*is*p*.") == false)
    assert(RegExpSolution.isMatch("mississippi", "mis*is*ip*.") == true)
  }

}
