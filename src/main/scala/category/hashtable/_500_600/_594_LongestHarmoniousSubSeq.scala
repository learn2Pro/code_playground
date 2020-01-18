package category.hashtable._500_600


/**
  * 594. Longest Harmonious Subsequence
  */
object _594_LongestHarmoniousSubSeq {
  def findLHS(nums: Array[Int]): Int = {
    val mapping = nums.groupBy(identity).mapValues(_.length)
    val visited = new scala.collection.mutable.HashSet[Int]
    var ans = 0
    nums.foreach { num =>
      if (!visited.contains(num)) {
        val cnt = mapping.getOrElse(num, 0)
        if (mapping.contains(num - 1)) ans = Math.max(cnt + mapping.getOrElse(num - 1, 0), ans)
        if (mapping.contains(num + 1)) ans = Math.max(cnt + mapping.getOrElse(num + 1, 0), ans)
        visited.add(num)
      }
    }
    ans
  }
}