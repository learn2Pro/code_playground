package category.hashtable._400_500

/**
  * 463. Island Perimeter
  */
object _463_IslandPerimeter {
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty || grid(0).isEmpty) return 0
    val row = grid.length
    val col = grid(0).length
    var ans = 0
    for (i <- 0 until row)
      for (j <- 0 until col) {
        if (grid(i)(j) == 0) {
          if (i > 0 && grid(i - 1)(j) == 1) ans += 1
          if (i < row - 1 && grid(i + 1)(j) == 1) ans += 1
          if (j > 0 && grid(i)(j - 1) == 1) ans += 1
          if (j < col - 1 && grid(i)(j + 1) == 1) ans += 1
        } else {
          if (i == 0) ans += 1
          if (i == row - 1) ans += 1
          if (j == 0) ans += 1
          if (j == col - 1) ans += 1
        }
      }
    ans
  }
}