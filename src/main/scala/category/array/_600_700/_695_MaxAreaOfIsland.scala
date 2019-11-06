/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._600_700

/**
  * 695. Max Area of Island
  */
object _695_MaxAreaOfIsland {
  
  import scala.collection.mutable
  
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    
    if (grid.isEmpty || grid(0).isEmpty) return 0
    val m = grid.length
    val n = grid(0).length
    val visited = new mutable.HashSet[(Int, Int)]
    
    def loc(x: Int, y: Int): Int = {
      if (x >= 0 && x < m && y >= 0 && y < n) grid(x)(y)
      else 0
    }
    
    def dfs(x: Int, y: Int): Int = {
      if (loc(x, y) == 0 || visited.contains((x, y))) return 0
      grid(x)(y) = 0
      visited.add((x, y))
      val other = dfs(x - 1, y) + dfs(x + 1, y) + dfs(x, y - 1) + dfs(x, y + 1)
      grid(x)(y) = 1
      1 + other
    }
    
    var ans = 0
    for (i <- 0 until m)
      for (j <- 0 until n if !visited.contains((i, j)) && loc(i, j) == 1) {
        ans = Math.max(ans, dfs(i, j))
      }
    ans
  }
}
