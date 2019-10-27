package category.bitmanipulation

/**
  * 268. Missing Number
  */
object MissingNumber {
  //  def missingNumber(nums: Array[Int]): Int = {
  //    val len = nums.length
  //    len * (len + 1) / 2 - nums.sum
  //  }
  def missingNumber(nums: Array[Int]): Int = {
    val missing = nums.length
    var idx = 0
    nums.foldLeft(missing) { case (last, curr) =>
      val res = last ^ idx ^ curr
      idx += 1
      res
    }
  }
}