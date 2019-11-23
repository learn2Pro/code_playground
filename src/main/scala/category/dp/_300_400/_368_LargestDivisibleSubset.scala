package category.dp._300_400

/**
  * 368. Largest Divisible Subset
  */
object _368_LargestDivisibleSubset {
  def largestDivisibleSubset(nums: Array[Int]): List[Int] = {
    if (nums == null || nums.isEmpty) return Nil
    val sorted = nums.sorted
    var ans: List[Int] = Nil
    val dp = Array.tabulate[List[Int]](sorted.length) { _ => Nil }
    for (i <- Range(sorted.length - 1, -1, -1)) {
      for (j <- i until sorted.length if sorted(j) % sorted(i) == 0 && dp(j).length + 1 > dp(i).length) {
        dp(i) = sorted(i) :: dp(j)
      }
      if (dp(i).length > ans.length) ans = dp(i)
    }
    ans
  }
}