/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._500_600

/**
  * 532. K-diff Pairs in an Array
  */
object _532_KDiffPairInArray {
  //  def findPairs(nums: Array[Int], k: Int): Int = {
  //    if (nums == null || nums.isEmpty || nums.length == 1) return 0
  //    val sorted = nums.sorted
  //    var ptr0 = 0
  //    var ptr1 = 0
  //    var ans = 0
  //
  //    def moveOneStep(ptr: Int) = {
  //      var moved = 1
  //      while (ptr + moved < sorted.length - 1 && sorted(ptr + moved) == sorted(ptr)) {
  //        moved += 1
  //      }
  //      moved
  //    }
  //
  //    while (ptr1 < sorted.length) {
  //      ptr0 = Math.max(ptr0, ptr1 + 1)
  //      while (ptr0 < sorted.length && Math.abs(sorted(ptr0) - sorted(ptr1)) < k) ptr0 += 1
  //      if (ptr0 < sorted.length && Math.abs(sorted(ptr0) - sorted(ptr1)) == k) ans += 1
  //      while (ptr1 < sorted.length - 1 && sorted(ptr1 + 1) == sorted(ptr1)) ptr1 += 1
  //      ptr1 += 1
  //    }
  //    ans
  //  }
  def findPairs(nums: Array[Int], k: Int): Int = {
    if (nums == null || nums.isEmpty || nums.length == 1 || k < 0) return 0
    var ans = 0
    val mapping = nums.groupBy(identity).map { case (first, arr) => (first, arr.length) }
    mapping.foreach { case (key, _) =>
      if (k == 0 && mapping(key) >= 2) ans += 1
      else if (k != 0 && mapping.contains(key + k)) ans += 1
    }
    ans
  }
}
