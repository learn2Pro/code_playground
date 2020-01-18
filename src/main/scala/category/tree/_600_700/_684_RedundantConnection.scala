package category.tree._600_700


/**
  * 684. Redundant Connection
  */
object _684_RedundantConnection {
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = {
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
        val sizeX = Math.abs(parent(xr))
        val sizeY = Math.abs(parent(yr))
        if (sizeX >= sizeY) {
          parent(yr) = xr
          parent(xr) -= sizeY
        } else {
          parent(xr) = yr
          parent(yr) -= sizeX
        }
        true
      }
    }
    
    val dsu = Dsu(edges.length)
    edges.foreach { edge =>
      if (!dsu.union(edge(0), edge(1))) return edge
    }
    null
  }
  
  //  def findRedundantConnectionV1(edges: Array[Array[Int]]): Array[Int] = {
  //    val edgeHolder = edges.flatMap { arr =>
  //      Iterator(arr(0) -> arr(1), arr(1) -> arr(0))
  //    }.groupBy(_._1).map { case (first, second) =>
  //      first -> second.map(_._2).distinct
  //    }
  //    val indexes = edges.zipWithIndex.map { case (arr, idx) =>
  //      (arr(0), arr(1)) -> idx
  //    }.toMap
  //
  //    var max = -1
  //    val visited = new java.util.HashSet[Int]
  //
  //    def findLoop(child: Int, parent: Int): (Boolean, Int) = {
  //      if (visited.contains(child)) return (true, child)
  //      visited.add(child)
  //      val nextHop = edgeHolder(child).filter(_ != parent)
  //      if (nextHop.isEmpty) return (false, -1)
  //      nextHop.foreach { hop =>
  //        val (ans, target) = findLoop(hop, child)
  //        if (ans) {
  //          if (target != -1) max = Math.max(max, indexes.getOrElse((child, hop), indexes((hop, child))))
  //          val part1 = if (target == child) -1 else target
  //          return (true, part1)
  //        }
  //      }
  //      (false, -1)
  //    }
  //
  //    findLoop(edges.head.head, 0)
  //    edges(max)
  //
  //  }
}