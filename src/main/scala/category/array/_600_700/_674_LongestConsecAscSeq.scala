/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._600_700

/**
  * 674. Longest Continuous Increasing Subsequence
  */
object _674_LongestConsecAscSeq {
  def findLengthOfLCIS(nums: Array[Int]): Int = {
    if (nums == null || nums.isEmpty) return 0
    var last = nums.head
    var ans = 0
    var currentSz = 1
    for (i <- 1 until nums.length) {
      if (nums(i) > last) {
        last = nums(i)
        currentSz += 1
      } else {
        ans = Math.max(ans, currentSz)
        currentSz = 1
        last = nums(i)
      }
    }
    Math.max(ans, currentSz)
  }
}
