package week40

/**
  * 153. Find Minimum in Rotated Sorted Array
  */
object FindMiniInRotated {
  def findMin(nums: Array[Int]): Int = {
    for (i <- 1 until nums.length) {
      if (nums(i) < nums(i - 1)) return nums(i)
    }
    nums(0)
  }
}