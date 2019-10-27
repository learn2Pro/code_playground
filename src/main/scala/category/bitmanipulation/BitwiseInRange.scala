package category.bitmanipulation


/**
  * 201. Bitwise AND of Numbers Range
  */
object BitwiseInRange {
  def rangeBitwiseAnd(m: Int, n: Int): Int = {
    var mask = Int.MaxValue
    while ((m & mask) != (n & mask)) {
      mask <<= 1
    }
    m & mask
  }
}