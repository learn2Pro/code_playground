/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._400_500

/**
  * 448. Find All Numbers Disappeared in an Array
  */
object _448_DisappearNumberFinder {
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    var ans: List[Int] = Nil
    for (i <- nums.indices) {
      val idx = Math.abs(nums(i))
      if (nums(idx - 1) > 0) nums(idx - 1) *= -1
    }
    for (i <- nums.indices if nums(i) > 0) {
      ans ::= (i + 1)
    }
    ans
  }
}
