/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._400_500

/**
  * 414. Third Maximum Number
  */
object _414_ThirdMaximun {
  def thirdMax(nums: Array[Int]): Int = {
    var first = Long.MinValue
    var second = Long.MinValue
    var third = Long.MinValue
    
    def update(input: Int): Unit = {
      /*input > first > second > third*/
      if (input > first) {
        third = second
        second = first
        first = input
      }
      /*first > input > second > third*/
      else if (first > input && input > second) {
        third = second
        second = input
      }
           /*first > second > input > third*/
      else if (input < second && input > third) {
        third = input
      }
    }
    
    for (i <- nums.indices) {
      update(nums(i))
    }
    if (third == Long.MinValue) first.toInt else third.toInt
  }
}
