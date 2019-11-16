package category.dp._300_400

/**
  * 312. Burst Balloons
  */
object _312_BurstBalloons {
  def maxCoins(nums: Array[Int]): Int = {
    def getNum(idx: Int): Int = {
      if (idx < 0 || idx >= nums.length) 1
      else nums(idx)
    }
    
    val n = nums.length
    val dp = Array.tabulate(n + 2, n + 2)((_, _) => 0)
    var len = 1
    while (len <= n) {
      for (i <- 1 to n - len + 1) {
        val j = i + len - 1
        for (k <- i to j) {
          dp(i)(j) = Math.max(
            dp(i)(j),
            getNum(k) * getNum(i - 1) * getNum(j + 1) + dp(i)(k - 1) + dp(k + 1)(j)
          )
        }
      }
      len += 1
    }
    dp(1)(n)
  }
}