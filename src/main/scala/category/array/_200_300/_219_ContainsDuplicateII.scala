/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._200_300

import scala.collection.mutable

/**
  * 219. Contains Duplicate II
  */
object _219_ContainsDuplicateII {
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    val num2Index = new mutable.HashMap[Int, Int]()
    nums.foldLeft(0) { case (idx, num) =>
      if (num2Index.contains(num)) {
        val diff = idx - num2Index(num)
        if (diff <= k) return true
      }
      num2Index.put(num, idx)
      idx + 1
    }
    false
  }
}
