package category.hashtable._500_600

/**
  * 525. Contiguous Array
  */
object _525_ContiguousArray {
  def findMaxLength(nums: Array[Int]): Int = {
    val holder = new scala.collection.mutable.HashMap[Int, Int]
    holder.put(0, -1)
    var count, maxLen, i = 0
    nums.foreach { num =>
      count += (if (num == 1) 1 else -1)
      if (holder.contains(count)) maxLen = Math.max(maxLen, i - holder(count))
      else holder.put(count, i)
      i += 1
    }
    maxLen
  }
  
  //  def findMaxLength(nums: Array[Int]): Int = {
  //    if (nums == null || nums.length < 2) return 0
  //    val N = nums.length
  //    var max = 0
  //    val dp = Array.tabulate(N, N)((_, _) => (0, 0))
  //    for (i <- 0 until N) {
  //      var zero, one = 0
  //      if (nums(i) == 1) one += 1
  //      else if (nums(i) == 0) zero += 1
  //      dp(i)(i) = (zero, one)
  //      for (j <- i + 1 until N) {
  //        val (zero, one) = if (i == 0) {
  //          var (z, o) = dp(i)(j - 1)
  //          if (nums(i) == 1) o += 1
  //          else if (nums(i) == 0) z += 1
  //          (z, o)
  //        } else {
  //          var (z, o) = dp(i - 1)(j)
  //          if (nums(i - 1) == 1) o -= 1
  //          else if (nums(i - 1) == 0) z -= 1
  //          (z, o)
  //        }
  //        dp(i)(j) = (zero, one)
  //        if (zero == one) max = Math.max(max, j - i + 1)
  //      }
  //    }
  //    max
  //  }
}