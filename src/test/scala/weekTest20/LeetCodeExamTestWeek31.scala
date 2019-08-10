package weekTest20

import org.scalatest.FunSuite
import week31._
import week32.ConcatenationOfAllWordsV2Solution

/**
  * @author tang
  * @date 2019/08/03
  */
class LeetCodeExamTestWeek31 extends FunSuite {

  /**
    * Given a string s, you are allowed to convert it to a palindrome by
    * adding characters in front of it. Find and return the shortest
    * palindrome you can find by performing this transformation.
    *
    * Example 1:
    *
    * Input: "aacecaaa"
    * Output: "aaacecaaa"
    * Example 2:
    *
    * Input: "abcd"
    * Output: "dcbabcd"
    */
  test("Shortest Palindrome") {
    assert(ShortestPalindromeSolution.shortestPalindrome("aacecaaa") == "aaacecaaa")
    assert(ShortestPalindromeSolution.shortestPalindrome("abcd") == "dcbabcd")
  }

  /**
    * Given a non-empty string check if it can be constructed
    * by taking a substring of it and appending multiple copies
    * of the substring together. You may assume the given string
    * consists of lowercase English letters only and its length
    * will not exceed 10000.
    *
    * Example 1:
    *
    * Input: "abab"
    * Output: True
    * Explanation: It's the substring "ab" twice.
    * Example 2:
    *
    * Input: "aba"
    * Output: False
    * Example 3:
    *
    * Input: "abcabcabcabc"
    * Output: True
    * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
    */
  test("Repeated Substring Pattern") {
    assert(RepeatedSubstringPatternSolution.repeatedSubstringPattern("abab") == true)
    assert(RepeatedSubstringPatternSolution.repeatedSubstringPattern("aba") == false)
    assert(RepeatedSubstringPatternSolution.repeatedSubstringPattern("abcabcabcabc") == true)
    assert(RepeatedSubstringPatternSolution.repeatedSubstringPattern("abac") == false)
    assert(RepeatedSubstringPatternSolution.repeatedSubstringPattern("aabaaba") == false)
  }

  /**
    * Given two strings A and B, find the minimum number of
    * times A has to be repeated such that B is a substring of it. If no such solution, return -1.
    *
    * For example, with A = "abcd" and B = "cdabcdab".
    *
    * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
    *
    * Note:
    * The length of A and B will be between 1 and 10000.
    */
  test("Repeated String Match") {
    //        assert(RepeatedStringMatchSolution.repeatedStringMatch("abcd", "cdabcdab") == 3)
    //        assert(RepeatedStringMatchSolution.repeatedStringMatch("abcd", "bcdab") == 2)
    //    assert(RepeatedStringMatchSolution.repeatedStringMatch("abaabaa", "abaababaab") == 3)
    //    assert(RepeatedStringMatchSolution.repeatedStringMatch("aa", "a") == 1)
    //    assert(RepeatedStringMatchSolution.repeatedStringMatch("bb", "bbbbbbb") == 4)
    assert(RepeatedStringMatchSolution.repeatedStringMatch("abcd", "cdabcdacdabcda") == -1)
  }

