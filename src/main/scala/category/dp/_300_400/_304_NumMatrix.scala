package category.dp._300_400

/**
  * 304. Range Sum Query 2D - Immutable
  *
  * @param _matrix
  */
class _304_NumMatrix(_matrix: Array[Array[Int]]) {
  val m  = _matrix.length
  val n  = if (_matrix.isEmpty) 0 else _matrix(0).length
  val dp = Array.tabulate(m + 1, n + 1)((_, _) => 0)
  
  for (i <- 0 until m)
    for (j <- 0 until n) {
      dp(i + 1)(j + 1) = dp(i + 1)(j) + dp(i)(j + 1) - dp(i)(j) + _matrix(i)(j)
    }
  
  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
    val diagonal0 = (row1, col1)
    val diagonal1 = (row1, col2)
    val diagonal2 = (row2, col1)
    val diagonal3 = (row2, col2)
    dp(diagonal3._1 + 1)(diagonal3._2 + 1) - dp(diagonal1._1)(diagonal1._2 + 1) - dp(diagonal2._1 + 1)(diagonal2._2) + dp(diagonal0._1)(diagonal0._2)
  }
  
}
