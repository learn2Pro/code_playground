/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._500_600

/**
  * 565. Array Nesting
  */
object _565_ArrayNesting {
  def arrayNesting(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val visited = new java.util.HashSet[Int]
    var ans = 0
    for (i <- nums.indices if !visited.contains(i)) {
      var idx = i
      var innerSum = 0
      while (!visited.contains(idx)) {
        innerSum += 1
        visited.add(idx)
        idx = nums(idx)
      }
      ans = Math.max(ans, innerSum)
    }
    ans
  }
}
