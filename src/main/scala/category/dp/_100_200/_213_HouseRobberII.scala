package category.dp._100_200

/**
  * 213. House Robber II
  */
object _213_HouseRobberII {
  def rob(nums: Array[Int]): Int = {
    if (nums.length == 1) return nums(0)
    var state0, state1 = 0
    for (i <- 0 until nums.length - 1) {
      val tmp = Math.max(state0 + nums(i), state1)
      state0 = state1
      state1 = tmp
    }
    val ans = state1
    state0 = 0
    state1 = 0
    for (i <- 1 until nums.length) {
      val tmp = Math.max(state0 + nums(i), state1)
      state0 = state1
      state1 = tmp
    }
    Math.max(ans, state1)
  }
}