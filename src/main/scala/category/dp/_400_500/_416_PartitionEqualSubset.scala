package category.dp._400_500

/**
  * 416. Partition Equal Subset Sum
  */
object _416_PartitionEqualSubset {
  def canPartition(nums: Array[Int]): Boolean = {
    val sum = nums.sum
    if (sum % 2 != 0) return false
    val dp = Array.tabulate(nums.length + 1, nums.length + 1)((_, _) => 0)
    for (j <- 1 until nums.length + 1) {
      for (i <- 0 until j) {
        var stop = false
        var k = j - 1
        while (!stop && k >= 0) {
          if (dp(i)(k) + nums(j - 1) <= sum / 2) {
            dp(i)(j) = dp(i)(k) + nums(j - 1)
            if (dp(i)(j) == sum / 2) return true
            stop = true
          }
          k -= 1
        }
      }
    }
    false
  }
}