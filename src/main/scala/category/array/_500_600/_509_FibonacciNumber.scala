/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._500_600

/**
  * 509. Fibonacci Number
  */
object _509_FibonacciNumber {
  def fib(N: Int): Int = {
    
    import scala.annotation.tailrec
    @tailrec
    def tailFib(n: Int, left: Int, right: Int): Int = {
      if (n == 0) return left
      if (n == 1) return right
      tailFib(n - 1, right, left + right)
    }
    
    tailFib(N, 0, 1)
  }
}
