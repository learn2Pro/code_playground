package category.time.week28

import java.util

import scala.collection.mutable.ArrayBuffer

/**
  * @author tang
  * @date 2019/07/13
  */
object FourSumSolution {
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    if (nums == null || nums.length < 4) {
      List.empty[List[Int]]
    } else if (nums.distinct.length == 1) {
      if (nums(0) * 4 == target) {
        List(List(nums(0), nums(0), nums(0), nums(0)))
      } else {
        List.empty[List[Int]]
      }
    } else {
      util.Arrays.parallelSort(nums)
      val len = nums.length
      (for (idx <- Range(len - 1, 2, -1)) yield {
        val threeSumAns = threeSum(nums, target - nums(idx), idx)
        threeSumAns.foreach(r => r.append(nums(idx)))
        threeSumAns
      }).flatten.distinct.map(_.toList).toList
    }
  }

  /**
    * three sum
    *
    * @param sorted
    * @param target
    * @param size
    */
  def threeSum(sorted: Array[Int], target: Int, size: Int) = {
    (for (idx <- Range(size - 1, 1, -1)) yield {
      val twoSumAns = twoSum(sorted, target - sorted(idx), idx)
      twoSumAns.foreach(r => r.append(sorted(idx)))
      twoSumAns
    }).flatten
  }

  /**
    * two sum
    *
    * @param sorted
    * @param target
    * @param size
    * @return
    */
  def twoSum(sorted: Array[Int], target: Int, size: Int) = {
    var left = 0
    var right = size - 1
    var ans = new ArrayBuffer[ArrayBuffer[Int]]()
    while (left < right) {
      if (sorted(left) + sorted(right) == target) {
        ans += ArrayBuffer(sorted(left), sorted(right))
        left += 1
        right -= 1
      } else if (sorted(left) + sorted(right) < target) {
        while (left < right && sorted(left + 1) == sorted(left)) {
          left += 1
        }
        left += 1
      } else {
        while (left < right && sorted(right - 1) == sorted(right)) {
          right -= 1
        }
        right -= 1
      }
    }
    ans
  }
}
