/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._400_500

/**
  * 442. Find All Duplicates in an Array
  */
object _442_DuplicateNumberFinderII {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    var ans: List[Int] = Nil
    for (i <- nums.indices) {
      val idx = Math.abs(nums(i))
      if (nums(idx - 1) < 0) ans ::= idx
      nums(idx - 1) *= -1
    }
    ans
  }
  
  //  def findDuplicates(nums: Array[Int]): List[Int] = {
  //    if (nums == null || nums.isEmpty || nums.length == 1) return Nil
  //    nums.groupBy(identity).filter(_._2.length == 2).keys.toList
  //  }
}
