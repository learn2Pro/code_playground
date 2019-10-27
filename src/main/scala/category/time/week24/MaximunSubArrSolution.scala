package category.time.week24

/**
  * @author tang
  * @date 2019/06/30
  */
object MaximunSubArrSolution {

  def maxSubArray(nums: Array[Int]): Int = {
    var curMax = nums(0)
    var win = nums(0)
    for (i <- 1 until nums.length) {
      if (win + nums(i) > nums(i)) {
        win += nums(i)
      } else {
        win = nums(i)
      }
      if (win > curMax) {
        curMax = win
      }
    }
    curMax
  }

}
