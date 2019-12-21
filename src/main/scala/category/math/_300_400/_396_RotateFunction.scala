package category.math._300_400

/**
  * 396. Rotate Function
  */
object _396_RotateFunction {
  def maxRotateFunction(A: Array[Int]): Int = {
    val N = A.length
    val sum: Long = A.map(_.toLong).sum
    var start: Long = 0
    for (idx <- 0 until N) {
      start += A(idx) * idx
    }
    var ans: Long = start
    for (i <- 1 until N) {
      val tmp = start + sum - N * A(N - i)
      ans = Math.max(ans, tmp)
      start = tmp
    }
    ans.toInt
  }
}