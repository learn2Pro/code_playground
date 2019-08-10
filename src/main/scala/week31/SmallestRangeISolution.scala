package week31

/**
  * @author tang
  * @date 2019/08/03
  */
object SmallestRangeISolution {
  def smallestRangeI(A: Array[Int], K: Int): Int = {
    var min = A(0)
    var max = A(0)
    for (i <- 1 until A.length) {
      if (A(i) > max) max = A(i)
      if (A(i) < min) min = A(i)
    }
    val gap = max - min - 2 * K
    if (gap > 0) gap else 0
  }
}
