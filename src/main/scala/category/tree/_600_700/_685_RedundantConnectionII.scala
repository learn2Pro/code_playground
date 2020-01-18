package category.tree._600_700

/**
  * 685. Redundant Connection II
  */
object _685_RedundantConnectionII {
  def findRedundantDirectedConnection(edges: Array[Array[Int]]): Array[Int] = {
    /*DSU*/
    case class Dsu(size: Int) {
      val parent = Array.tabulate(size + 1)(_ => -1)
      
      def find(i: Int): Int = {
        if (parent(i) < 0) return i
        find(parent(i))
      }
      
      def union(left: Int, right: Int): Boolean = {
        val xr = find(left)
        val yr = find(right)
        if (xr == yr) return false
        parent(xr) -= Math.abs(parent(yr))
        parent(yr) = xr
        true
      }
    }
    
    val parents = edges.groupBy(_ (1)).map { case (k, v) => k -> v.map(_ (0)) }
    parents.foreach { case (k, v) =>
      
      if (v.length > 1) {
        var tmp = v(0)
        while (parents.contains(tmp) && tmp != k) tmp = parents(tmp).head
        if (tmp == k) return Array(v(0), k) else return Array(v(1), k)
      }
    }
    
    val dsu = Dsu(edges.length)
    edges.foreach { edge =>
      if (!dsu.union(edge(0), edge(1))) return edge
    }
    null
  }
}