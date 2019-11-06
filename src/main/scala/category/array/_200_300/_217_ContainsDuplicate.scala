/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._200_300

/**
  * 217. Contains Duplicate
  */
object _217_ContainsDuplicate {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    nums.toSet.size == nums.length
  }
}
