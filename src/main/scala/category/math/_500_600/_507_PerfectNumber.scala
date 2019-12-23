package category.math._500_600

/**
  * 507. Perfect Number
  */
object _507_PerfectNumber {
  def pn(p: Int): Int = (1 << (p - 1)) * ((1 << p) - 1)
  
  def checkPerfectNumber(num: Int): Boolean = {
    val primes = Array[Int](2, 3, 5, 7, 13, 17, 19, 31)
    for (prime <- primes) {
      if (pn(prime) == num) return true
    }
    false
  }
//  def checkPerfectNumber(num: Int): Boolean = {
//    if (num == 1) return true
//    var i = 2
//    var sum = 1
//    while (i * i <= num) {
//      if (num % i == 0) {
//        val decr = if (i == num / i) i else 0
//        sum += (i + num / i - decr)
//      }
//      i += 1
//    }
//    sum == num
//  }
}