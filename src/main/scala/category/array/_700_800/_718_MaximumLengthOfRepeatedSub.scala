package category.array._700_800

/**
  * 718. Maximum Length of Repeated Subarray
  */
object _718_MaximumLengthOfRepeatedSub {
  def findLength(A: Array[Int], B: Array[Int]): Int = {
    val dp = Array.fill(A.length + 1, B.length + 1)(0)
    val m = A.length
    val n = B.length
    var ans = 0
    for (i <- 0 until m)
      for (j <- 0 until n if A(i) == A(j)) {
        dp(i + 1)(j + 1) = dp(i)(j) + 1
        ans = Math.max(ans, dp(i + 1)(j + 1))
      }
    ans
  }
}