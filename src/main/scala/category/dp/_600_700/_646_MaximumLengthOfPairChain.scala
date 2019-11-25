package category.dp._600_700

/**
  * 646. Maximum Length of Pair Chain
  */
object _646_MaximumLengthOfPairChain {
  def findLongestChain(pairs: Array[Array[Int]]): Int = {
    if (pairs.isEmpty) return 0
    val sorted = pairs.sortBy(arr => arr(1))
    val dp = Array.tabulate(sorted.length)(_ => 0)
    dp(0) = 1
    var ans = 1
    for (i <- 1 until sorted.length) {
      for (j <- Range(i - 1, -1, -1)) {
        val incr = if (sorted(i)(0) > sorted(j)(1)) {
          dp(j) + 1
        } else 1
        dp(i) = Math.max(dp(i), incr)
      }
      ans = Math.max(ans, dp(i))
    }
    ans
  }
}