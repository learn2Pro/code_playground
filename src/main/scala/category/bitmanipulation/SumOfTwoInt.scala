package category.bitmanipulation

/**
  * 371. Sum of Two Integers
  */
object SumOfTwoInt {
  def getSum(a: Int, b: Int): Int = {
    val carry = a ^ b
    val bitAnd = a & b
    if (bitAnd == 0) carry
    else getSum(bitAnd << 1, carry)
  }
}