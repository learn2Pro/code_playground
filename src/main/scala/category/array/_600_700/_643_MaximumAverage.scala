/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._600_700

/**
  * 643. Maximum Average Subarray I
  */
object _643_MaximumAverage {
  def findMaxAverage(nums: Array[Int], k: Int): Double = {
    if (nums.length < k) return 0.0
    var sum = 0
    for (i <- 0 until k) sum += nums(i)
    var ans = sum / k.toDouble
    for (j <- k until nums.length) {
      sum = sum + nums(j) - nums(j - k)
      ans = Math.max(ans, sum / k.toDouble)
    }
    ans
  }
}
