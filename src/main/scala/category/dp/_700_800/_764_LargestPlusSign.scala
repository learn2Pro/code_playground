package category.dp._700_800

/**
  * 764. Largest Plus Sign
  */
object _764_LargestPlusSign {
  def orderOfLargestPlusSign(N: Int, mines: Array[Array[Int]]): Int = {
    val mineSet = mines.map { arr =>
      (arr(0), arr(1))
    }.toSet
    var ans = 0
    val dp = Array.tabulate(N, N)((_, _) => 0)
    
    for (x <- 0 until N) {
      var cnt = 0
      for (y <- 0 until N) {
        cnt = if (mineSet.contains((x, y))) 0 else cnt + 1
        dp(x)(y) = cnt
      }
      cnt = 0
      for (y <- Range(N - 1, -1, -1)) {
        cnt = if (mineSet.contains((x, y))) 0 else cnt + 1
        dp(x)(y) = Math.min(cnt, dp(x)(y))
      }
    }
    for (y <- 0 until N) {
      var cnt = 0
      for (x <- 0 until N) {
        cnt = if (mineSet.contains((x, y))) 0 else cnt + 1
        dp(x)(y) = Math.min(cnt, dp(x)(y))
      }
      cnt = 0
      for (x <- Range(N - 1, -1, -1)) {
        cnt = if (mineSet.contains((x, y))) 0 else cnt + 1
        dp(x)(y) = Math.min(cnt, dp(x)(y))
        ans = Math.max(dp(x)(y), ans)
      }
    }
    
    ans
  }
  
  
}