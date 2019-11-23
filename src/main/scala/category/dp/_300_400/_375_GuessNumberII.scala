package category.dp._300_400


/**
  * 375. Guess Number Higher or Lower II
  */
object _375_GuessNumberII {
  def getMoneyAmount(n: Int): Int = {
    //        def upperBs(lo: Int, hi: Int, cost: Int): Int = {
    //          if (lo + 1 == hi) return cost + lo
    //          if (lo == hi) return cost
    //          var ans = Int.MaxValue
    //          for (i <- lo + 1 to hi) {
    //            ans = Math.min(ans, Math.max(upperBs(i + 1, hi, cost + i), upperBs(lo, i - 1, cost + i)))
    //          }
    //          ans
    //        }
    //    upperBs(1,n,0)
    
    val dp = Array.tabulate(n + 2, n + 2) { (_, _) => 0 }
    dp(1)(1) = 0
    dp(1)(2) = 1
    for (j <- 3 to n) {
      for (i <- Range(j - 1, 0, -1)) {
        if (j == i + 1) dp(i)(j) = i
        else {
          var global = Int.MaxValue
          for (k <- i + 1 until j) {
            global = Math.min(global, k + Math.max(dp(i)(k - 1), dp(k + 1)(j)))
          }
          dp(i)(j) = global
        }
      }
    }
    dp(1)(n)
  }
}