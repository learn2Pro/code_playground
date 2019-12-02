package category.dp._300_400

import scala.collection.mutable.ArrayBuffer


/**
  * 321. Create Maximum Number
  */
object _321_CreateMaximumNumber {
  def maxNumber(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {
    def compare(a0: ArrayBuffer[Int], a1: ArrayBuffer[Int]): Int = {
      if (a0.length > a1.length) 1
      else if (a0.length < a1.length) -1
      else {
        compare0(a0, a1)
      }
    }
    
    def compare0(a0: ArrayBuffer[Int], a1: ArrayBuffer[Int]): Int = {
      a0.zip(a1).foreach { case (l, r) =>
        if (l > r) return 1
        else if (l < r) return -1
      }
      a0.length - a1.length
    }
    
    def max(a0: ArrayBuffer[Int], a1: ArrayBuffer[Int]): ArrayBuffer[Int] = {
      if (a0 == null || a0.isEmpty) return a1
      if (a1 == null || a1.isEmpty) return a0
      val res = compare(a0, a1)
      if (res >= 0) a0
      else a1
    }
    
    def maxBuffer(nums: Array[Int], k: Int): ArrayBuffer[Int] = {
      if (k == 0) return ArrayBuffer.empty
      var drop = nums.length - k
      val res = new ArrayBuffer[Int]()
      for (num <- nums) {
        while (drop > 0 && res.nonEmpty && num > res.last) {
          res.remove(res.length - 1)
          drop -= 1
        }
        res.append(num)
      }
      res.reduceToSize(k)
      res
    }
    
    def mergeBuffer(arr0: ArrayBuffer[Int], arr1: ArrayBuffer[Int]): ArrayBuffer[Int] = {
      val res = new ArrayBuffer[Int]()
      while (arr0.nonEmpty || arr1.nonEmpty) {
        val appendix = if (arr0.isEmpty) arr1 else if (arr1.isEmpty) arr0 else if (compare0(arr0, arr1) >= 0) arr0 else arr1
        res.append(appendix(0))
        appendix.remove(0)
      }
      res
    }
    
    val n0 = nums1.length
    val n1 = nums2.length
    var ans = ArrayBuffer.empty[Int]
    for (i <- Math.max(0, k - n1) to Math.min(k, n0)) {
      ans = max(ans, mergeBuffer(maxBuffer(nums1, i), maxBuffer(nums2, k - i)))
    }
    ans.toArray
  }
  
  //  import scala.collection.mutable.ArrayBuffer
  //
  //  def maxNumberV1(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {
  //    if (nums1.isEmpty && nums2.isEmpty) return Array.empty
  //    val m = nums1.length
  //    val n = nums2.length
  //    val dp = Array.tabulate[ArrayBuffer[Int]](m + 1, n + 1, k + 1)((_, _, _) => null)
  //
  //    def compare(a0: ArrayBuffer[Int], a1: ArrayBuffer[Int]): Int = {
  //      if (a0.length > a1.length) 1
  //      else if (a0.length < a1.length) -1
  //      else {
  //        a0.zip(a1).foreach { case (l, r) =>
  //          if (l > r) return 1
  //          else if (l < r) return -1
  //        }
  //        0
  //      }
  //    }
  //
  //    def max(a0: ArrayBuffer[Int], a1: ArrayBuffer[Int]): ArrayBuffer[Int] = {
  //      if (a0 == null) return a1
  //      if (a1 == null) return a0
  //      val res = compare(a0, a1)
  //      if (res >= 0) a0
  //      else a1
  //    }
  //
  //    dp(0)(0)(0) = ArrayBuffer.empty[Int]
  //    var ans = new ArrayBuffer[Int]()
  //    /*init i*/
  //    for (i <- 1 to m) {
  //      dp(i)(0)(0) = max(dp(i - 1)(0)(0), ArrayBuffer(nums1(i - 1)))
  //    }
  //    /*init j*/
  //    for (j <- 1 to n) {
  //      dp(0)(j)(0) = max(dp(0)(j - 1)(0), ArrayBuffer(nums2(j - 1)))
  //    }
  //    for (i <- 0 to m)
  //      for (j <- 0 to n if !(i == 0 && j == 0)) {
  //        val end = Math.min(i + j, k)
  //        for (z <- 0 until end) {
  //          var bigger = dp(i)(j)(z + 1)
  //          for (k0 <- Range(i - 1, -1, -1) if dp(k0)(j)(z) != null) {
  //            bigger = max(bigger, dp(k0)(j)(z) ++ ArrayBuffer(nums1(i - 1)))
  //          }
  //          for (k1 <- Range(j - 1, -1, -1) if dp(i)(k1)(z) != null) {
  //            bigger = max(bigger, dp(i)(k1)(z) ++ ArrayBuffer(nums2(j - 1)))
  //          }
  //          dp(i)(j)(z + 1) = bigger
  //        }
  //        ans = max(ans, dp(i)(j)(k - 1))
  //      }
  //    ans.toArray
  //  }
}