package category.dp._100_200

/**
  * 198. House Robber
  */
object _198_HouseRobber {
  def rob(nums: Array[Int]): Int = {
    var state0, state1 = 0
    for (i <- nums.indices) {
      val tmp = Math.max(state0 + nums(i), state1)
      state0 = state1
      state1 = tmp
    }
    state1
  }
}