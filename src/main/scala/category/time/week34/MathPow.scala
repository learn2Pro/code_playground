/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week34

/**
  *
  * @author derong.tdr
  * @version MathPow.scala, v 0.1 2019年08月25日 08:42 tang Exp $
  */
object MathPow {
  def myPow(x: Double, n: Int): Double = {
    if (n == 0)
      return 1
    if (x == 0)
      return 0

    val temp = if (n > 0) {myPow(x, n / 2)} else if (n == Int.MinValue) {myPow(x, n + 1)} else {
      return 1 / myPow(x, -n)
    }


    if (n % 2 == 0)
      temp * temp
    else
      temp * temp * x
  }

  //  def myPow(x: Double, n: Int): Double = {
  //    if (n == 0) return 1.0
  //    val isNegative = n < 0
  //    val times: Long = if (isNegative) -1L * n else n
  //    var tmp: Double = x
  //    val dp = new util.HashMap[Long, Double]()
  //    dp.put(1, x)
  //    var location: Long = 2
  //    while (location <= times) {
  //      tmp *= tmp
  //      dp.put(location, tmp)
  //      location = location << 1
  //    }
  //    val remain = times - (location >> 1)
  //    location = 1
  //    while (location <= remain) location = location << 1
  //    location = location >> 1
  //    if (location > 0) {
  //      tmp *= dp.get(location)
  //    }
  //    for (_ <- 0 until (remain - location).toInt if tmp != 0.0) tmp *= x
  //    if (isNegative && tmp != 0.0) {1 / tmp} else tmp
  //  }
}
