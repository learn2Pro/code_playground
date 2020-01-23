package category.dfs._200_300


/**
  * 200. Number of Islands
  */
object _200_NumberOfIslands {
  
  def numIslands(grid: Array[Array[Char]]): Int = {
    val row = grid.length
    if (row == 0) return 0
    val col = grid(0).length
    if (col == 0) return 0
    
    
    def get(x: Int, y: Int): Int = {
      if (x >= row || x < 0 || y >= col || y < 0) '0'
      else grid(x)(y)
    }
    
    
    def backTrack(x: Int, y: Int): Unit = {
      if (x >= row || x < 0 || y >= col || y < 0 || grid(x)(y) == '0') return
      grid(x)(y) = '0'
      backTrack(x + 1, y)
      backTrack(x - 1, y)
      backTrack(x, y - 1)
      backTrack(x, y + 1)
    }
    
    var ans = 0
    for (i <- 0 until row)
      for (j <- 0 until col) {
        if (grid(i)(j) == '1') {
          backTrack(i, j)
          ans += 1
        }
      }
    ans
  }
}