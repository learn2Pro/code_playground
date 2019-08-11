/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week32

/**
  *
  * @author derong.tdr
  * @version SearchIntRotatedArray.scala, v 0.1 2019年08月11日 10:09 tang Exp $
  */
object SearchInRotatedArray {
  def search(nums: Array[Int], target: Int): Int = {
    if (nums == null || nums.isEmpty) return -1
    val len = nums.length
    var skip = if (nums.length > 1) {
      len / 2
    } else {
      1
    }
    var index = skip
    while (skip > 0 && nums(index) != target) {
      if (nums(index) < target) {
        index = (index + skip) % len
      }
      else {
        index = (index + len - skip) % len
      }
      skip = if (skip > 1) {
        (skip + 1) / 2
      } else 0
    }
    if (nums(index) == target) index else -1
  }
}