  /**
    * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
    *
    * Return the quotient after dividing dividend by divisor.
    *
    * The integer division should truncate toward zero.
    *
    * Example 1:
    *
    * Input: dividend = 10, divisor = 3
    * Output: 3
    * Example 2:
    *
    * Input: dividend = 7, divisor = -3
    * Output: -2
    * Note:
    *
    * Both dividend and divisor will be 32-bit signed integers.
    * The divisor will never be 0.
    * Assume we are dealing with an environment which could only store integers
    * within the 32-bit signed integer range: [−231,  231 − 1].
    * For the purpose of this problem, assume that your function
    * returns 231 − 1 when the division result overflows.
    */
  test("divide") {
    //    assert(DivideTwoIntegersSolution.add(1, 2) == 3)
    //    assert(DivideTwoIntegersSolution.add(-1, 2) == 1)
    //    assert(DivideTwoIntegersSolution.add(-1, -2) == -3)
    //    assert(DivideTwoIntegersSolution.minus(1, 2) == -1)
    //    assert(DivideTwoIntegersSolution.minus(-1, 2) == -3)
    //    assert(DivideTwoIntegersSolution.minus(-1, -2) == 1)
    //    assert(DivideTwoIntegersSolution.multiply(1, 2) == 2)
    //    assert(DivideTwoIntegersSolution.multiply(-1, 2) == -2)
    //    assert(DivideTwoIntegersSolution.multiply(-1, -2) == 2)
    assert(DivideTwoIntegersSolution.divide(10, 2) == 5)
    assert(DivideTwoIntegersSolution.divide(10, -2) == -5)
    assert(DivideTwoIntegersSolution.divide(-10, -2) == 5)
    assert(DivideTwoIntegersSolution.divide(Int.MinValue, -1) == Int.MaxValue)
    assert(DivideTwoIntegersSolution.divide(Int.MinValue, 1) == Int.MinValue)
    assert(DivideTwoIntegersSolution.divide(7, -3) == -2)
    assert(DivideTwoIntegersSolution.divide(-1010369383, -2147483648) == 0)
    assert(DivideTwoIntegersSolution.divide(-2147483648, -2147483648) == 1)
    assert(DivideTwoIntegersSolution.divide(-2147483648, -1010369383) == 2)
    assert(DivideTwoIntegersSolution.divide(-2147483648, -1) == Int.MaxValue)
    assert(DivideTwoIntegersSolution.divide(-2147483648, -1109186033) == 1)
  }

  /**
    * Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
    *
    * For a given query word, the spell checker handles two categories of spelling mistakes:
    *
    * Capitalization: If the query matches a word in the wordlist (case-insensitive),
    * then the query word is returned with the same case as the case in the wordlist.
    * Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
    * Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
    * Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
    * Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query
    * word with any vowel individually,
    * it matches a word in the wordlist (case-insensitive), then the query word is
    * returned with the same case as the match in the wordlist.
    * Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
    * Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
    * Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
    * In addition, the spell checker operates under the following precedence rules:
    *
    * When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
    * When the query matches a word up to capitlization, you should return the first such match in the wordlist.
    * When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
    * If the query has no matches in the wordlist, you should return the empty string.
    * Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].
    *
    *
    *
    * Example 1:
    *
    * Input: wordlist = ["KiTe","kite","hare","Hare"],
    * queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
    * Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
    *
    *
    * Note:
    *
    * 1 <= wordlist.length <= 5000
    * 1 <= queries.length <= 5000
    * 1 <= wordlist[i].length <= 7
    * 1 <= queries[i].length <= 7
    * All strings in wordlist and queries consist only of english letters.
    */
  test("Vowel Spellchecker") {
    VowelSpellcheckerSolution.spellchecker(Array("KiTe", "kite", "hare", "Hare"), Array("kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"))
  }

  /**
    * You are given a string, s, and a list of words, words,
    * that are all of the same length. Find all starting
    * indices of substring(s) in s that is a concatenation
    * of each word in words exactly once and without any intervening characters.
    *
    * Example 1:
    *
    * Input:
    * s = "barfoothefoobarman",
    * words = ["foo","bar"]
    * Output: [0,9]
    * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
    * The output order does not matter, returning [9,0] is fine too.
    * Example 2:
    *
    * Input:
    * s = "wordgoodgoodgoodbestword",
    * words = ["word","good","best","word"]
    * Output: []
    */
  test("Substring with Concatenation of All Words") {
    //    println(ConcatenationOfAllWordsV2Solution.findSubstring("barfoothefoobarman", Array("foo", "bar")))
    //    println(ConcatenationOfAllWordsV2Solution.findSubstring("wordgoodgoodgoodbestword", Array("word", "good", "best", "word")))
        println(ConcatenationOfAllWordsV2Solution.findSubstring("barfoofoobarthefoobarman", Array("bar", "foo", "the")))
    //    println(ConcatenationOfAllWordsV2Solution.findSubstring("wordgoodgoodgoodbestword", Array("word", "good", "best", "good")))
//    println(ConcatenationOfAllWordsV2Solution.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", Array("fooo", "barr", "wing", "ding", "wing")))
//        println(ConcatenationOfAllWordsV2Solution.findSubstring("aaaaaaaa", Array("aa", "aa", "aa")))
    //    println(ConcatenationOfAllWordsV2Solution.findSubstring("ababaab", Array("ab", "ba", "ba")))
    //    println(ConcatenationOfAllWordsV2Solution.findSubstring("a", Array("a")))
  }

}
