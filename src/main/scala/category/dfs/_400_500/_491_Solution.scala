package category.dfs._400_500

/**
  * 491. Increasing Subsequences
  */
object _491_Solution {
  def findSubsequences(nums: Array[Int]): List[List[Int]] = {
    if (nums == null || nums.isEmpty) return Nil
    val N = nums.length
    var ans: List[List[Int]] = Nil
    val dp = Array.tabulate[List[List[Int]]](N)(_ => Nil)
    for (i <- 0 until N) {
      dp(i) = List(List(nums(i)))
      for (j <- 0 until i if nums(i) >= nums(j)) {
        dp(i) ++= dp(j).map { lst =>
          val curr = lst ++ List(nums(i))
          ans ::= curr
          curr
        }
      }
    }
    ans.distinct
  }
  
  //  def findSubsequences(nums: Array[Int]): List[List[Int]] = {
  //    if (nums == null || nums.isEmpty) return Nil
  //    var ans: List[List[Int]] = Nil
  //    val N = nums.length
  //
  //    def choose(previous: List[Int], idx: Int): Unit = {
  //      if (idx >= N) return
  //      for (i <- idx until N if nums(idx) >= previous.last) {
  //        val curr = previous ++ List(nums(i))
  //        ans ::= curr
  //        choose(curr, i + 1)
  //      }
  //    }
  //
  //    for (i <- 0 until N) {
  //      choose(List(nums(i)), i + 1)
  //    }
  //    ans.distinct
  //  }
}