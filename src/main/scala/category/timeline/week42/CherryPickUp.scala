package category.timeline.week42

/**
  * 741. Cherry Pickup
  */
object CherryPickUp {
  
  def cherryPickup(grid: Array[Array[Int]]): Int = {
    val N = grid.length
    val memo = Array.tabulate[Int](N, N, N) { (_, _, _) => Int.MinValue }
    
    def dp(r1: Int, c1: Int, c2: Int): Int = {
      val r2 = r1 + c1 - c2
      if (N == r1 || N == r2 || N == c1 || N == c2 || grid(r1)(c1) == -1 || grid(r2)(c2) == -1) -999999
      else if (r1 == N - 1 && c1 == N - 1) grid(r1)(c1)
      else if (memo(r1)(c1)(c2) != Int.MinValue) memo(r1)(c1)(c2)
      else {
        var ans = grid(r1)(c1)
        if (c1 != c2) ans += grid(r2)(c2)
        ans += Math.max(Math.max(dp(r1, c1 + 1, c2 + 1), dp(r1 + 1, c1, c2 + 1)), Math.max(dp(r1, c1 + 1, c2), dp(r1 + 1, c1, c2)))
        memo(r1)(c1)(c2) = ans
        ans
      }
    }
    
    
    Math.max(0, dp(0, 0, 0))
  }
  
  
  //  def cherryPickup(grid: Array[Array[Int]]): Int = {
  //    if (grid == null || grid.isEmpty || grid(0).isEmpty) return 0
  //    val paths = walk(grid)
  //    if (paths == Nil) return 0
  //    paths.map { path =>
  //      setZero(path, grid)
  //      val ans = pickup(path.head.sum, grid)
  //      recover(path, grid)
  //      ans
  //    }.max
  //  }
  //
  //  private def walk(grid: Array[Array[Int]]) = {
  //    val row = grid.length
  //    val col = grid(0).length
  //    val dp = Array.tabulate[List[List[Coordinate]]](row, col)((_, _) => Nil)
  //    dp(0)(0) = List(List(Coordinate(0, 0, grid(0)(0), grid(0)(0))))
  //    /* first row initial */
  //    var block = false
  //    for (j <- 1 until col if !block) {
  //      if (grid(0)(j) == -1) {
  //        block = true
  //      } else {
  //        dp(0)(j) = List(Coordinate(0, j, dp(0)(j - 1).head.head.sum + grid(0)(j), grid(0)(j)) :: dp(0)(j - 1).head)
  //      }
  //    }
  //    block = false
  //    for (i <- 1 until row if !block) {
  //      if (grid(i)(0) == -1) {
  //        block = true
  //      } else {
  //        dp(i)(0) = List(Coordinate(i, 0, dp(i - 1)(0).head.head.sum + grid(i)(0), grid(i)(0)) :: dp(i - 1)(0).head)
  //      }
  //    }
  //    for (i <- 1 until row)
  //      for (j <- 1 until col if grid(i)(j) != -1) {
  //        if ((grid(i - 1)(j) == -1 && grid(i)(j - 1) == -1) || (dp(i)(j - 1) == Nil && dp(i - 1)(j) == Nil)) {
  //          /*do nothing*/
  //        }
  //        /* upper blocked && upper < left */
  //        else if (grid(i - 1)(j) == -1 || dp(i - 1)(j) == Nil) {
  //          dp(i)(j) = dp(i)(j - 1).map { path =>
  //            Coordinate(i, j, path.head.sum + grid(i)(j), grid(i)(j)) :: path
  //          }
  //        } else if (grid(i)(j - 1) == -1 || dp(i)(j - 1) == Nil) {
  //          dp(i)(j) = dp(i - 1)(j).map { path =>
  //            Coordinate(i, j, path.head.sum + grid(i)(j), grid(i)(j)) :: path
  //          }
  //        }
  //        else {
  //          dp(i)(j) = dp(i - 1)(j).map { path =>
  //            Coordinate(i, j, path.head.sum + grid(i)(j), grid(i)(j)) :: path
  //          } ++ dp(i)(j - 1).map { path =>
  //            Coordinate(i, j, path.head.sum + grid(i)(j), grid(i)(j)) :: path
  //          }
  //        }
  //      }
  //    dp(row - 1)(col - 1)
  //  }
  //
  //  private def setZero(coords: List[Coordinate], grid: Array[Array[Int]]) = {
  //    coords.foreach { coord =>
  //      grid(coord.x)(coord.y) = 0
  //    }
  //  }
  //
  //  private def recover(coords: List[Coordinate], grid: Array[Array[Int]]) = {
  //    coords.foreach { coord =>
  //      grid(coord.x)(coord.y) = coord.cherry
  //    }
  //  }
  //
  //  private def pickup(collect: Int, grid: Array[Array[Int]]) = {
  //    val row = grid.length
  //    val col = grid(0).length
  //    val dp: Array[Array[Int]] = Array.tabulate[Int](row, col)((_, _) => -1)
  //    dp(row - 1)(col - 1) = collect
  //    /* last row initial */
  //    var block = false
  //    for (j <- Range(col - 2, -1, -1) if !block) {
  //      if (grid(row - 1)(j) == -1) {
  //        block = true
  //      } else {
  //        dp(row - 1)(j) = dp(row - 1)(j + 1) + grid(row - 1)(j)
  //      }
  //    }
  //    block = false
  //    /* last column initial */
  //    for (i <- Range(row - 2, -1, -1) if !block) {
  //      if (grid(i)(col - 1) == -1) {
  //        block = true
  //      } else {
  //        dp(i)(col - 1) = dp(i + 1)(col - 1) + grid(i)(col - 1)
  //      }
  //    }
  //    for (i <- Range(row - 2, -1, -1))
  //      for (j <- Range(col - 2, -1, -1) if grid(i)(j) != -1) {
  //        dp(i)(j) = Math.max(dp(i + 1)(j) + grid(i)(j), dp(i)(j + 1) + grid(i)(j))
  //      }
  //    dp(0)(0)
  //  }
  //
  //  case class Coordinate(x: Int, y: Int, sum: Int, cherry: Int)
  //
}