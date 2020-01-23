package category.dfs._400_500



/**
  * 417. Pacific Atlantic Water Flow
  */
object _417_PacificAtlanticWaterFlow {
  import java.util
  def pacificAtlantic(matrix: Array[Array[Int]]): List[List[Int]] = {
    if (matrix.isEmpty || matrix(0).isEmpty) return Nil
    val M = matrix.length
    val N = matrix(0).length
    val tag = Array.ofDim[(Int, Int)](M, N)
    var ans: List[List[Int]] = Nil
    
    def dfs(i: Int, j: Int, parent: Int, visited: java.util.Set[(Int, Int)]): (Int, Int) = {
      if (i < 0 || j < 0) return (1, 0)
      if (i >= M || j >= N) return (0, 1)
//      if (tag(i)(j) != null) return tag(i)(j)
      if (matrix(i)(j) > parent) return (0, 0)
      if (visited.contains((i, j))) return (0, 0)
      visited.add((i, j))
      val (p0, a0) = dfs(i + 1, j, matrix(i)(j), visited)
      val (p1, a1) = dfs(i, j + 1, matrix(i)(j), visited)
      val (p2, a2) = dfs(i - 1, j, matrix(i)(j), visited)
      val (p3, a3) = dfs(i, j - 1, matrix(i)(j), visited)
      val (sum0, sum1) = (p0 + p1 + p2 + p3, a0 + a1 + a2 + a3)
      tag(i)(j) = (sum0, sum1)
      if (sum0 >= 1 && sum1 >= 1) {
        ans ::= List(i, j)
      }
      (sum0, sum1)
    }
    
    for (x <- 0 until M)
      for (y <- 0 until N) {
        dfs(x, y, matrix(x)(y), new util.HashSet[(Int, Int)]())
      }
    ans.distinct
  }
}