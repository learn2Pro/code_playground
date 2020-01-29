/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.stack

/**
  * 496. Next Greater Element I
  */
object _496_NextGreaterElementI {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val mapping = new java.util.HashMap[Int, Int]()
    val stack = new java.util.Stack[Int]()
    nums2.foreach { num =>
      while (!stack.isEmpty && stack.peek() < num) mapping.put(stack.pop(), num)
      stack.push(num)
    }
    nums1.map {mapping.getOrDefault(_, -1)}
  }
  
  def nextGreaterElementV1(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val locations = nums2.zipWithIndex.toMap
    nums1.map { num =>
      var ans = -1
      var start = locations(num) + 1
      var earlyStop = false
      while (start < nums2.length && !earlyStop) {
        if (nums2(start) > num) {
          ans = nums2(start)
          earlyStop = true
        }
        start += 1
      }
      ans
    }
  }
}
