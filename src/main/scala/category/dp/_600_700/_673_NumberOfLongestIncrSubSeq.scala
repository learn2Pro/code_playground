package category.dp._600_700

/**
  * 673. Number of Longest Increasing Subsequence
  */
object _673_NumberOfLongestIncrSubSeq {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    val n = nums.length
    if (n <= 1) return n
    val lengths = Array.tabulate(n)(_ => 0)
    val counts = Array.tabulate(n)(_ => 1)
    for (j <- 0 until n)
      for (i <- 0 until j if nums(i) < nums(j)) {
        if (lengths(i) >= lengths(j)) {
          lengths(j) = lengths(i) + 1
          counts(j) = counts(i)
        } else if (lengths(i) + 1 == lengths(j)) {
          counts(j) += counts(i)
        }
      }
    val longest = lengths.max
    var ans = 0
    for (i <- 0 until n if lengths(i) == longest) {
      ans += counts(i)
    }
    ans
  }
}