package category.greedy

/**
  * 765. Couples Holding Hands
  */
object _765_Solution {
  
  case class DSU(size: Int) {
    val parents = Array.tabulate(size)(_ => -1)
    var count   = 0
    
    def find(i: Int): Int = {
      if (parents(i) < 0) return i
      find(parents(i))
    }
    
    def union(i: Int, j: Int): Boolean = {
      val pi = find(i)
      val pj = find(j)
      if (pi == pj) return false
      val si = Math.abs(parents(pi))
      val sj = Math.abs(parents(pj))
      if (si >= sj) {
        parents(pi) += parents(pj)
        parents(pj) = pi
      } else {
        parents(pj) += parents(pi)
        parents(pi) = pj
      }
      count += 1
      true
    }
    
  }
  
  def minSwapsCouples(row: Array[Int]): Int = {
    val N = row.length / 2
    val dsu = DSU(N)
    for (i <- 0 until N) {
      dsu.union(row(2 * i) / 2, row(2 * i + 1) / 2)
    }
    dsu.count
  }
}