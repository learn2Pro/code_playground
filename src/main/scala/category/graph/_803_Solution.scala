package category.graph

/**
  * 803. Bricks Falling When Hit
  *
  * [[1,0,0,0],[1,1,1,0]]
  * [[1,0]]
  * [[1,0,0,0],[1,1,1,0]]
  * [[1,1]]
  * [[1,0,0,0],[1,1,1,1]]
  * [[1,1]]
  * [[1,0,1,0],[1,1,1,1]]
  * [[1,1]]
  * [[1,0,1,0],[1,1,1,1],[1,1,1,1]]
  * [[1,1]]
  * [[1,0,0,1,0],[1,1,0,1,1]]
  * [[0,3]]
  * [[1,0,1],[1,1,1]]
  * [[0,0],[0,2],[1,1]]
  */
object _803_Solution {
  
  case class Dsu(N: Int) {
    val parents: Array[Int] = Array.tabulate(N)(_ => -1)
    
    def find(index: Int): Int = {
      if (parents(index) < 0) return index
      find(parents(index))
    }
    
    def union(x: Int, y: Int): Boolean = {
      val px = find(x)
      val py = find(y)
      if (px == py) return false
      val sx = Math.abs(parents(px))
      val sy = Math.abs(parents(py))
      if (sx >= sy) {
        parents(px) -= sy
        parents(py) = px
      } else {
        parents(py) -= sx
        parents(px) = py
      }
      true
    }
    
    def size: Int = {
      Math.abs(parents(find(N - 1))) - 1
    }
  }
  
  def hitBricks(grid: Array[Array[Int]], hits: Array[Array[Int]]): Array[Int] = {
    val M = grid.length
    val N = grid(0).length
    val sz = M * N
    val dsu = Dsu(sz + 1)
    val cloned = new Array[Array[Int]](M)
    for (i <- 0 until M) cloned(i) = grid(i).clone()
    val ans = new Array[Int](hits.length)
    /*erase the hits*/
    hits.foreach { case _@Array(i, j) =>
      cloned(i)(j) = 0
    }
    
    /*add remain edges*/
    for (i <- 0 until M)
      for (j <- 0 until N if cloned(i)(j) == 1) {
        val index = i * N + j
        if (i == 0) dsu.union(sz, index)
        if (i > 0 && cloned(i - 1)(j) == 1) dsu.union(index, (i - 1) * N + j)
        if (j > 0 && cloned(i)(j - 1) == 1) dsu.union(index, i * N + j - 1)
      }
    
    /*reverse time for add hits*/
    val position = Array((-1, 0), (1, 0), (0, -1), (0, 1))
    for (i <- Range(hits.length - 1, -1, -1)) {
      val pre = dsu.size
      hits(i) match {
        case _@Array(x, y) =>
          if (grid(x)(y) != 0) {
            val index = x * N + y
            position.foreach { case (sx, sy) =>
              val rx = x + sx
              val ry = y + sy
              val border = rx < 0 || rx >= M || ry < 0 || ry >= N
              if (!border && cloned(rx)(ry) == 1) {
                dsu.union(index, rx * N + ry)
              }
            }
            if (x == 0) dsu.union(sz, index)
            cloned(x)(y) = 1
            ans(i) = Math.max(0, dsu.size - pre - 1)
          }
      }
    }
    ans
  }
}