package category.array._700_800

/**
  * 746. Min Cost Climbing Stairs
  */
object _746_MinCostClimbingStairs {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    var step0, step1 = 0
    for (i <- 2 until cost.length + 1) {
      val tmp = Math.min(step0 + cost(i - 2), step1 + cost(i - 1))
      step0 = step1
      step1 = tmp
    }
    step1
  }
}