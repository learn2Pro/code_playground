package category.dp._300_400

/**
  * 343. Integer Break
  */
object _343_IntegerBreak {
  def integerBreak(n: Int): Int = {
    if (n == 2 || n == 3) return n - 1
    if (n == 4) return n
    val tmp = n - 5
    (Math.pow(3, tmp / 3 + 1) * (tmp % 3 + 2)).toInt
  }
  
  def integerBreakV2(n: Int): Int = {
    val dp = Array.tabulate(n + 1) { _ => 1 }
    for (i <- 3 to n) {
      for (j <- i / 2 until i) {
        dp(i) = Math.max(j * (i - j), Math.max(dp(i), dp(j) * (i - j)))
      }
    }
    dp(n)
  }
}