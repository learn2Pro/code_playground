package week31

/**
  * @author tang
  * @date 2019/08/03
  */
object DivideTwoIntegersSolution {

  private def negative(a: Int) = {
    add(~a, 1)
  }

  private def isPositive(a: Int): Boolean = {
    val ans = a >>> 31
    ans != 1
  }

  private def positive(a: Int) = {
    if (isPositive(a)) a
    else add(~a, 1)
  }

  def add(a: Int, b: Int): Int = {
    //sum+carry
    if (b == 0) return a
    add(a ^ b, (a & b) << 1)
  }

  def minus(a: Int, b: Int): Int = {
    add(a, negative(b))
  }

  def multiply(a: Int, b: Int): Int = {
    var multiplicand = positive(a)
    var multiplier = positive(b)
    val negative = isPositive(a) ^ isPositive(b)
    var ans = 0
    while (multiplier > 0) {
      val tmp = multiplier & 1
      if (tmp == 1) {
        ans = add(ans, multiplicand)
      }
      multiplicand <<= 1
      multiplier >>= 1
    }
    if (negative) add(~ans, 1) else ans
  }

  def divide(dividend: Int, divisor: Int): Int = {
    if (dividend == Int.MinValue && divisor == Int.MinValue) return 1
    if (divisor == Int.MinValue) return 0
    var a = positive(dividend)
    val b = positive(divisor)
    val negative = isPositive(dividend) ^ isPositive(divisor)
    var i = 31
    var ans = 0
    while (i >= 0) {
      val tmp = a >>> i
      if (tmp >= b || tmp == Int.MinValue) {
        ans = add(ans, 1 << i)
        a = minus(a, b << i)
      }
      i = minus(i, 1)
    }
    if (ans < 0 && !negative) return Int.MaxValue
    if (negative) add(~ans, 1) else ans
  }
}
