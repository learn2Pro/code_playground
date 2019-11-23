/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.binarysearch._300_400

/**
  * 410. Split Array Largest Sum
  */
object _410_SplitArrayLargestSum {
  def splitArray(nums: Array[Int], m: Int): Int = {
    val n = nums.length
    val dp = Array.tabulate[Int](m + 1, n + 1)((_,_) => Int.MaxValue)
    val sumArr = new Array[Int](n + 1)
    for (i <- nums.indices) {
      sumArr(i + 1) = sumArr(i) + nums(i)
    }
    dp(0)(0) = 0
    for (i <- 1 to m)
      for (j <- 1 to n)
        for (k <- i - 1 until j) {
          dp(i)(j) = Math.min(dp(i)(j), Math.max(dp(i - 1)(k), sumArr(j) - sumArr(k)))
        }
    dp(m)(n)
  }
  
  
  def splitArrayV1(nums: Array[Int], m: Int): Int = {
    var lo, hi = 0L
    for (num <- nums) {
      lo = Math.max(lo, num)
      hi += num
    }
    /*binary search*/
    while (lo < hi) {
      val mid: Long = (lo + hi) >>> 1
      var seg: Long = 1
      var sum: Long = 0
      for (num <- nums) {
        if (sum + num <= mid) sum += num
        else {
          seg += 1
          sum = num
        }
      }
      if (seg > m) lo = mid + 1
      else hi = mid
    }
    lo.toInt
  }
}
