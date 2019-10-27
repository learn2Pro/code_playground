/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week32

/**
  *
  * @author derong.tdr
  * @version SearchIntRotatedArray.scala, v 0.1 2019年08月11日 10:09 tang Exp $
  */
object SearchInRotatedArray {
  def search(nums: Array[Int], target: Int): Int = {
    if (nums == null || nums.isEmpty) return -1
    val len = nums.length
    var skip = len / 2
    var index = 0
    var stopCounter = 0
    while (stopCounter <= 2 && nums(index) != target) {
      if (nums(index) < target) {
        index = (index + skip) % len
        while (index < len - 1 && nums(index) < target) index += 1
      } else {
        index = (index + len - skip) % len
        while (index > 0 && nums(index) > target) index -= 1
      }
      skip = (skip + 1) / 2
      if (skip <= 1) stopCounter += 1
    }
    if (nums(index) == target) index else -1
  }
}
