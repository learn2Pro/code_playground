/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.string

import category.string._200_300._227_BasicCalculatorII
import category.string._300_400.{_336_PalindromePairs, _344_ReverseString, _385_MiniParser}
import category.string._400_500._
import category.string._500_600._
import category.string._600_700.{_606_ConstructStringFromBTree, _609_FindDupFileInSystem}
import category.timeline.week29.TreeNode
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version StringTest.scala, v 0.1 2019年12月23日 23:40 tang Exp $
  */
class StringCategoryTest extends FunSuite {
  
  test("227. Basic Calculator II") {
    assert(_227_BasicCalculatorII.calculate("0-0") == 0)
    assert(_227_BasicCalculatorII.calculate(" 3/2 ") == 1)
    assert(_227_BasicCalculatorII.calculate("3+2*2") == 7)
    assert(_227_BasicCalculatorII.calculate(" 3+5 / 2 ") == 5)
  }
  
  test("_344_ReverseString") {
    _344_ReverseString.reverseString(Array('1', '2'))
    //    assert()
  }
  
  test("_385_MiniParser") {
    println(_385_MiniParser.deserialize("[[],[[[[]],-4],[[[]],[0],[[]]]]]"))
    println(_385_MiniParser.deserialize("[123,456,[788,799,833],[[]],10,[]]"))
    println(_385_MiniParser.deserialize("[]"))
    println(_385_MiniParser.deserialize("[[]]"))
    println(_385_MiniParser.deserialize("324"))
    println(_385_MiniParser.deserialize("[123,[456,[789]]]"))
  }
  
  test("336. Palindrome Pairs") {
    assert(_336_PalindromePairs.palindromePairs(Array("abcd", "dcba", "lls", "s", "sssll")) == List(List(0, 1), List(1, 0), List(3, 2), List(2, 4)))
    assert(_336_PalindromePairs.palindromePairs(Array("bat", "tab", "cat")) == List(List(0, 1), List(1, 0)))
    assert(_336_PalindromePairs.palindromePairs(Array("a", "")) == List(List(1, 0), List(0, 1)))
    assert(_336_PalindromePairs.palindromePairs(Array("a", "b", "c", "ab", "ac", "aa")) == List(List(1, 3), List(3, 0), List(2, 4), List(4, 0), List(0, 5), List(5, 0)))
  }
  
  test("_415_AddStrings") {
    assert(_415_AddStrings.addStrings("", "") == "")
    assert(_415_AddStrings.addStrings("", "0") == "0")
    assert(_415_AddStrings.addStrings("11", "1") == "12")
    assert(_415_AddStrings.addStrings("111", "23") == "134")
    assert(_415_AddStrings.addStrings("1", "9") == "10")
  }
  
  test("_434_NumberOfSegmentsInAStr") {
    assert(_434_NumberOfSegmentsInAStr.countSegments(",a,") == 1)
    assert(_434_NumberOfSegmentsInAStr.countSegments(",a ") == 1)
    assert(_434_NumberOfSegmentsInAStr.countSegments("a,a ") == 2)
    assert(_434_NumberOfSegmentsInAStr.countSegments("Hello, my name is John") == 5)
    assert(_434_NumberOfSegmentsInAStr.countSegments("love live! mu'sic forever") == 4)
  }
  
  test("_443_StringCompression") {
    assert(_443_StringCompression.compress(Array('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')) == 4)
    assert(_443_StringCompression.compress(Array('a', 'a', 'a', 'a', 'a', 'b')) == 3)
    assert(_443_StringCompression.compress(Array('a', 'a', 'a', 'b', 'b', 'a', 'a')) == 6)
    assert(_443_StringCompression.compress(Array('a', 'a', 'b', 'b', 'c', 'c', 'c')) == 6)
  }
  
  test("_459_RepeatedSubstringPattern") {
    assert(_459_RepeatedSubstringPattern.repeatedSubstringPattern("abab"))
    assert(!_459_RepeatedSubstringPattern.repeatedSubstringPattern("aba"))
    assert(_459_RepeatedSubstringPattern.repeatedSubstringPattern("abcabcabcabc"))
  }
  
