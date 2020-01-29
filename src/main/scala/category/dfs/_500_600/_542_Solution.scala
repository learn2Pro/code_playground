package category.dfs._500_600

/**
  * 542. 01 Matrix
  */
object _542_Solution {
  def updateMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val M = matrix.length
    val N = matrix(0).length
    val MAX = M + N
    val dp = Array.tabulate(M, N)((_, _) => MAX)
    val position = Array((-1, 0), (1, 0), (0, -1), (0, 1))
    /*first turn*/
    for (x <- 0 until M)
      for (y <- 0 until N) {
        if (matrix(x)(y) == 0) dp(x)(y) = 0
        else {
          dp(x)(y) = position.map { case (sift0, sift1) =>
            val s0 = x + sift0
            val s1 = y + sift1
            val boarder = s0 < 0 || s0 >= M || s1 < 0 || s1 >= N
            if (boarder) MAX else dp(s0)(s1) + 1
          }.min
        }
      }
    /*second turn*/
    for (x <- Range(M - 1, -1, -1))
      for (y <- Range(N - 1, -1, -1)) {
        if (matrix(x)(y) == 0) dp(x)(y) = 0
        else {
          dp(x)(y) = position.map { case (sift0, sift1) =>
            val s0 = x + sift0
            val s1 = y + sift1
            val boarder = s0 < 0 || s0 >= M || s1 < 0 || s1 >= N
            if (boarder) MAX else dp(s0)(s1) + 1
          }.min
        }
      }
    dp
  }
  
  //  def updateMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
  //    val M = matrix.length
  //    val N = matrix(0).length
  //    val MAX = M + N
  //    /*dfs*/
  //
  //    val position = Array((-1, 0), (1, 0), (0, -1), (0, 1))
  //    val stack = new java.util.Stack[(Int, Int)]
  //    val visited = new java.util.HashSet[(Int, Int)]
  //    val history = new java.util.HashMap[(Int, Int), Int]
  //
  //    def update(x: Int, y: Int): Int = {
  //      val ans = if (matrix(x)(y) == 0) 0 else {
  //        position.map { case (shift0, shift1) =>
  //          history.getOrDefault((x + shift0, y + shift1), MAX) + 1
  //        }.min
  //      }
  //      matrix(x)(y) = ans
  //      history.put((x, y), ans)
  //      matrix(x)(y)
  //    }
  //
  //    stack.push((0, 0))
  //    while (!stack.isEmpty) {
  //      val (x, y) = stack.peek()
  //      if (!visited.contains((x, y))) {
  //        visited.add((x, y))
  //        update(x, y)
  //        position.foreach { case (shift0, shift1) =>
  //          val s0 = x + shift0
  //          val s1 = y + shift1
  //          val boarder = s0 < 0 || s0 >= M || s1 < 0 || s1 >= N
  //          if (!visited.contains((s0, s1)) && !boarder && !history.containsKey((s0, s1))) {
  //            stack.push((s0, s1))
  //          }
  //        }
  //      } else {
  //        update(x, y)
  //        stack.pop()
  //      }
  //    }
  //    matrix
  //  }
  
}