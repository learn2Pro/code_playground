package category.math._300_400

/**
  * 400. Nth Digit
  */
object _400_NthDigit {
  def findNthDigit(n: Int): Int = {
    var step = 1
    var range: Long = 9
    var tmp:Long = n
    while (tmp > range * step) {
      tmp -= range * step
      step += 1
      range *= 10
    }
    val which = (tmp - 1) / step
    val remain = (tmp - 1) % step
    (Math.pow(10, step - 1).toLong + which).toString.charAt(remain.toInt) - 48
  }
}