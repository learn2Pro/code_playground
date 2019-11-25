package category.dp._500_600

/**
  * 523. Continuous Subarray Sum
  */
object _523_ContinuousSubArraySum {
  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
    val map = scala.collection.mutable.Map.empty[Int, Int]
    map += (0 -> -1)
    var sum = 0
    for (i <- nums.indices) {
      sum += nums(i)
      if (k != 0) sum %= k
      map.get(sum) match {
        case Some(prev) =>
          if (i - prev > 1) return true
        case None => map += (sum -> i)
      }
    }
    false
  }
  
  def checkSubarraySumV1(nums: Array[Int], k: Int): Boolean = {
    if (nums.length < 2) return false
    var last: Long = nums(0)
    for (i <- 1 until nums.length) {
      last += nums(i)
      var partialSum = last
      for (j <- 0 until i) {
        partialSum -= (if (j == 0) 0 else nums(j - 1))
        if (partialSum != 0 && k != 0 && partialSum % k == 0) return true
        if (partialSum == 0) return true
      }
    }
    false
  }
}