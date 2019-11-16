package category.dp._200_300


/**
  * 300. Longest Increasing Subsequence
  */
object _300_LongestIncreasingSubSeq {
  def lengthOfLIS(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val dp = new Array[Int](nums.length)
    var len = 0
    for (num <- nums) {
      var idx = java.util.Arrays.binarySearch(dp, 0, len, num)
      if (idx < 0) {
        idx = -(idx + 1)
      }
      dp(idx) = num
      if (idx == len) len += 1
    }
    len
  }
  
  def lengthOfLISV1(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val dp = Array.tabulate(nums.length)(_ => 1)
    var ans = 1
    for (i <- 1 until nums.length) {
      var inner = 0
      while (inner < i) {
        if (nums(inner) < nums(i)) dp(i) = Math.max(dp(inner) + 1, dp(i))
        inner += 1
      }
      ans = Math.max(dp(i), ans)
    }
    ans
  }
}