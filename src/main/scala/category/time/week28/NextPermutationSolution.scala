package category.time.week28

import java.util

/**
  * @author tang
  * @date 2019/07/14
  */
object NextPermutationSolution {
  def nextPermutation(nums: Array[Int]): Unit = {
    val len = nums.length
    val end = findNext(nums, len - 1, len)
    if (!end) {
      util.Arrays.sort(nums)
    }
  }

  private def findNext(nums: Array[Int], idx: Int, len: Int) = {
    var former = idx
    while (former - 1 >= 0 && nums(former - 1) >= nums(former)) {
      former -= 1
    }
    if (former == 0) {
      false
    } else {
      handleNext(nums, former - 1, len)
      true
    }
  }

  private def handleNext(nums: Array[Int], former: Int, len: Int) = {
    val curr = findNearest(nums, former, len)
    nums(former) = nums(former) ^ nums(curr)
    nums(curr) = nums(former) ^ nums(curr)
    nums(former) = nums(former) ^ nums(curr)
    util.Arrays.parallelSort(nums, former + 1, len)
  }

  /**
    *
    * @param nums
    * @param former
    * @return
    */
  private def findNearest(nums: Array[Int], former: Int, len: Int): Int = {
    var tmp = former + 1
    while (tmp < len && nums(tmp) > nums(former)) {
      tmp += 1
    }
    tmp - 1
  }
}
