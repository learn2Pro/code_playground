package category.greedy

/**
  * 738. Monotone Increasing Digits
  */
object _738_Solution {
  def monotoneIncreasingDigits(N: Int): Int = {
    val s = N.toString.toCharArray
    var i = 1
    while (i > 0 && i < s.length && s(i - 1) <= s(i)) i += 1
    while (i > 0 && i < s.length && s(i - 1) > s(i)) {s(i - 1) = (s(i - 1) - 1).toChar; i -= 1}
    for (j <- i + 1 until s.length) s(j) = '9'
    new String(s).toInt
  }
}