package week37

/**
  * 96. Unique Binary Search Trees
  */
object UniqueBinarySearchTrees {
  def numTrees(n: Int): Int = {
    if (n == 0) return 0
    if (n == 1) return 1
    if (n == 2) return 2
    val dp = Array.tabulate(n + 1)(i => i)
    dp(0) = 1
    for (i <- 3 until n + 1) {
      dp(i) = (for (choose <- 0 until i) yield {
        dp(choose) * dp(i - choose - 1)
      }).sum
    }
    dp(n)
  }
}