package category.time.week40

/**
  * 139. Word Break
  */
object WordBreak {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    if (s == null) return false
    val dict = wordDict.toSet
    val dp = Array.tabulate(s.length)(_ => false)
    for (i <- s.indices) {
      if (dict.contains(s.substring(0, i + 1))) {
        dp(i) = true
      } else {
        var location = findNearestTrue(dp, Range(i, -1, -1)) + 1
        while (location > 0) {
          if (dict.contains(s.substring(location, i + 1))) {
            dp(i) = true
            location = -1
          } else {
            location = findNearestTrue(dp, Range(location - 2, -1, -1)) + 1
          }
        }
      }
    }
    dp(s.length - 1)
  }
  
  private def findNearestTrue(dp: Array[Boolean], range: Range): Int = {
    for (j <- range) {
      if (dp(j)) return j
    }
    -1
  }
}