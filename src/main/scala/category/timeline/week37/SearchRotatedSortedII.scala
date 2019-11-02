/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week37

/**
  *
  * @author derong.tdr
  * @version SearchRotatedSortedII.scala, v 0.1 2019年09月13日 21:39 tang Exp $
  */
class SearchRotatedSortedII {
  def search(nums: Array[Int], target: Int): Boolean = {
    if (nums == null || nums.isEmpty) return false
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
    if (nums(index) == target) true else false
  }

}
