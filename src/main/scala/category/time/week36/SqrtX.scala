/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36


/**
  *
  * @author derong.tdr
  * @version SqrtX.scala, v 0.1 2019年09月08日 11:58 tang Exp $
  */
object SqrtX {
  /**
    * newton iter
    */
  def mySqrt(x: Int): Int = {
    var c = x.toFloat
    val xhalf = 0.5f * c
    var i = java.lang.Float.floatToIntBits(c); // get bits for floating VALUE
    i = 0x5f375a86 - (i >> 1); // gives initial guess y0
    c = java.lang.Float.intBitsToFloat(i); // convert bits BACK to float
    c = c * (1.5f - xhalf * c * c); // Newton step, repeating increases accuracy
    (1 / c).toInt
  }

  def intToByteArray(a: Int): Array[Byte] = {
    Array[Byte](
      ((a >> 24) & 0xFF).toByte,
      ((a >> 16) & 0xFF).toByte,
      ((a >> 8) & 0xFF).toByte,
      (a & 0xFF).toByte
    )
  }


}
