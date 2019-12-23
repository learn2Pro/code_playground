package category.math._500_600

/**
  * 553. Optimal Division
  */
object _553_OptimalDivision {
  def optimalDivision(nums: Array[Int]): String = {
    val N = nums.length
    val dp = Array.tabulate[(List[(Int, Int)], Double)](N)(_ => null)
    var global: Double = nums(0) * nums(0)
    for (i <- 0 until N) {
      global /= nums(i)
      dp(i) = (Nil, global)
      var division: Double = nums(i)
      var multi: Double = 1
      for (j <- Range(i, -1, -1)) {
        division = nums(j) / multi
        multi *= nums(j)
        if (j - 1 >= 0 && dp(j - 1)._2 / division > dp(i)._2) {
          dp(i) = (dp(j - 1)._1 ++ (if (j < i) List((j, i)) else Nil), dp(j - 1)._2 / division)
        }
      }
    }
    val sb = new StringBuilder
    val left = dp(N - 1)._1.map(_._1).toSet
    val right = dp(N - 1)._1.map(_._2).toSet
    for (i <- 0 until N) {
      if (left.contains(i)) {
        sb.append("(")
      }
      sb.append(nums(i))
      if (i != N - 1) sb.append("/")
      if (right.contains(i)) {
        sb.append(")")
      }
    }
    sb.toString()
  }
}