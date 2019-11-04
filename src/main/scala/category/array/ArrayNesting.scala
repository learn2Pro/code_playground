package category.array

/**
  * 565. Array Nesting
  */
object ArrayNesting {
  def arrayNesting(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val visited = new java.util.HashSet[Int]
    var ans = 0
    for (i <- nums.indices if !visited.contains(i)) {
      var idx = i
      var innerSum = 0
      while (!visited.contains(idx)) {
        innerSum += 1
        visited.add(idx)
        idx = nums(idx)
      }
      ans = Math.max(ans, innerSum)
    }
    ans
  }
}