/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._600_700

/**
  * 628. Maximum Product of Three Numbers
  */
object _628_MaximumProductOfThree {
  /*one pass scan*/
  def maximumProduct(nums: Array[Int]): Int = {
    var min0, min1 = Int.MaxValue
    var max0, max1, max2 = Int.MinValue
    
    def updateMin(i: Int) = {
      /*i<=min0<min1*/
      if (nums(i) <= min0) {
        min1 = min0
        min0 = nums(i)
      }
      /*min0<i<=min1*/
      else if (nums(i) > min0 && nums(i) <= min1) {
        min1 = nums(i)
      }
    }
    
    def updateMax(i: Int) = {
      /*max0<=i<max1<max2*/
      if (max0 <= nums(i) && max1 > nums(i)) {
        max0 = nums(i)
      }
      /*max0<max1<=i<max2*/
      else if (max1 <= nums(i) && nums(i) < max2) {
        max0 = max1
        max1 = nums(i)
      }
           /*max0<max1<max2<i*/
      else if (max2 <= nums(i)) {
        max0 = max1
        max1 = max2
        max2 = nums(i)
      }
    }
    
    for (i <- nums.indices) {
      updateMax(i)
      updateMin(i)
    }
    Math.max(max2 * min0 * min1, max0 * max1 * max2)
  }
  
  /*use sort*/
  def maximumProductV0(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    val n = sorted.length - 1
    Math.max(sorted(n) * sorted(n - 1) * sorted(n - 2), sorted(n) * sorted(0) * sorted(1))
  }
}
