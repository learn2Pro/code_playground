package weekTest20

import org.scalatest.FunSuite
import week34._

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

}
