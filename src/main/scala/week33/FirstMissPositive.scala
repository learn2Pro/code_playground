/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week33

/**
  *
  * @author derong.tdr
  * @version FirstMissPositive.scala, v 0.1 2019年08月18日 16:01 tang Exp $
  */
object FirstMissPositive {
  //  def firstMissingPositive(nums: Array[Int]): Int = {
  //    if (nums == null || nums.isEmpty) return 1
  //    var currActive = 1
  //    var activeIndex = nums.length
  //    var times = -1
  //    while (times != 0) {
  //      times = 0
  //      for (i <- 0 until nums.length if nums(i) == currActive) {
  //        currActive += 1
  //        activeIndex = i
  //        times += 1
  //      }
  //    }
  //    currActive
  //  }

  //  def firstMissingPositive(nums: Array[Int]): Int = {
  //    if (nums == null || nums.isEmpty) return 1
  //    val sorted = nums.sorted
  //    var currActive = 1
  //    for (i <- sorted.indices if sorted(i) == currActive) {
  //      currActive += 1
  //    }
  //    currActive
  //  }

  def firstMissingPositive(nums: Array[Int]): Int = {
    if (nums == null || nums.isEmpty) return 1
    //swap
    for (i <- nums.indices) {
      while (nums(i) >= 1 && nums(i) <= nums.length && nums(nums(i) - 1) != nums(i)) {
        swap(i, nums(i) - 1, nums)
      }
    }
    //check
    for (i <- nums.indices if nums(i) != i + 1) return i + 1
    return 1
  }

  private def swap(i: Int, j: Int, nums: Array[Int]) = {
    nums(i) = nums(i) ^ nums(j)
    nums(j) = nums(i) ^ nums(j)
    nums(i) = nums(i) ^ nums(j)
  }


}
