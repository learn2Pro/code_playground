/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week37

/**
  *
  * @author derong.tdr
  * @version RemoveDupInSorted.scala, v 0.1 2019年09月13日 21:22 tang Exp $
  */
class RemoveDupInSorted {
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums == null || nums.isEmpty) return 0
    var end = nums.length
    var curr = nums(0)
    var cnt = 0
    var i = 1
    while (i < end) {
      if (nums(i) == curr) {
        cnt += 1
        if (cnt >= 2) {
          forwardOneStep(nums, i, end)
          end -= 1
          i -= 1
        }
      } else {
        curr = nums(i)
        cnt = 0
      }
      i += 1
    }
    end
  }

  /**
    * move idx-where to front one step
    */
  private def forwardOneStep(nums: Array[Int], idx: Int, where: Int) = {
    for (i <- idx until where if i + 1 < nums.length) {
      swap(nums, i, i + 1)
    }

    def swap(nums: Array[Int], i: Int, j: Int) = {
      nums(i) = nums(i) ^ nums(j)
      nums(j) = nums(i) ^ nums(j)
      nums(i) = nums(i) ^ nums(j)
    }
  }
}
