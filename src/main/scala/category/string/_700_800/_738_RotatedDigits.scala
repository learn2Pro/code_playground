package category.string._700_800

/**
  * 788. Rotated Digits
  */
object _788_RotatedDigits {
  def rotatedDigits(N: Int): Int = {
    var ans = 0
    for (i <- 1 until N) {
      val digits = i.toString
      if (digits.forall(c => c == '1' || c == '0' || c == '8')) ans += 0
      else if (digits.exists(c => c == '3' || c == '4' || c == '7')) ans += 0
      else ans += 1
    }
    ans
  }
}