package category.dfs._500_600

/**
  * 547. Friend Circles
  */
object _547_Solution {
  def findCircleNum(M: Array[Array[Int]]): Int = {
    val N = M.length
    var cnt = 0
    val queue = new java.util.LinkedList[Int]
    val visited = new java.util.HashSet[Int]
    
    for (i <- 0 until N if !visited.contains(i)) {
      queue.add(i)
      while (!queue.isEmpty) {
        val curr = queue.remove()
        visited.add(curr)
        for (inner <- 0 until N if inner != curr && M(curr)(inner) > 0 && !visited.contains(inner)) {
          queue.add(inner)
        }
      }
      cnt += 1
    }
    cnt
  }
}