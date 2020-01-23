package category.dfs._300_400

/**
  * 329. Longest Increasing Path in a Matrix
  */
object _329_LongestIncreasingPathInAMatrix {
  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    if (matrix.isEmpty || matrix(0).isEmpty) return 0
    val M = matrix.length
    val N = matrix(0).length
    
    val cache = Array.ofDim[Int](M, N)
    
    def dfs(x: Int, y: Int, parent: Int): Int = {
      if (x < 0 || x >= M || y < 0 || y >= N || matrix(x)(y) <= parent) return 0
      if (cache(x)(y) != 0) return cache(x)(y)
      val ans0 = 1 + dfs(x + 1, y, matrix(x)(y))
      val ans1 = 1 + dfs(x - 1, y, matrix(x)(y))
        val ans2 = 1 + dfs(x, y + 1, matrix(x)(y))
      val ans3 = 1 + dfs(x, y - 1, matrix(x)(y))
      val ans = Math.max(Math.max(ans0, ans1), Math.max(ans2, ans3))
      cache(x)(y) = ans
      ans
    }
    
    var ans = 0
    for (i <- 0 until M)
      for (j <- 0 until N) {
        ans = Math.max(ans, dfs(i, j, Int.MinValue))
      }
    ans
  }
}