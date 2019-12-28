/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.string._300_400

/**
  * 344. Reverse String
  */
object _344_ReverseString {
  def reverseString(s: Array[Char]): Unit = {
    if (s.isEmpty) return
    val N = s.length
    var l = 0
    var r = N - 1
    while (l < r) {
      val tmp = s(l)
      s(l) = s(r)
      s(r) = tmp
      l += 1
      r -= 1
    }
  }
}
