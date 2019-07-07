package week27

/**
  * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
  * *
  * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
  * *
  * Note: You are not suppose to use the library's sort function for this problem.
  * *
  * Example:
  * *
  * Input: [2,0,2,1,1,0]
  * Output: [0,0,1,1,2,2]
  * Follow up:
  * *
  * A rather straight forward solution is a two-pass algorithm using counting sort.
  * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
  * Could you come up with a one-pass algorithm using only constant space?
  *
  * Created by Administrator on 2019/7/7 0007.
  */
object SortColorSolution {
  def sortColors(nums: Array[Int]): Unit = {
    if (nums != null && nums.nonEmpty && nums.length > 1) {
      var left = 0
      var right = nums.length - 1
      var mid = 0
      while (mid <= right) {
        //0
        if (nums(mid) == 0) {
          swap(nums, mid, left)
          left += 1
          mid += 1
        } else if (nums(mid) == 1) {
          mid += 1
        } else {
          swap(nums, mid, right)
          right -= 1
        }
      }
    }

  }

  def swap(nums: Array[Int], left: Int, right: Int): Unit = {
    if (left != right) {
      nums(left) = nums(left) ^ nums(right)
      nums(right) = nums(left) ^ nums(right)
      nums(left) = nums(left) ^ nums(right)
    }
  }
}
