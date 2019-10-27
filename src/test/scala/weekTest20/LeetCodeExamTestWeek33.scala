package weekTest20

import org.scalatest.FunSuite
import category.time.week34._
import category.time.week35.JumpGameII

/**
  * @author tang
  * @date 2019/08/03
  */
class LeetCodeExamTestWeek33 extends FunSuite {

  test("67. Add Binary") {
    //    assert(AddBinary.addBinary("11", "1") == "100")
    assert(AddBinary.addBinary("1010", "1011") == "10101")
  }

  test("42. Trapping Rain Water") {
    assert(TrapRainWater.trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) == 6)
  }

  test("43. Multiply Strings") {
    //    assert(MultiplyStrings.multiply("2", "3") == "6")
    assert(MultiplyStrings.multiply("123", "456") == "56088")
  }

  /**
    * 0.00001
    * 2147483647
    */
  test("50. Pow(x, n)") {
    //    assert(MathPow.myPow(2.0, 10) == 1024.0)
    //    assert(MathPow.myPow(2.0, 0) == 1.0)
    //    assert(MathPow.myPow(2.0, 1) == 2.0)
    //    assert(MathPow.myPow(2.1, 3) == 9.26100)
    //    assert(MathPow.myPow(2.0, -2) == 0.25000)
    //    assert(MathPow.myPow(34.00515, -3) == 3e-05)
    //    assert(MathPow.myPow(0.00001, 2147483647) == 0.0)
    assert(MathPow.myPow(0.00001, -2147483648) == 0.0)
  }

  test("44. Wildcard Matching") {
    assert(WildCardMatching.isMatch("aa", "a") == false)
    assert(WildCardMatching.isMatch("aa", "*") == true)
    assert(WildCardMatching.isMatch("cb", "?a") == false)
    assert(WildCardMatching.isMatch("adceb", "*a*b") == true)
    assert(WildCardMatching.isMatch("acdcb", "a*c?b") == false)
    assert(WildCardMatching.isMatch("aaaa", "***a") == true)
    assert(WildCardMatching.isMatch("ho", "**ho") == true)
  }

  test("45. Jump Game II") {
    assert(JumpGameII.jump(Array(2, 3, 1, 1, 4)) == 2)
    assert(JumpGameII.jump(Array(5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5))
            == 4)
  }

}
