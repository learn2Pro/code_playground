package category.graph

import scala.collection.mutable

/**
  * 399. Evaluate Division
  *
  * [["a","b"],["b","c"]]
  * [2.0,3.0]
  * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
  * []
  * []
  * [["a","c"]]
  * []
  * []
  * []
  */
object _399_Solution {
  def calcEquation(
    equations: List[List[String]], values: Array[Double],
    queries: List[List[String]]): Array[Double] = {
    val adjacencyList = new mutable.HashMap[String, List[(String, Double)]]()
    equations.zip(values).foreach { case (_@List(src, dst), weight) =>
      adjacencyList.put(src, (dst, weight) :: adjacencyList.getOrElse(src, Nil))
      adjacencyList.put(dst, (src, 1.0 / weight) :: adjacencyList.getOrElse(dst, Nil))
    }
    
    def findTarget(start: String, target: String): Double = {
      if (!adjacencyList.contains(start)) return -1.0
      val queue = new java.util.LinkedList[(String, Double)]()
      val visited = new java.util.HashSet[String]()
      queue.add((start, 1.0))
      while (!queue.isEmpty) {
        val (curr, weight) = queue.remove()
        if (curr == target) return weight
        adjacencyList.getOrElse(curr, Nil).foreach { case (dst, w) =>
          if (!visited.contains(dst)) {
            visited.add(dst)
            queue.add((dst, weight * w))
          }
        }
      }
      -1.0
    }
    
    queries.map { case _@List(src, dst) =>
      findTarget(src, dst)
    }.toArray
  }
}