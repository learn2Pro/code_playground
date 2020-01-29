package category.dfs._700_800


/**
  * 785. Is Graph Bipartite?
  */
object _785_Solution {
  def isBipartite(graph: Array[Array[Int]]): Boolean = {
    val N = graph.length
    val color = new Array[Int](N)
    for (i <- 0 until N) {
      if (color(i) == 0) {
        val queue = new java.util.Stack[Int]
        queue.add(i)
        color(i) = 1
        while (!queue.isEmpty) {
          val curr = queue.pop()
          graph(curr).foreach { dst =>
            if (color(dst) != 0 && color(curr) == color(dst)) return false
            if (color(dst) == 0) {
              color(dst) = -color(curr)
              queue.add(dst)
            }
          }
        }
      }
    }
    true
  }
  
  //  def isBipartite(graph: Array[Array[Int]]): Boolean = {
  //    val N = graph.length
  //    val color = new Array[Int](N)
  //    for (i <- 0 until N) {
  //      if (color(i) == 0) {
  //        val queue = new util.LinkedList[Int]
  //        queue.add(i)
  //        color(i) = 1
  //        while (!queue.isEmpty) {
  //          val curr = queue.remove()
  //          graph(curr).foreach { dst =>
  //            if (color(dst) != 0 && color(curr) == color(dst)) return false
  //            if (color(dst) == 0) {
  //              color(dst) = -color(curr)
  //              queue.add(dst)
  //            }
  //          }
  //        }
  //      }
  //    }
  //    true
  //  }
}