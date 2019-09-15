package week37

object DecodeWays {

  def numDecodings(s: String): Int = {
    if (s == null || s.isEmpty) return 0
    if (s.length == 1) {
      if (s.toInt > 0) {
        return 1
      } else {
        return 0
      }
    }
    val dp = Array.tabulate(s.length)(i => 0)
    if (s.slice(0, 1).toInt != 0) dp(0) = 1
    if (s.slice(0, 2).toInt <= 26 && s.slice(0, 2).toInt >= 10) {
      dp(1) = dp(1) + 1
    }
    if (s.slice(0, 1).toInt != 0 && s.slice(1, 2).toInt != 0) {
      dp(1) = dp(1) + 1
    }
    for (i <- 2 until s.length) {
      val twoHop = if (s.slice(i - 1, i + 1).toInt <= 26 && s.slice(i - 1, i + 1).toInt >= 10) dp(i - 2) else 0
      val oneHop = if (s.slice(i, i + 1).toInt != 0) dp(i - 1) else 0
      dp(i) = oneHop + twoHop
    }
    dp(s.length - 1)
  }
}