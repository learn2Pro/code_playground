package category.dfs._200_300


/**
  * 210. Course Schedule II
  */
object _210_CourseScheduleII {
  
  import java.util
  
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val ordered = new Array[Int](numCourses)
    val indegree = new Array[Int](numCourses)
    val edges = Array.ofDim[Int](numCourses, numCourses)
    prerequisites.foreach { case _@Array(target, require) =>
      indegree(target) += 1
      edges(require)(target) = 1
    }
    val queue = new util.LinkedList[Int]
    for (i <- indegree.indices if indegree(i) == 0) {
      queue.add(i)
    }
    var i = 0
    while (!queue.isEmpty) {
      val current = queue.remove()
      ordered(i) = current
      i += 1
      for (i <- 0 until numCourses if edges(current)(i) != 0) {
        indegree(i) -= 1
        if (indegree(i) == 0) queue.add(i)
      }
    }
    if (i != numCourses) Array.empty else ordered
  }
}