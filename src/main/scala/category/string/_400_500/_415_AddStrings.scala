/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.string._400_500

/**
  * 415. Add Strings
  */
object _415_AddStrings {
  def addStrings(num1: String, num2: String): String = {
    val N = Math.max(num1.length, num2.length)
    
    def fill(s: String): String = {
      if (s.length == N) s
      else {
        val filled = new String(Array.tabulate(N - s.length)(_ => '0'))
        filled + s
      }
    }
    
    val s0 = fill(num1)
    val s1 = fill(num2)
    val ans = new StringBuilder
    val last = s0.zip(s1).foldRight(0) { case ((l, r), incr) =>
      val add = l - '0' + r - '0' + incr
      ans.append(add % 10)
      add / 10
    }
    if (last != 0) ans.append(last)
    ans.reverse.toString()
  }
}
