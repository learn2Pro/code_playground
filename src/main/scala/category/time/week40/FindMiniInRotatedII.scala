package category.time.week40

/**
  * 153. Find Minimum in Rotated Sorted Array
  */
object FindMiniInRotatedII {
  def findMin(nums: Array[Int]): Int = {
    for (i <- 1 until nums.length) {
      if (nums(i) < nums(i - 1)) return nums(i)
    }
    nums(0)
  }
}