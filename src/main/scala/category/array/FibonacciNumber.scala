package category.array


/**
  * 509. Fibonacci Number
  */
object FibonacciNumber {
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