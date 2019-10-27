/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week34

/**
  *
  * @author derong.tdr
  * @version MultiplyStrings.scala, v 0.1 2019年08月24日 22:04 tang Exp $
  */
object MultiplyStrings {
  def multiply(num1: String, num2: String): String = {
    if (num1 == null || num2 == null || num1.isEmpty || num2.isEmpty) return ""
    if (num1 == "0" || num2 == "0") return "0"
    num1.reverse.map { c =>
      multiOnePass(c, num2)
    }.reverse.reduce(addOnePass)
  }

  private def multiOnePass(c: Char, other: String): String = {
    var carry = 0
    val out = other.foldRight("") { case (curr, prefix) =>
      val multi = (c - '0') * (curr - '0') + carry
      carry = multi / 10
      multi % 10 + prefix
    }
    if (carry != 0) carry + out
    else out
  }

  private def addOnePass(first: String, second: String): String = {
    val siftFirst = first + '0'
    val maxLen = Math.max(siftFirst.length, second.length)
    var updateFirst = siftFirst
    var updateSecond = second
    if (siftFirst.length < maxLen) {
      updateFirst = String.copyValueOf(Array.tabulate(maxLen - siftFirst.length)(_ => '0')) + siftFirst
    }
    if (second.length < maxLen) {
      updateSecond = String.copyValueOf(Array.tabulate(maxLen - second.length)(_ => '0')) + second
    }
    var carry = 0
    val out = updateFirst.zip(updateSecond).foldRight("") { case ((c0, c1), prefix) =>
      val add = (c0 - '0') + (c1 - '0') + carry
      carry = add / 10
      add % 10 + prefix
    }
    if (carry != 0) carry + out
    else out
  }
}
