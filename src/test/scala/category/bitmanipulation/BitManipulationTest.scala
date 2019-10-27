/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.bitmanipulation

import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version BitManipulationTest.scala, v 0.1 2019年10月27日 10:59 tang Exp $
  */
class BitManipulationTest extends FunSuite {
  
  test("187. Repeated DNA Sequences") {
    assert(DNASequence.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT") == List("CCCCCAAAAA", "AAAAACCCCC"))
    assert(DNASequence.findRepeatedDnaSequences("GAGAGAGAGAGA") == List("GAGAGAGAGA"))
  }
  
  test("201. Bitwise AND of Numbers Range") {
    assert(BitwiseInRange.rangeBitwiseAnd(6, 7) == 6)
    assert(BitwiseInRange.rangeBitwiseAnd(6, 8) == 0)
  }
  
  test("318. Maximum Product of Word Lengths") {
    assert(MaxProductOfWordsLength.maxProduct(Array("abcw", "baz", "foo", "bar", "xtfn", "abcdef")) == 16)
    assert(MaxProductOfWordsLength.maxProduct(Array("a", "ab", "abc", "d", "cd", "bcd", "abcd")) == 4)
    assert(MaxProductOfWordsLength.maxProduct(Array("a", "aa", "aaa", "aaaa")) == 0)
  }
  
  test("338. Counting Bits") {
    assert(CountingBits.countBits(2) sameElements Array(0, 1, 1))
    assert(CountingBits.countBits(3) sameElements Array(0, 1, 1, 2))
    assert(CountingBits.countBits(5) sameElements Array(0, 1, 1, 2, 1, 2))
  }
  
  test("371. Sum of Two Integers") {
    assert(SumOfTwoInt.getSum(1, 2) == 3)
    assert(SumOfTwoInt.getSum(1, 4) == 5)
    assert(SumOfTwoInt.getSum(1111, 2222) == 3333)
    assert(SumOfTwoInt.getSum(-1111, 2222) == 1111)
  }
  
  test("389. Find the Difference") {
    assert(FindDiffInLetter.findTheDifference("a", "aa") == 'a')
  }
  
  test("393. UTF-8 Validation") {
    assert(UTF8Validation.validUtf8(Array(237)) == false)
    assert(UTF8Validation.validUtf8(Array(145)) == false)
  }
  
  test("405. Convert a Number to Hexadecimal") {
    assert(Num2HexString.toHex(0) == "0")
    assert(Num2HexString.toHex(26) == "1a")
    assert(Num2HexString.toHex(-1) == "ffffffff")
  }
  
  test("421. Maximum XOR of Two Numbers in an Array") {
    assert(MaximumXOR.findMaximumXOR(Array(3, 10, 5, 25, 2, 8)) == 28)
  }
  
}
