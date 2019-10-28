package category.bitmanipulation

/**
  * 476. Number Complement
  */
object NumberComplement {
  def findComplement(num: Int): Int = {
    val leading = java.lang.Integer.numberOfLeadingZeros(num)
    var mask = 1
    for (i <- 0 until 32 - leading) {
      mask |= 1 << i
    }
    mask ^ num
  }
}