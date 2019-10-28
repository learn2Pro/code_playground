package category.bitmanipulation

/**
  * 477. Total Hamming Distance
  */
object TotalHammingDistance {
  //  def totalHammingDistance(nums: Array[Int]): Int = {
  //    def distance(num: Int, other: Int): Int = {
  //      java.lang.Integer.bitCount(num ^ other)
  //    }
  //
  //    if (nums.length <= 1) return 0
  //    val len = nums.length
  //    var res = 0
  //    for (i <- 0 until len)
  //      for (j <- i + 1 until len) {
  //        res += distance(nums(i), nums(j))
  //      }
  //    res
  //  }
  
  def totalHammingDistance(nums: Array[Int]): Int = {
    def distanceInOneBit(idx: Int): Int = {
      var count = 0
      for (i <- nums.indices if (nums(i) & (1 << idx)) == (1 << idx)) {
        count += 1
      }
      count * (nums.length - count)
    }
    
    (for (i <- 0 until 32) yield {
      distanceInOneBit(i)
    }).sum
  }
}