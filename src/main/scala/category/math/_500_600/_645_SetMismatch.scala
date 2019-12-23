package category.math._500_600

/**
  * 645. Set Mismatch
  */
object _645_SetMismatch {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    val N = nums.length
    var error, missing = -1
    for (i <- 0 until N) {
      val which = Math.abs(nums(i)) - 1
      if (nums(which) < 0) error = Math.abs(nums(i))
      else nums(which) *= -1
    }
    for (i <- 0 until N if nums(i) > 0) missing = i + 1
    Array(error, missing)
  }
  
  def findErrorNumsV1(nums: Array[Int]): Array[Int] = {
    val N = nums.length
    val bucket = new Array[Int](N)
    var sum = 0
    var error = -1
    nums.foreach { num =>
      if (bucket(num - 1) == 1) error = num
      bucket(num - 1) += 1
      sum += num
    }
    Array(error, error + (1 + N) * N / 2 - sum)
  }
}