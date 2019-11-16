package category.array._700_800

/**
  * 782. Transform to Chessboard
  */
object _782_Transform2Chessboard {
  def movesToChessboard(board: Array[Array[Int]]): Int = {
    val n = board.length
    var rowSum, colSum, rowDiff, colDiff = 0
    for (i <- 0 until n) {
      for (j <- 0 until n) {
        if ((board(0)(0) ^ board(i)(0) ^ board(0)(j) ^ board(i)(j)) == 1) return -1
      }
    }
    for (i <- 0 until n) {
      rowSum += board(0)(i)
      colSum += board(i)(0)
      if (board(i)(0) == i % 2) rowDiff += 1
      if (board(0)(i) == i % 2) colDiff += 1
    }
    if (n / 2 > rowSum || rowSum > (n + 1) / 2) return -1
    if (n / 2 > colSum || colSum > (n + 1) / 2) return -1
    if (n % 2 == 1) {
      if (rowDiff % 2 == 1) rowDiff = n - rowDiff
      if (colDiff % 2 == 1) colDiff = n - colDiff
    } else {
      rowDiff = Math.min(n - rowDiff, rowDiff)
      colDiff = Math.min(n - colDiff, colDiff)
    }
    (rowDiff + colDiff) / 2
  }
}