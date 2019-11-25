package category.dp._600_700

/**
  * 688. Knight Probability in Chessboard
  */
object _688_KnightProbInChessBoard {
  def knightProbability(N: Int, K: Int, r: Int, c: Int): Double = {
    val m = N
    val n = N
    val moves = K
    val dp = Array.tabulate(m, n, 2)((_, _, _) => 0.0d)
    
    def isBoundary(i: Int, j: Int): Boolean = {
      i < 0 || i >= m || j < 0 || j >= n
    }
    
    if (K == 0) return 1.0
    var prob: Double = 0.0d
    
    def move(iter: Int, i: Int, j: Int, originX: Int, originY: Int) = {
      val prev = iter % 2
      val loc = (iter + 1) % 2
      if (!isBoundary(i, j)) {
        dp(i)(j)(loc) += dp(originX)(originY)(prev) * 0.125
        if (moves - 1 == iter) prob += dp(originX)(originY)(prev) * 0.125
      }
    }
    
    dp(r)(c)(0) = 1.0
    for (iter <- 0 until moves)
      for (i <- 0 until m)
        for (j <- 0 until n) {
          val prev = iter % 2
          /*i-2,j-1*/
          move(iter, i - 2, j - 1, i, j)
          /*i-2,j+1*/
          move(iter, i - 2, j + 1, i, j)
          /*i-1,j-2*/
          move(iter, i - 1, j - 2, i, j)
          /*i-1,j+2*/
          move(iter, i - 1, j + 2, i, j)
          /*i+1,j-2*/
          move(iter, i + 1, j - 2, i, j)
          /*i+1,j+2*/
          move(iter, i + 1, j + 2, i, j)
          /*i+2,j-1*/
          move(iter, i + 2, j - 1, i, j)
          /*i+2,j+1*/
          move(iter, i + 2, j + 1, i, j)
          dp(i)(j)(prev) = 0.0
        }
    prob
  }
  
}