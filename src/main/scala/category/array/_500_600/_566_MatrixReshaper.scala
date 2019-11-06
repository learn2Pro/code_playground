/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._500_600

/**
  * 566. Reshape the Matrix
  */
object _566_MatrixReshaper {
  def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    val m = nums.length
    val n = nums(0).length
    if (r * c != m * n) return nums
    
    def locate(idx: Int): Int = {
      nums(idx / n)(idx % n)
    }
    
    (for (i <- 0 until r) yield {
      (for (j <- 0 until c) yield {
        locate(i * c + j)
      }).toArray
    }).toArray
  }
}
