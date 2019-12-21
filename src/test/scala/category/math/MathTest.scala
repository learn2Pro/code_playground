/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.math

import category.math._200_300.{_204_CountPrimes, _223_RectangleArea, _224_BasicCalculator, _273_IntegerToEnglishWords}
import category.math._300_400._
import category.math._400_500.{_423_ReconstructOriginDigitFromEng, _441_ArrangingCoins}
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
  
  test("319. Bulb Switcher") {
    assert(_319_BulbSwitcher.bulbSwitch(4) == 2)
    assert(_319_BulbSwitcher.bulbSwitch(2) == 1)
    assert(_319_BulbSwitcher.bulbSwitch(3) == 1)
    assert(_319_BulbSwitcher.bulbSwitch(5) == 2)
    assert(_319_BulbSwitcher.bulbSwitch(9) == 3)
    assert(_319_BulbSwitcher.bulbSwitch(16) == 4)
    assert(_319_BulbSwitcher.bulbSwitch(24) == 4)
    assert(_319_BulbSwitcher.bulbSwitch(25) == 5)
    assert(_319_BulbSwitcher.bulbSwitch(9999999) == 5)
  }
  
  test("335. Self Crossing") {
    assert(_335_SelfCrossing.isSelfCrossing(Array(2, 1, 1, 2)))
    assert(!_335_SelfCrossing.isSelfCrossing(Array(1, 2, 3, 4)))
    assert(_335_SelfCrossing.isSelfCrossing(Array(1, 1, 1, 1)))
    assert(_335_SelfCrossing.isSelfCrossing(Array(1, 1, 2, 1, 1)))
  }
  
  test("365. Water and Jug Problem") {
    assert(_365_WaterAndJugProblem.canMeasureWater(22003, 31237, 1))
    assert(_365_WaterAndJugProblem.canMeasureWater(3, 5, 7))
    assert(_365_WaterAndJugProblem.canMeasureWater(3, 5, 4))
    assert(!_365_WaterAndJugProblem.canMeasureWater(2, 6, 5))
  }
  
  test("_372_SuperPow") {
    assert(_372_SuperPow.superPow(2, Array(3)) == 8)
    assert(_372_SuperPow.superPow(2, Array(1, 0)) == 1024)
    assert(_372_SuperPow.superPow(2, Array(1, 2, 3)) == 1191)
  }
  
  test("_396_RotateFunction") {
    assert(_396_RotateFunction.maxRotateFunction(Array(4, 3, 2, 6)) == 26)
    assert(_396_RotateFunction.maxRotateFunction(Array(Int.MinValue, Int.MinValue)) == Int.MinValue)
  }
  
  test("_400_NthDigit") {
    assert(_400_NthDigit.findNthDigit(1000000000) == 1)
    assert(_400_NthDigit.findNthDigit(3) == 3)
    assert(_400_NthDigit.findNthDigit(15) == 2)
    assert(_400_NthDigit.findNthDigit(14) == 1)
    assert(_400_NthDigit.findNthDigit(13) == 1)
    assert(_400_NthDigit.findNthDigit(11) == 0)
    assert(_400_NthDigit.findNthDigit(10) == 1)
    assert(_400_NthDigit.findNthDigit(101) == 5)
  }
  
  test("423. Reconstruct Original Digits from English") {
    assert(_423_ReconstructOriginDigitFromEng.originalDigits("zerozero") == "00")
    assert(_423_ReconstructOriginDigitFromEng.originalDigits("zeroonetwothreefourfivesixseveneightnine") == "0123456789")
    assert(_423_ReconstructOriginDigitFromEng.originalDigits("ereht") == "3")
    assert(_423_ReconstructOriginDigitFromEng.originalDigits("six") == "6")
    assert(_423_ReconstructOriginDigitFromEng.originalDigits("seven") == "7")
    assert(_423_ReconstructOriginDigitFromEng.originalDigits("eight") == "8")
    assert(_423_ReconstructOriginDigitFromEng.originalDigits("nine") == "9")
    assert(_423_ReconstructOriginDigitFromEng.originalDigits("owoztneoer") == "012")
    assert(_423_ReconstructOriginDigitFromEng.originalDigits("fviefuro") == "45")
  }
  
  test("441. Arranging Coins") {
    assert(_441_ArrangingCoins.arrangeCoins(1) == 1)
    assert(_441_ArrangingCoins.arrangeCoins(5) == 2)
    assert(_441_ArrangingCoins.arrangeCoins(8) == 3)
    assert(_441_ArrangingCoins.arrangeCoins(9) == 3)
    assert(_441_ArrangingCoins.arrangeCoins(10) == 4)
    assert(_441_ArrangingCoins.arrangeCoins(11) == 4)
    assert(_441_ArrangingCoins.arrangeCoins(1804289383) == 60070)
  }
  
}
