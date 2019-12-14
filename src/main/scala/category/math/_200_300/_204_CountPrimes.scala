/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.math._200_300

/**
  * 204. Count Primes
  */
object _204_CountPrimes {
  def countPrimes(n: Int): Int = {
    if (n == 0) return 0
    if (n == 1) return 0
    val primes = Array.tabulate(n)(_ => true)
    primes(0) = false
    primes(1) = false
    var p = 2
    while (p * p < n) {
      if (primes(p)) {
        for (i <- Range(p * p, n, p)) primes(i) = false
      }
      p += 1
    }
    primes.count(identity)
  }
  
  //  def countPrimes(n: Int): Int = {
  //    def isPrime(num: Int): Boolean = {
  //      if (num <= 1) return false
  //      var i = 2
  //      while (i * i <= num) {
  //        if (num % i == 0) return false
  //        i += 1
  //      }
  //      true
  //    }
  //
  //    var ans = 0
  //    for (k <- 0 until n if isPrime(k)) {
  //      ans += 1
  //    }
  //    ans
  //  }
}
