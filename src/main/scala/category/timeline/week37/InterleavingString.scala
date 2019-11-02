package category.timeline.week37

/**
  * 97. Interleaving String
  */
object InterleavingString {
  def isInterleave(s1: String, s2: String, s3: String): Boolean = {
    if (s1.length + s2.length != s3.length) return false
    val m = s1.length + 1
    val n = s2.length + 1
    val dp = Array.tabulate[Boolean](m, n)((_, _) => false)
    dp(0)(0) = true
    for (i <- 1 until m if s1(i - 1) == s3(i - 1) && dp(i - 1)(0)) {
      dp(i)(0) = true
    }
    for (j <- 1 until n if s2(j - 1) == s3(j - 1) && dp(0)(j - 1)) {
      dp(0)(j) = true
    }
    for (i <- 1 until m)
      for (j <- 1 until n if s1(i - 1) == s3(i + j - 1) || s2(j - 1) == s3(i + j - 1)) {
        //up
        if (dp(i - 1)(j) && s1(i - 1) == s3(i + j - 1)) {
          dp(i)(j) = true
        }
        if (dp(i)(j - 1) && s2(j - 1) == s3(i + j - 1)) {
          dp(i)(j) = true
        }
      }
    dp(m - 1)(n - 1)
  }
}