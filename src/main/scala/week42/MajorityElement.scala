package week42

/**
  * 169. Majority Element
  */
object MajorityElement {
  def majorityElement(nums: Array[Int]): Int = {
    var candidate = 0
    var count = 0
    for (i <- nums.indices) {
      if (count == 0) candidate = nums(i)
      if (candidate == nums(i)) count += 1 else count -= 1
    }
    candidate
  }
}