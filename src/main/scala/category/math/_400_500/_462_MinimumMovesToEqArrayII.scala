package category.math._400_500

/**
  * 462. Minimum Moves to Equal Array Elements II
  */
object _462_MinimumMovesToEqArrayII {
  def minMoves2(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    val N = nums.length
    val avg = sorted(N/2)
    nums.foldLeft(0) { case (agg, current) =>
      agg + Math.abs(current - avg)
    }
  }
}