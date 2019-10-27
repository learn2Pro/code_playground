package category.time.week38

object PalindromePartitionII {
  def minCut(s: String): Int = {
    if (s == null || s.isEmpty) return 0
    val dp = Array.tabulate(s.length + 1)(_ => -1)
    dp(0) = -1
    dp(1) = 0
    for (i <- 1 until s.length) {
      if (s(i) == s(i - 1) && dp.slice(0, i).forall(_ == 0)) {
        dp(i + 1) = dp(i)
      } else {
        dp(i + 1) = (for (j <- 0 until i) yield {
          if (isPalin(s.substring(j, i + 1))) dp(j) + 1
          else dp(i) + 1
        }).min
      }
    }
    dp(s.length)
  }
  
  
  private def isPalin(s: String): Boolean = {
    var i = 0
    var j = s.length - 1
    
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j)) return false
      
      i += 1
      j -= 1
    }
    
    true
  }
  
}