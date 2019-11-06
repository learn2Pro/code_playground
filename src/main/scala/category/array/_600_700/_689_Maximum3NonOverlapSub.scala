/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._600_700

/**
  * 689. Maximum Sum of 3 Non-Overlapping Subarrays
  */
object _689_Maximum3NonOverlapSub {
  
  def maxSumOfThreeSubarrays(nums: Array[Int], k: Int): Array[Int] = {
    /*initial the window sum*/
    val kWindow = new Array[Int](nums.length - k + 1)
    var windowSum = 0
    for (i <- nums.indices) {
      windowSum += nums(i)
      if (i >= k) windowSum -= nums(i - k)
      if (i >= k - 1) kWindow(i - k + 1) = windowSum
    }
    
    /*initial the left[z]*/
    val leftZ = new Array[Int](kWindow.length)
    var best = 0
    for (i <- leftZ.indices) {
      if (kWindow(i) > kWindow(best)) best = i
      leftZ(i) = best
    }
    /*initial the right[z]*/
    val rightZ = new Array[Int](kWindow.length)
    best = kWindow.length - 1
    for (j <- Range(kWindow.length - 1, -1, -1)) {
      if (kWindow(j) >= kWindow(best)) best = j
      rightZ(j) = best
    }
    val ans = Array(-1, -1, -1)
    for (mid <- k until kWindow.length - k) {
      val l = leftZ(mid - k)
      val r = rightZ(mid + k)
      if (ans(0) == -1 || kWindow(mid) + kWindow(l) + kWindow(r) > kWindow(ans(0)) + kWindow(ans(1)) + kWindow(ans(2))) {
        ans(0) = l
        ans(1) = mid
        ans(2) = r
      }
    }
    ans
  }
}
