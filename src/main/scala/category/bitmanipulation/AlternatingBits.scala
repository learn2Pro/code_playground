package category.bitmanipulation

/**
  * 693. Binary Number with Alternating Bits
  */
object AlternatingBits {
  def hasAlternatingBits(n: Int): Boolean = {
    val leading = java.lang.Integer.numberOfLeadingZeros(n)
    var mask = 0
    for (i <- 0 until 31 - leading) {
      mask |= 1 << i
    }
    ((n ^ (n >>> 1)) & mask) == mask
  }
}