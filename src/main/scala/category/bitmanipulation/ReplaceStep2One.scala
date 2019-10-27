package category.bitmanipulation

/**
  * 397. Integer Replacement
  */
object ReplaceStep2One {
  def integerReplacement(n: Int): Int = {
    var tmp:Long = n
    var step = 0
    while (tmp > 1) {
      if (tmp % 2 == 0) tmp >>= 1
      else if (tmp != 3 && tmp != 7 && java.lang.Long.numberOfTrailingZeros(tmp - 1) > java.lang.Long.numberOfTrailingZeros(tmp + 1)) {
        tmp -= 1
      }
      else {
        tmp += 1
      }
      step += 1
    }
    step
  }
  
}