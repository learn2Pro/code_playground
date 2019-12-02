package category.mock_exam


object MockExam_20191130_3 {
  
  import scala.collection.mutable
  
  def snakesAndLadders(board: Array[Array[Int]]): Int = {
    val N = board.length
    val dp = Array.tabulate(N * N + 1)(_ => -1)
    dp(1) = 0
    
    def coord(where: Int): (Int, Int) = {
      val row = (where - 1) / N
      val col = (where - 1) % N
      if (row % 2 == 0) {
        (N - row - 1, col)
      } else {
        (N - row - 1, N - col - 1)
      }
    }
    
    def min(l: Int, r: Int): Int = {
      if (l == -1) return r
      if (r == -1) return l
      Math.min(l, r)
    }
    
    var i = 2
    val visited = new mutable.HashSet[Int]
    while (i <= N * N) {
      val location = coord(i)
      for (step <- 1 to 6 if i - step >= 1) {
        val loc1 = coord(i - step)
        if (board(loc1._1)(loc1._2) == -1 && dp(i - step) != -1) {
          dp(i) = min(dp(i), dp(i - step) + 1)
        }
      }
      if (board(location._1)(location._2) != -1) {
        dp(board(location._1)(location._2)) = min(dp(board(location._1)(location._2)), dp(i))
        if (board(location._1)(location._2) < i && !visited.contains(board(location._1)(location._2))) {
          i = board(location._1)(location._2) - 1
        }
        visited.add(board(location._1)(location._2))
      }
      i += 1
    }
    val ans = dp(N * N)
    ans
  }
}