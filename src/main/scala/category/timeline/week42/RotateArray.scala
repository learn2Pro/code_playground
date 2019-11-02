package category.timeline.week42

/**
  * 189. Rotate Array
  */
object RotateArray {
  def rotate(nums: Array[Int], k: Int): Unit = {
    if (nums.length == 1) return
    val reverse = k % nums.length
    val tail = nums.slice(nums.length - reverse, nums.length)
    Array.copy(nums, 0, nums, reverse, nums.length - reverse)
    Array.copy(tail, 0, nums, 0, reverse)
  }
  
}