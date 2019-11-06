/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._200_300

/**
  * 283. Move Zeroes
  */
object _283_MoveZeros {
  def moveZeroes(nums: Array[Int]): Unit = {
    
    def swap(firstIndex: Int, secondIndex: Int): Unit = {
      var tmp = nums(firstIndex)
      nums(firstIndex) = nums(secondIndex)
      nums(secondIndex) = tmp
    }
    
    var lastNoneZero = 0
    for (i <- nums.indices if nums(i) != 0) {
      swap(lastNoneZero, i)
      lastNoneZero += 1
    }
  }
}