  test("_468_ValidateIpAddress") {
    assert(_468_ValidateIpAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:") == "Neither")
    assert(_468_ValidateIpAddress.validIPAddress("") == "Neither")
    assert(_468_ValidateIpAddress.validIPAddress("02001:0db8:85a3:0:0:8A2E:0370:7334") == "Neither")
    assert(_468_ValidateIpAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334") == "IPv6")
    assert(_468_ValidateIpAddress.validIPAddress("172.16.254.1") == "IPv4")
    assert(_468_ValidateIpAddress.validIPAddress("172.16.254") == "Neither")
    assert(_468_ValidateIpAddress.validIPAddress("172.16.254.01") == "Neither")
    assert(_468_ValidateIpAddress.validIPAddress("256.256.256.256") == "Neither")
  }
  
  test("_522_LongestUncommonSubSeqII") {
    assert(_522_LongestUncommonSubSeqII.findLUSlength(Array("ehxreslhdj", "ehxreslhdj", "hsvwdnedrl",
      "eqaaszomow", "ajqbfmcwmt", "rbawfiennm", "aicdzeadvf", "tmkdnabvbp", "tmkdnabvbp",
      "ewhbrxgbdz", "ewhbrxgbdz", "drbhfbiwit", "drbhfbiwit", "dhyyvnkzyy")) == 10)
    assert(_522_LongestUncommonSubSeqII.findLUSlength(Array("a", "b", "c", "d", "e", "f", "a", "b", "c", "d", "e", "f")) == -1)
    assert(_522_LongestUncommonSubSeqII.findLUSlength(Array("aabbcc", "aabbcc", "cb", "abc")) == 2)
    assert(_522_LongestUncommonSubSeqII.findLUSlength(Array("aabbcc", "aabbcc", "cb")) == 2)
    assert(_522_LongestUncommonSubSeqII.findLUSlength(Array("abba", "abba", "aba")) == -1)
    assert(_522_LongestUncommonSubSeqII.findLUSlength(Array("aaa", "aaa", "aa")) == -1)
    assert(_522_LongestUncommonSubSeqII.findLUSlength(Array("aba", "cdc", "eae")) == 3)
  }
  
  test("_539_MinimumTimeDifference") {
    assert(_539_MinimumTimeDifference.findMinDifference(List("05:31", "22:08", "00:35")) == 147)
    assert(_539_MinimumTimeDifference.findMinDifference(List("23:59", "00:00")) == 1)
  }
  
  test("_541_ReverseStringII") {
    assert(_541_ReverseStringII.reverseStr("ab", 3) == "ba")
    assert(_541_ReverseStringII.reverseStr("ab", 1) == "ab")
    assert(_541_ReverseStringII.reverseStr("abcdefg", 2) == "bacdfeg")
    assert(_541_ReverseStringII.reverseStr("abc", 2) == "bac")
  }
  
  test("_563_FindTheClosestPalin") {
    assert(_563_FindTheClosestPalin.nearestPalindromic("10") == "9")
    assert(_563_FindTheClosestPalin.nearestPalindromic("1") == "0")
    assert(_563_FindTheClosestPalin.nearestPalindromic("1213") == "1221")
    assert(_563_FindTheClosestPalin.nearestPalindromic("99800") == "99799")
    assert(_563_FindTheClosestPalin.nearestPalindromic("12349991000") == "12349994321")
    assert(_563_FindTheClosestPalin.nearestPalindromic("123") == "121")
    assert(_563_FindTheClosestPalin.nearestPalindromic("99000") == "98989")
    assert(_563_FindTheClosestPalin.nearestPalindromic("12030") == "12021")
  }
  
  test("_591_TagValidator") {
    assert(_591_TagValidator.isValid("<DIV><YFSYYS><UVBNIQ><XPMXUNT><WNGMV><OJJGQREMT><Z><GEJDP><LIQS><NCVYU><RAS><UYFKCJCDN><NA><POJVYT><Z><TDC><VUIZQC><BNANGX><TOF><MR>MK</MR></TOF></BNANGX></VUIZQC></TDC></Z></POJVYT></NA></UYFKCJCDN></RAS></NCVYU></LIQS></GEJDP></Z></OJJGQREMT></WNGMV></XPMXUNT></UVBNIQ></YFSYYS></DIV>"))
    assert(!_591_TagValidator.isValid("<![CDATA[ABC]]><TAG>sometext</TAG>"))
    assert(!_591_TagValidator.isValid("<A><![CDATA[<B></A>]]></B></A>"))
    assert(_591_TagValidator.isValid("<A><B></B></A>"))
    assert(!_591_TagValidator.isValid("<A></A><B></B>"))
    assert(_591_TagValidator.isValid("<TRUE><![CDATA[wahaha]]]><![CDATA[]> wahaha]]></TRUE>"))
    assert(!_591_TagValidator.isValid("<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>"))
    assert(!_591_TagValidator.isValid("<DIV><></DIV>"))
    assert(!_591_TagValidator.isValid("<>"))
    assert(_591_TagValidator.isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"))
    assert(_591_TagValidator.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"))
    assert(!_591_TagValidator.isValid("<A>  <B> </A>   </B>"))
    assert(!_591_TagValidator.isValid("<DIV>  div tag is not closed  <DIV>"))
    assert(!_591_TagValidator.isValid("<DIV>  unmatched <  </DIV>"))
    assert(!_591_TagValidator.isValid("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"))
    assert(!_591_TagValidator.isValid("<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"))
    assert(!_591_TagValidator.isValid("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"))
  }
  
  test("_606_ConstructStringFromBTree") {
    val t0 = new TreeNode(1)
    val t1 = new TreeNode(2)
    val t2 = new TreeNode(3)
    val t3 = new TreeNode(4)
    t0.left = t1
    t0.right = t2
    t1.left = t3
    assert(_606_ConstructStringFromBTree.tree2str(t0) == "1(2(4))(3)")
  }
  
  test("_609_FindDupFileInSystem") {
    assert(_609_FindDupFileInSystem.findDuplicate(Array("root/a 1.txt(abcd) 2.txt(efgh)",
      "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)")) ==
            List(List("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"),
              List("root/a/1.txt", "root/c/3.txt")))
  }
}
