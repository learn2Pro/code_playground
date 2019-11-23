package category.dp._300_400

/**
  * 376. Wiggle Subsequence
  */
object _376_WiggleSubSequence {
  def wiggleMaxLength(nums: Array[Int]): Int = {
    if (nums.length == 0 || nums.length == 1) return nums.length
    var down, up = 1
    for (i <- 1 until nums.length) {
      if (nums(i) > nums(i - 1)) {
        up = down + 1
      } else if (nums(i) < nums(i - 1)) {
        down = up + 1
      }
    }
    Math.max(up, down)
  }
  
  def wiggleMaxLengthV1(nums: Array[Int]): Int = {
    
    if (nums.length == 0 || nums.length == 1) return nums.length
    val dp = Array.tabulate(nums.length)(_ => (1, 0))
    var ans = 0
    for (i <- 1 until nums.length) {
      val j = i - 1
      for (j <- Range(i - 1, -1, -1)) {
        if (dp(j)._2 == 0 && nums(i) != nums(j) && dp(j)._1 + 1 > dp(i)._1) {
          dp(i) = (dp(j)._1 + 1, nums(i) - nums(j))
        } else if (dp(j)._2 < 0 && nums(i) - nums(j) > 0 && dp(j)._1 + 1 > dp(i)._1) {
          dp(i) = (dp(j)._1 + 1, nums(i) - nums(j))
        } else if (dp(j)._2 > 0 && nums(i) - nums(j) < 0 && dp(j)._1 + 1 > dp(i)._1) {
          dp(i) = (dp(j)._1 + 1, nums(i) - nums(j))
        }
      }
      ans = Math.max(ans, dp(i)._1)
    }
    ans
  }
}