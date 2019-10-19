package week42

/**
  * 172. Factorial Trailing Zeroes
  */
object FactorialTrailingZero {
  def trailingZeroes(n: Int): Int = {
    var tmp = n
    var ans = 0
    while (tmp > 0) {
      tmp /= 5
      ans += tmp
    }
    ans
  }
  
  private def trailingOfNumber(num: Int, specified: Int): Int = {
    var tmp = num
    var count = 0
    while (tmp % specified == 0) {
      count += 1
      tmp /= specified
    }
    count
  }
}