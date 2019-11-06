/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._200_300

/**
  * 209. Minimum Size Subarray Sum
  */
object _209_MiniSubArraySum {
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    /*inclusive*/
    case class Win(var left: Int, var right: Int) {
      var initialSum: Int = nums.slice(left, right + 1).sum
      
      def sum: Int = {
        initialSum
      }
      
      def size: Int = {
        right + 1 - left
      }
      
      def advanceRight: Unit = {
        if (right < nums.length) {
          right += 1
          if (right < nums.length) initialSum += nums(right)
        }
      }
      
      def advanceLeft: Unit = {
        if (left <= right) {
          left += 1
          initialSum -= nums(left - 1)
        }
      }
      
      def reach: Boolean = {
        left >= nums.length || right >= nums.length
      }
    }
    if (nums == null || nums.isEmpty) return 0
    val win = Win(0, 0)
    var ans = nums.length + 1
    while (!win.reach) {
      if (win.sum < s) win.advanceRight
      else {
        ans = Math.min(ans, win.size)
        win.advanceLeft
      }
    }
    if (ans == nums.length + 1) 0 else ans
  }
}
