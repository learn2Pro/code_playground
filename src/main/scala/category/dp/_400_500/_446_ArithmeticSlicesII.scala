package category.dp._400_500


/**
  * 446. Arithmetic Slices II - Subsequence
  */
object _446_ArithmeticSlicesII {
  
  import java.util
  
  def numberOfArithmeticSlices(A: Array[Int]): Int = {
    val n = A.length
    if (n < 3) return 0
    val dp = Array.tabulate[java.util.HashMap[Long, Int]](n)(_ => new util.HashMap[Long, Int]())
    var ans = 0
    for (i <- 0 until n) {
      for (k <- 0 until i) {
        val diff: Long = A(i).toLong - A(k)
        val increment = dp(k).getOrDefault(diff, 0)
        val origin = dp(i).getOrDefault(diff, 0)
        dp(i).put(diff, origin + increment + 1)
        ans += increment
      }
    }
    ans
  }
  
}