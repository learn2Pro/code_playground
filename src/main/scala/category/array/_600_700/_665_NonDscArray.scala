/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._600_700

/**
  * 665. Non-decreasing Array
  */
object _665_NonDscArray {
  def checkPossibility(nums: Array[Int]): Boolean = {
    if (nums.length <= 1) return true
    var expect = 1
    for (i <- 1 until nums.length if nums(i) < nums(i - 1)) {
      expect -= 1
      
      def twoSideReady(i: Int): Boolean = {
        i - 1 < 0 || i + 1 >= nums.length || nums(i - 1) < nums(i + 1)
      }
      
      if (!(twoSideReady(i) || twoSideReady(i - 1)) || expect < 0) return false
    }
    true
  }
}
