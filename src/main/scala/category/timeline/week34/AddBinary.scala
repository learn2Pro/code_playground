/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week34

/**
  * Given two binary strings, return their sum (also a binary string).
  *
  * The input strings are both non-empty and contains only characters 1 or 0.
  *
  * Example 1:
  *
  * Input: a = "11", b = "1"
  * Output: "100"
  * Example 2:
  *
  * Input: a = "1010", b = "1011"
  * Output: "10101"
  *
  * @author derong.tdr
  * @version AddBinary.scala, v 0.1 2019年08月24日 11:50 tang Exp $
  */
object AddBinary {
  def addBinary(a: String, b: String): String = {
    val maxLen = Math.max(a.length, b.length)
    var completionA = a
    if (a.length < maxLen) {
      completionA = String.copyValueOf(Array.tabulate(maxLen - a.length)(_ => '0')) + a
    }
    var completionB = b
    if (b.length < maxLen) {
      completionB = String.copyValueOf(Array.tabulate(maxLen - b.length)(_ => '0')) + b
    }
    var carry = 0
    val ans = completionA.zip(completionB).foldRight("") {
      case ((l, r), prefix) =>
        val sum = l - '0' + r.toInt - '0' + carry
        val remain = sum % 2
        carry = sum / 2
        s"$remain" + prefix
    }
    if (carry == 1) {
      '1' + ans
    } else ans
  }

}
