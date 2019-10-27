package category.time.week28

import java.util

/**
  * @author tang
  * @date 2019/07/13
  */
object ThreeSumClosetSolution {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    util.Arrays.parallelSort(nums)
    findMinimal(nums, target)
  }

  private def findMinimal(nums: Array[Int], target: Int): Int = {
    val len = nums.length
    var idx = 0
    var ans = 0
    var dis = Int.MaxValue
    while (idx < len - 1) {
      var left = idx + 1
      var right = len - 1
      val curr = nums(idx)
      while (dis > 0 && left < right) {
        if (Math.abs(nums(left) + curr + nums(right) - target) < dis) {
          dis = Math.abs(nums(left) + curr + nums(right) - target)
          ans = nums(left) + curr + nums(right)
        }
        //move left
        if (Math.abs(nums(left + 1) + curr + nums(right) - target) < Math.abs(nums(left) + curr + nums(right - 1) - target)) {
          left += 1
        } else {
          right -= 1
        }
      }
      idx += 1
    }
    ans
  }
}
