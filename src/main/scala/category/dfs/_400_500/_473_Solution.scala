package category.dfs._400_500

/**
  * 473. Matchsticks to Square
  */
object _473_Solution {
  def makesquare(nums: Array[Int]): Boolean = {
    if (nums.isEmpty) return false
    val sum = nums.sum
    if (sum % 4 != 0) return false
    val side = sum / 4
    val used = new java.util.HashSet[Int]
    val N = nums.length
    
    def backTrack(previous: Int, total: Int, last: Int): Boolean = {
      if (previous == 0 && total == 0) return true
      if (previous > side) return false
      if (previous == side) return backTrack(0, total - 1, 0)
      var i = last
      var anyOne = false
      while (i < N && !anyOne) {
        if (!used.contains(i) && previous + nums(i) <= side) {
          used.add(i)
          anyOne = backTrack(previous + nums(i), total, i + 1)
          if (!anyOne) used.remove(i)
        }
        i += 1
      }
      anyOne
    }
    
    backTrack(0, 4, 0)
  }
}