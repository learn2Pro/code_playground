package category.dfs._200_300


/**
  * 207. Course Schedule
  * L ← Empty list that will contain the sorted elements
  * S ← Set of all nodes with no incoming edge
  *
  * while S is non-empty do
  * remove a node n from S
  * add n to tail of L
  * for each node m with an edge e from n to m do
  * remove edge e from the graph
  * if m has no other incoming edges then
  * insert m into S
  *
  * if graph has edges then
  * return error   (graph has at least one cycle)
  * else
  * return L   (a topologically sorted order)
  */
object _207_CourseSchedule {
  
  import java.util
  
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val indegree = new Array[Int](numCourses)
    val matrix = Array.ofDim[Int](numCourses, numCourses)
    prerequisites.foreach { case _@Array(target, require) =>
      /*remove dup case*/
      indegree(target) += 1
      matrix(require)(target) = 1
    }
    var count = 0
    val queue = new util.LinkedList[Int]
    for (i <- indegree.indices if indegree(i) == 0) {
      queue.add(i)
    }
    while (!queue.isEmpty) {
      val current = queue.remove()
      count += 1
      for (i <- 0 until numCourses) {
        if (matrix(current)(i) != 0) {
          indegree(i) -= 1
          if (indegree(i) == 0) queue.add(i)
        }
      }
    }
    count == numCourses
  }
  
  //  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
  //    val arr = new Array[scala.collection.mutable.HashSet[Int]](numCourses)
  //    prerequisites.foreach { case _@Array(take, require) =>
  //      val set = Option(arr(take)).getOrElse(new scala.collection.mutable.HashSet[Int]())
  //      set.add(require)
  //      arr(take) = set
  //    }
  //    val visited = new java.util.HashSet[Int]
  //
  //    def dfs(start: Int, parents: java.util.HashSet[Int]): Boolean = {
  //      if (parents.contains(start)) return false
  //      if (visited.contains(start) || arr(start) == null) return true
  //      visited.add(start)
  //      parents.add(start)
  //      arr(start).foreach { next =>
  //        val ans = dfs(next, parents)
  //        if (!ans) return false
  //      }
  //      true
  //    }
  //
  //    for (i <- 0 until numCourses) {
  //      val ans = dfs(i, new java.util.HashSet[Int])
  //      if (!ans) return false
  //    }
  //    true
  //  }
}