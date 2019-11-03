package category.array

/**
  * 485. Max Consecutive Ones
  */
object MaxConsecOnes {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    var ans = 0
    val (lastSum, _) = nums.foldLeft((0, 1)) { case ((sum, expect), num) =>
      if (sum + num == expect) {
        (expect, expect + 1)
      } else {
        ans = Math.max(ans, sum)
        (0, 1)
      }
    }
    Math.max(ans, lastSum)
  }
}