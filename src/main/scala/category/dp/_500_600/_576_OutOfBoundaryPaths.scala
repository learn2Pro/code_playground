package category.dp._500_600

/**
  * 576. Out of Boundary Paths
  */
object _576_OutOfBoundaryPaths {
  def findPaths(m: Int, n: Int, N: Int, i: Int, j: Int): Int = {
    val MOD = 1000000007
    val dp = Array.tabulate[Long](m, n, 2)((_, _, _) => 0)
    
    def isBoundary(i: Int, j: Int): Boolean = {
      i < 0 || i >= m || j < 0 || j >= n
    }
    
    var ans: Long = 0
    
    dp(i)(j)(0) = 1
    for (iter <- 0 until N)
      for (i <- 0 until m)
        for (j <- 0 until n) {
          val prev = iter % 2
          val loc = (iter + 1) % 2
          if (isBoundary(i - 1, j) && iter + 1 <= N) {
            ans += dp(i)(j)(prev) % MOD
          }
          else if (iter + 1 < N) dp(i - 1)(j)(loc) += (dp(i)(j)(prev) % MOD)
          if (isBoundary(i + 1, j) && iter + 1 <= N) {
            ans += dp(i)(j)(prev) % MOD
          }
          else if (iter + 1 < N) dp(i + 1)(j)(loc) += (dp(i)(j)(prev) % MOD)
          if (isBoundary(i, j - 1) && iter + 1 <= N) {
            ans += dp(i)(j)(prev) % MOD
          }
          else if (iter + 1 < N) dp(i)(j - 1)(loc) += (dp(i)(j)(prev) % MOD)
          if (isBoundary(i, j + 1) && iter + 1 <= N) {
            ans += dp(i)(j)(prev) % MOD
          }
          else if (iter + 1 < N) dp(i)(j + 1)(loc) += (dp(i)(j)(prev) % MOD)
          dp(i)(j)(prev) = 0
        }
    (ans % MOD).toInt
  }
}