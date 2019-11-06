/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._200_300

/**
  * 238. Product of Array Except Self
  */
object _238_ProductArrayExceptSelf {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val ans = Array.tabulate(nums.length)(_ => 1)
    /*left product*/
    for (i <- 1 until ans.length) {
      ans(i) = nums(i - 1) * ans(i - 1)
    }
    /*right product*/
    for (i <- Range(ans.length - 2, -1, -1)) {
      ans(i) = ans(i) * nums(i + 1)
      nums(i) = nums(i) * nums(i + 1)
    }
    ans
  }
}
