/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.string

import category.string._200_300._227_BasicCalculatorII
import category.string._300_400.{_336_PalindromePairs, _344_ReverseString, _385_MiniParser}
import category.string._400_500._
import category.string._500_600._
import category.string._600_700._
import category.string._700_800.{_722_RemoveComments, _736_ParseLispExpression, _767_ReorganizeStr, _770_BasicCalculatorIV}
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
  
  test("_678_ValidParenthesisStr") {
    assert(_678_ValidParenthesisStr.checkValidString("()"))
    assert(_678_ValidParenthesisStr.checkValidString("(*)"))
    assert(_678_ValidParenthesisStr.checkValidString("(*))"))
  }
  
  test("_680_ValidPalindromeII") {
    assert(!_680_ValidPalindromeII.validPalindrome("abc"))
    assert(_680_ValidPalindromeII.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"))
  }
  
  test("_686_RepeatedStringMatch") {
    assert(_686_RepeatedStringMatch.repeatedStringMatch("a", "aa") == 2)
  }
  
  test("_696_CountBinarySubStr") {
    assert(_696_CountBinarySubStr.countBinarySubstrings("00110011") == 6)
    assert(_696_CountBinarySubStr.countBinarySubstrings("10101") == 4)
  }
  
  test("_722_RemoveComments") {
    assert(_722_RemoveComments.removeComments(Array(
      "/*/dadb/*/aec*////*//*ee*//*//b*////*badbda//*bbacdbbd*//ceb//*cdd//**//de*////*",
      "ec//*//*eebd/*/*//*////*ea/*/bc*//cbdacbeadcac/*/cee*//bcdcdde*//adabeaccdd//*",
      "ddadbede//*//*/*/ac/*/ea//*bbeb/*/ea//*a//*//*cdbeb*//ab/*/abde/*//*/d//**////*",
      "e/*/eabeea/*///*c*////*dc*//bcadcde/*/acbe//*d/*/*//ae//*dc//*cc//*//*eaebb*//",
      "eed*//cd//**///*/*//e//*bbcbbaedb*//aabb//*badb*//d/*/e*//ade//*bacbc*//ea//*a",
      "/*/bcbc//*ebdb/*/bab/*/a/*//*/d/*///*de/*///*d*//dc*///*/cd//*ccd//*a//*caacad",
      "/*/cadaacca/*/c/*/c*//bb*////*//*e//*/*//*//*//*/ebd*//abd/*/ce*//e/*/aaa//*//*",
      "cbae*//cc*///*/e/*//*/d*//bdeeee//*b*//de*//aceca*//dddd*///*///*deba*//abbdd/*/",
      "dcabe/*/a/*/bdc//*cec*//ebabc//**//*//cc//*b*//*////*abdea*///*/c*//bc//*/*/ae",
      "badcc//**//*///*/dd//*d*//*//*////*d*//eabb/*/de/*//*/*//a/*/c/*/c//*dad/*/*//",
      "dd*////*//*//*/*/*//e/*/ec*//cac*//d//*aadc/*/ae/*/ebc//*//**//*///*/bbd*//ee/*/",
      "eb/*///*cd*//dcdbaaadd//*ced/*/dcabe//*//*a/*//*///*ea*///*//*/*//b/*//*/dd/*/",
      "ba*//e*//cd//*/*/dd/*/*//dd//**//aab//**//*//*//d/*//*/*//*//*//cddecbbb//*ee*//",
      "ab//*d*//d/*/dbdcadb//*badbedb//*ac//*bd*///*//*///*/*//*/d*//d*//c/*/a//*cb//*",
      "*//e//*ad//*cdabb*///*/d/*/bcbad//*ba/*///*d/*//*/ab//*/*//*/*//*//cb//**//cac",
      "*//bedcba/*/ee/*/ecc/*/e//**//b/*/bebcbac/*//*/bcaa//*adacdcdb*///*/ecb*//e//*",
      "aeabd/*/aeead/*/ccccd//*dc*////*edc*//e/*/*//c//**//b//*aceaa/*/ccbabed*//dbba",
      "c/*/a*//aa//**//b*//beecc//*aea/*///**//c//*//*bcbb/*/e/*/*//*////*//*b/*/bdbe",
      "de/*/c*//aedb*//b*//*//*//bdad*//bece/*/ce/*/*//cacbea/*/ee/*//*/c//*ab//*/*/*//",
      "//**//cec//*ae/*/baeb//*be//*ddcbdc*//ae//*dc*//*//cbb*//cadabe*//cca//*/*/c*//",
      "//*a*//d/*/c/*/da*//ac*////**//cbb*//eccdba/*/cdec//*eb/*/ebec//*aac/*/cdcd//*",
      "*//cd*//dde//**//a/*/ea//*//*eb/*/c//*/*/babac/*/b/*/caede*///*/eabcdd*//*///*/",
      "//*d/*/*//aad//**//bcad/*///*a/*/d//*//*cebdcbedcdadebdab/*/b*//bbcabcddbab*//",
      "*///*//*/*//*//cccb/*/*//bee/*/ace*//da//*bdb//*db*//ccdab*////*/*/*//adb//*da",
      "//*aeb*//badc*//daaa*//e/*/*//aaead*//eb//*/*///*//*ae//**//c//*/*/abbdccccbe//*",
      "/*/b//*//*e//*b*//d/*/aea*//*//ae/*/c//*c*////*bdeb*//bb*//cbc/*//*/cbebabcccb",
      "e/*/daeaebc*//edceacc/*///**//e/*/ec/*/a*//bcab*///*/bbdc/*/abcdbe//**//da//*c",
      "ca//*c//*ba//*decbc*//cccdda/*/*//bcaead/*/*///*///*d/*/dda*//acdd/*///**//c//*",
      "ec//*/*/a//*bcb//*c/*/d//*e//*//*ce/*///*aeb//*b*//eb/*/edeeec//**//bdddc/*/c//*",
      "ebdce//*dedaaeda/*/*//aaea//*//*//*//**//d//*//*/*/*///*/c/*/dcadec//*/*/e*//a",
      "dadc//*/*/deed/*/*//*///*///*/*/e*//eeb/*//*/c//*dc*///*/dc/*/b//*d*////*/*/c//*",
      "/*/caddc//*//*b*//*//d/*/eadddaabebeedd//*b*//ebc/*/ec//*e/*/b*///*/abee//*/*/",
      "cb/*/d/*/eadebcaebded*//eaedc/*/e*////*a*//d//*aa*//ecedd//*abb*//dc//*//*ccbe",
      "ee//*bebbbce//*aaed//*//*/*//*///*da//*a//*//*//*//*beb*////*dbdb/*//*//*///*b",
      "eb/*/*///*/*//ce/*//*/bcdbdeee//**////*e//**//c*//eab*///*//*//*/da/*/ca/*/e//*",
      "dd//*/*//*//*/eab*///*/cddb//*//*//*bb//*//**///*/eadbbdcccdeb/*/cdecdadb/*/ca",
      "//*ccaa//*/*/ca/*/a/*/a/*/a*//*//c*//d//*//*d//*bb/*/*//a*//cb//**//bd*//aa*//",
      "cbccc//*ce/*/bb/*/aa*//eca//*b*///*//*///*dde*//*//c/*/a/*/cdac/*//*/*//eb//*b",
      "//*bceedbeb*//eaedccc//*dc/*/abeed/*/ede*///*/ebaa*////*a//*//*eb*//b*//b//*/*/",
      "//*d//*//*bbbd/*/ab*//ae*//*//e/*/ecea*//ceda*////*ccd/*/e//*ebc*//a/*//*/cea*//",
      "da*//*//e/*//*/*//b*//dbebcac//*db//*a//*a//*b//*ad/*/*///*///*dcae//*//*ebebc",
      "d*//ab/*/bac/*/*//cc/*///**//e/*/de//*/*/eaeee/*/*//bacd/*/b//*b*////**////*/*/",
      "b*///*//*/bb//*cca//*bcabc//*//*a*//ea/*/e*//c//*ba/*/bce/*//*/bad*//da/*/dc/*/",
      "da/*//*/c*//*//a*//e*//d/*///*a//*//*bc//**//bbd*///*/*//*//ede/*/b/*/ab//*/*/",
      "de//*c/*/bdc*//c/*/*//*//d//*cd/*/ce*//aaaca*///*/ccd/*/a//*b/*/beaa/*//*/dbdc",
      "e//*ad/*/dbc*//dbeae*//d//**//*////*a//**//*////*a*//*//*//cecececacdbc/*/a/*/",
      "/*//*/b/*/ed*///*/bb/*/eda*//ce*//c/*///*/*/cdcad//*d//*b*//ee//**//e/*/aeecbd",
      "dbbbe//**////**//c//*/*/aaccbab/*/*//abc/*/e/*///*a*//edc/*//*/a*///*/cccbe//*",
      "ccd*//ebb//*/*///*e*//e*//*//e//**//ec//*a*////*//*//*bcb//*e/*/d/*//*/ca/*//*/",
      "*//a*///*/bea//*cba*//bbe*//ba//*ccec/*/b/*/aeadbc/*///*eeb//*eeedc/*/a//*aaeb",
      "adaabdaaea//**//ed//**//cbeab/*//*//*/e/*/edb/*/e//*//*ccbec*//e*///*/e/*//*///*",
      "eec*//adebbbbbb*//acb/*/e*////*/*/*//a/*///*acbedd//*cd//*be*//b//*e/*/db*//*//",
      "/*/dbcbd*//a/*/ede//*b*//addc//**///*/deec*///*//*/ccddae//*aac/*///*bbbeabcec",
      "//*//*//*deaa/*/ebeb*//dbbe//**//abceededcb//*//*ebe*//ce*//c*//cc*//ce*////*//*",
      "//**//c/*/ed*//e/*/db/*/bedd/*/eccebcbce/*///*ec/*/ad/*/cb//*cabcadebcee//*ba/*/",
      "*//c*//de/*/ada/*/cc//*a//*ccb*////*dabecadea*//be/*/cba/*/d/*//*/cd//*da//*e*//",
      "*///*//*/a/*/*///*/cccb//*c/*/a//*bdddebc*///*//*/eb//*//**//aee/*/*//aec/*/a//*",
      "//*b/*/ab*//e/*/c//**//aab//*aaddcb*///*/cd/*/ecac/*///*ec//*//*dd//**//b/*/c*//",
      "/*/ab//*c*////*/*//*/eaae//*/*/cb*//*//aebb*///*///*cee*//ca*//aba/*/b//*//*c*//",
      "/*/b*//ddddcab*////*/*/cb*//eba*//d*////*/*/c/*/ccd/*/ab*//cbe*//bda//*cb//**//",
      "cb*//ebedad/*/ed//**//a//*dcaeaecaa//*/*/dcacddbe//*//*/*/dcc*//a//*cacccdea//*",
      "b*//b*///*/*//*//a/*/eac/*/b/*/ab//*/*/aa*//e//**//aac//*db//**//d/*/bd*///*///*",
      "*//*////*d//*d//*d//**//*//a/*//*//*/d//*e*////*b*//b*//bd*//c//**//cdb/*/d*//",
      "aaadddd/*/b//*//*beeddb/*///*//*cc*//abe//*c*///*/abca*//d//*dbaeebcddc//*dddc",
      "bd*//b/*/bd//*bd/*/c*//dd//*e*//*//d//**//a//*cbae/*/ab*//e*//e*//dcaa/*//*/dc",
      "ad//*abcbbb*////*b//*e/*/*//bb*////*/*/*//*//ba/*//*/dacdbcda/*/bdcbb*//*///*/",
      "*////**////**////*b*//c*////*e//*cab*//dce/*/d*//ceaaaaa//**////*addd*///*/*//",
      "//*cc/*/c/*/cc*//a/*/ac/*/a//*e*//bb/*/eae//*abb/*///*//*/*/c//*//*e//*da//*b/*/",
      "*///*/ba/*/eaeaec/*/cd/*/dac//*aacc/*///*adcd//*adce//*bea/*/bea//*ba*//*//b*//",
      "e/*/a*///*/ac*//*//*////*de*//de*//a*//ece//*dc//*dabae//*/*/ebcecdda//*de*//c",
      "a*//eccb//*ebd/*//*/dc*//e/*///*//*/*/ce/*/*//b//*edbdba//*de//**//d*//ec/*/*//",
      "a/*///*eec*///*/dd*////*//*/*//*///*aa//*d*///*/c*//d/*//*//*/c*//dcc//*ec*//c",
      "d*//c/*/a/*//*/adb/*/a//**//b*///*///*cabecca/*/eec*//caeac/*/aa//*//*//*ddbbb",
      "e*//ebca/*//*/cdc/*///**//*//bdbc*//ebdd/*/aa//*eaebbd*//c*//adbbeca*////**////*",
      "cedc*///*/e//*d*///*///*//*e/*/cda/*//*///**////*e/*/c//*dac/*/a//*//**//e//*/*/",
      "*///*/*//*//dced*//b*//b//*a//*//*d*//aab/*/dacccdc//*e//*//*edcc//*//*/*///**//",
      "/*//*/*//*//ee//*eb//*cb//*ca/*///**//*///*/ed//*cccd//**////*e//*dbcdad//*c*//",
      "//*bdeadcccddc//**//ebee*////*bb*////**//cac*////*c//*bbaca*//eeb*//c/*/aae*//",
      "//*ecd//*cddc/*/cab/*/*//bb/*/c*///*/dab*//d*//cc/*///*ccde*//c//*be//*d*///*/",
      "eb//*eabac/*/e//*d*//a/*//*/ca/*///**//a//**//a/*//*/e//*bb/*/cccdbedceb/*/d*//",
      "*//aa//*eac//**//ea//*ee//*eb/*///*e*//*//beece//*/*///*e/*///*//*//*//*e/*/bd",
      "//*/*/ae*//a*//a*//cdc*//bcc//*/*/c/*/b*//cdae//*dd*//bcbdeba*//b//**//a//*cbb",
      "b*//d//*ace/*/a//*/*/*////*//*//**//*///*/de*//a//**///*///*d*////*//*cd//**//",
      "*//bd//*//*d/*/*//e//*/*/*//*//c/*/c//*ca*//*//adaa/*/dc*//ddda//*c//*edccc/*/",
      "ba*//a//*e//*ccda*//b//*c/*//*/dc/*/eaedb/*/adbed*//bda*////*d//*a*//*//*//cb//*",
      "da*//dc/*///*b/*/cb/*/daa*//adddbd/*/be/*/b/*/b/*/c//*c*//ee//**//*//be//**//*//",
      "eccd/*/cb//*/*/ab//*ba//*/*/bc/*/ebdec//*baeadb//*//*c*//bacc//*d/*/*//b*///*/",
      "*////*ce//*a*////*bc//*/*//*/b//*/*/*//b//*//*eb/*/a*//*//dede/*/aebebc//*ba//*",
      "/*/d//*//*d//*/*/cbcedae/*/b//*/*//*/*//eae/*/a*///*///*ca//*ab//*e/*/eebea/*/",
      "a//*a*//ee//*/*/dd/*/ebe//*eaacda/*/*//c/*///*cd*///*/aa//**//aaecba/*/b//*bbe",
      "//*d//*//*ccaa/*/c//*be//**///*/e*//de/*/cce//*//*//*abbdd/*///*cceebc//*//*dd",
      "aa//*d//*//*ebc/*/ba//*bd//*/*///*//**//*////*dca/*//*/eeee/*/*////*a/*/c*//b*//",
      "*//ca*///*/*//deb//*adb*//d//*dcbbeda*//bd/*/ad//*cdd/*/ee//*//*ecea//*/*/a//*",
      "cadbbd/*/de/*///*//*//*//*//*//*bc*////*db*//bebdb//*/*/b//**////*/*/bc//*a*//",
      "d//*bc*//eda*//aaac/*///*/*/db//*dca//*edd/*/a/*/ccad*//c//*aded/*/ee/*/eead/*/",
      "*//bdaeda//*//**///*/b*//ddccbad*//ee*//ddcbcd/*/ab//*ec//*dd//*//*//*aaeddbac",
      "c//*/*/decadeed*//a*//ca//*/*/e*//bd*///*/db*////*a/*/cabdaddbeadbdaaacb*//b//*",
      "d/*/aee*//d/*/*///*/de*//de//*ab*///*/ccb/*/adbab*//c//*/*/e*//eee*//e/*//*///*",
      "d/*/*//c//**//cd/*///*d/*/b/*/bba*//dc//**///*/baca*//ddbc*//deeaead//*bd*//dd",
      "dbbdedece//*dceaa//*aeb/*/bdead//*ccbeb*////**//b//*d*//aecad//*a*////**//abeb"
    )) == List("aec*", "ec", "ddadbede", "e", "eed*", "bab", "c/bb*", "cbae*", "dcabebdc", "badcc", "dd*", "eb/dcdbaaadd", "ba*", "ab", "*", "*", "aeabdccccd", "c/aa", "de/aedb*", "*", "*", "/dc", "e/edceacc/ea*", "ca", "ec", "ebdce", "dadc", "eadddaabebeedd", "cbeadebcaebded*", "ee", "eb", "dd", "cbccc", "da*", "d*", "b*", "dac*", "de", "e", "b", "dbbbe", "ccd*", "*", "adaabdaaea", "eec*", "/a/addc", "*", "*", "/ddddcab*", "cb*", "b*", "*", "aaadddd", "bd*", "ad", "*", "*", "e", "a*", "a", "d*", "e*", "cedc*", "*", "*", "eb", "*", "b*", "*", "ba*", "da*", "eccd*/ab", "*", "*/cbcedae*", "a", "aa", "*", "cadbbd", "d", "*", "c", "d/d", "d/c", "dbbdedece"))
    assert(_722_RemoveComments.removeComments(Array(
      "a/*/b//*c", "blank", "d/*/e*//f"
    )) == List("ae*"))
    assert(_722_RemoveComments.removeComments(Array(
      "a/*/b//*c", "blank", "d//*e/*/f"
    )) == List("af"))
    assert(_722_RemoveComments.removeComments(Array(
      "struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"
    )) == List("struct Node{", "    ", "    int size;", "    int val;", "};"))
    assert(_722_RemoveComments.removeComments(Array(
      "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"
    )) == List("int main()", "{ ", "  ", "int a, b, c;", "a = b + c;", "}"))
    assert(_722_RemoveComments.removeComments(Array(
      "a/*comment", "line", "more_comment*/b"
    )) == List("ab"))
  }
  
  test("_736_ParseLispExpression") {
    assert(_736_ParseLispExpression.evaluate("(let x0 4 x1 -2 x2 3 x3 -5 x4 -3 x5 -1 x6 3 x7 -2 x8 4 x9 -5 (mult x2 (mult (let x0 -3 x4 -2 x8 4 (mult (let x0 -2 x6 4 (add x5 x2)) x3)) (mult (mult -7 (mult -9 (let x0 -2 x7 3 (add -10 x0)))) x6))))") == 68040)
    assert(_736_ParseLispExpression.evaluate("(let var 78 b 77 (let c 33 (add c (mult var 66))))") == 5181)
    assert(_736_ParseLispExpression.evaluate("(let a -122 b 0 (add (add 1 -4) (mult a 66)))") == -8055)
    assert(_736_ParseLispExpression.evaluate("(let x 1 y 2 x (add x y) (add x y))") == 5)
    assert(_736_ParseLispExpression.evaluate("(let x 3 x 2 x)") == 2)
    assert(_736_ParseLispExpression.evaluate("(add 1 2)") == 3)
    assert(_736_ParseLispExpression.evaluate("(mult 3 (add 2 3))") == 15)
    assert(_736_ParseLispExpression.evaluate("(let x 2 (mult x 5))") == 10)
    assert(_736_ParseLispExpression.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))") == 14)
    assert(_736_ParseLispExpression.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))") == 6)
    assert(_736_ParseLispExpression.evaluate("(let a1 3 b2 (add a1 1) b2)") == 4)
  }
  
  test("_767_ReorganizeStr") {
    assert(_767_ReorganizeStr.reorganizeString("aabbc") == "bcaba")
    assert(_767_ReorganizeStr.reorganizeString("aab") == "aba")
    assert(_767_ReorganizeStr.reorganizeString("aabb") == "baba")
    assert(_767_ReorganizeStr.reorganizeString("aaab") == "")
  }
  
  test("_770_BasicCalculatorIV") {
//    assert(_770_BasicCalculatorIV.basicCalculatorIV("((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))", Array.empty, Array.empty) == List("-1*a*a*b*b", "2*a*a*b*c", "-1*a*a*c*c", "1*a*b*b*b", "-1*a*b*b*c", "-1*a*b*c*c", "1*a*c*c*c", "-1*b*b*b*c", "2*b*b*c*c", "-1*b*c*c*c", "2*a*a*b", "-2*a*a*c", "-2*a*b*b", "2*a*c*c", "1*b*b*b", "-1*b*b*c", "1*b*c*c", "-1*c*c*c", "-1*a*a", "1*a*b", "1*a*c", "-1*b*c"))
    assert(_770_BasicCalculatorIV.basicCalculatorIV("a * b * c + b * a * c * 4", Array.empty, Array.empty) == List("5*a*b*c"))
    assert(_770_BasicCalculatorIV.basicCalculatorIV("(e + 8) * (e - 8)", Array.empty, Array.empty) == List("1*e*e", "-64"))
    assert(_770_BasicCalculatorIV.basicCalculatorIV("7 - 7", Array.empty, Array.empty) == Nil)
    assert(_770_BasicCalculatorIV.basicCalculatorIV("e - 8 + temperature - pressure", Array("e", "temperature"), Array(1, 12)) == List("-1*pressure", "5"))
    assert(_770_BasicCalculatorIV.basicCalculatorIV("e + 8 - a + 5", Array("e"), Array(1)) == List("-1*a", "14"))
  }
}
