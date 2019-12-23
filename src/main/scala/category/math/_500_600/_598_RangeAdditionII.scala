package category.math._500_600

/**
  * 598. Range Addition II
  */
object _598_RangeAdditionII {
  def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
    if (ops.isEmpty) return m * n
    
    val (x, y) = ops.foldLeft((m, n)) { case ((l0, l1), arr) =>
      (Math.min(l0, arr(0)), Math.min(l1, arr(1)))
    }
    x * y
  }
}