/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.math

import category.math._200_300.{_204_CountPrimes, _223_RectangleArea, _224_BasicCalculator, _273_IntegerToEnglishWords}
import category.math._300_400._313_SuperUglyNumber
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version MathTest.scala, v 0.1 2019年12月14日 17:18 tang Exp $
  */
class MathTest extends FunSuite {
  
  test("204. Count Primes") {
    assert(_204_CountPrimes.countPrimes(0) == 0)
    assert(_204_CountPrimes.countPrimes(1) == 0)
    assert(_204_CountPrimes.countPrimes(2) == 0)
    assert(_204_CountPrimes.countPrimes(10) == 4)
  }
  
  test("223. Rectangle Area") {
    assert(_223_RectangleArea.computeArea(-2, -2, 2, 2, -1, 4, 1, 6) == 20)
    assert(_223_RectangleArea.computeArea(-2, -2, 2, 2, 3, 3, 4, 4) == 17)
    assert(_223_RectangleArea.computeArea(3, 3, 4, 4, -2, -2, 2, 2) == 17)
  }
  
  test("224. Basic Calculator") {
    assert(_224_BasicCalculator.calculate("1 + 1") == 2)
    assert(_224_BasicCalculator.calculate(" 2-1 + 2 ") == 3)
    assert(_224_BasicCalculator.calculate("(1+(4+5+2)-3)+(6+8)") == 23)
    assert(_224_BasicCalculator.calculate("(1+(4+5+2)-3)-(6+8)") == -5)
    assert(_224_BasicCalculator.calculate("2147483647") == 2147483647)
    assert(_224_BasicCalculator.calculate("2147483647+2147483647-2147483647") == 2147483647)
  }
  
  test("273. Integer to English Words") {
    assert(_273_IntegerToEnglishWords.numberToWords(1000010) == "One Million Ten")
    assert(_273_IntegerToEnglishWords.numberToWords(1000000) == "One Million")
    assert(_273_IntegerToEnglishWords.numberToWords(101) == "One Hundred One")
    assert(_273_IntegerToEnglishWords.numberToWords(0) == "Zero")
    assert(_273_IntegerToEnglishWords.numberToWords(15) == "Fifteen")
    assert(_273_IntegerToEnglishWords.numberToWords(123) == "One Hundred Twenty Three")
    assert(_273_IntegerToEnglishWords.numberToWords(12345) == "Twelve Thousand Three Hundred Forty Five")
    assert(_273_IntegerToEnglishWords.numberToWords(1234567) == "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven")
    assert(_273_IntegerToEnglishWords.numberToWords(1234567891) == "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One")
  }
  
  test("313. Super Ugly Number") {
    assert(_313_SuperUglyNumber.nthSuperUglyNumber(12, Array(2, 7, 13, 19)) == 32)
  }
  
}
