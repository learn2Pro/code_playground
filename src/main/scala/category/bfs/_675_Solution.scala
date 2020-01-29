package category.bfs

import java.util
import java.util.Comparator

/**
  * 675. Cut Off Trees for Golf Event
  */
object _675_Solution {
  def cutOffTree(forest: List[List[Int]]): Int = {
    val position = Array((-1, 0), (1, 0), (0, -1), (0, 1))
    val M = forest.size
    val N = forest.head.size
    
    def distance(x0: Int, y0: Int, x1: Int, y1: Int): Int = {
      val queue = new util.LinkedList[(Int, Int)]()
      val visited = new util.HashSet[(Int, Int)]()
      queue.add((x0, y0))
      var depth = 0
      while (!queue.isEmpty) {
        val len = queue.size()
        for (_ <- 0 until len) {
          val (x, y) = queue.remove()
          if (x == x1 && y == y1) return depth
          position.foreach { case (sx, sy) =>
            val px = x + sx
            val py = y + sy
            val boarder = px < 0 || px >= M || py < 0 || py >= N
            if (!boarder && !visited.contains((px, py)) && forest(px)(py) != 0) {
              visited.add((px, py))
              queue.add((px, py))
            }
          }
        }
        depth += 1
      }
      -1
    }
    
    val heap = new util.PriorityQueue[(Int, Int, Int)](new Comparator[(Int, Int, Int)] {
      override def compare(o1: (Int, Int, Int), o2: (Int, Int, Int)): Int = o1._3 - o2._3
    })
    for (i <- 0 until M)
      for (j <- 0 until N if forest(i)(j) > 1) {
        heap.add((i, j, forest(i)(j)))
      }
    
    var ans = 0
    var curr = (0, 0)
    while (!heap.isEmpty) {
      val (x, y, _) = heap.poll()
      val dis = distance(curr._1, curr._2, x, y)
      if (dis < 0) return -1
      ans += dis
      curr = (x, y)
    }
    ans
  }
  
  //  def cutOffTree(forest: List[List[Int]]): Int = {
  //    val M = forest.length
  //    val N = forest(0).length
  //    val queue = new util.LinkedList[(Int, Int)]
  //    val visited = new util.HashSet[(Int, Int)]
  //    val heap = new util.PriorityQueue[(Int, Int, Int)](new Comparator[(Int, Int, Int)] {
  //      override def compare(o1: (Int, Int, Int), o2: (Int, Int, Int)): Int = o1._3 - o2._3
  //    })
  //    val position = Array((-1, 0), (1, 0), (0, -1), (0, 1))
  //    queue.add((0, 0))
  //    visited.add((0, 0))
  //    var ans = 0
  //    while (!queue.isEmpty) {
  //      val (x, y) = queue.remove()
  //      position.foreach { case (sx, sy) =>
  //        val px = x + sx
  //        val py = y + sy
  //        val boarder = px < 0 || px >= M || py < 0 || py >= N
  //        if (!boarder && !visited.contains((px, py)) && forest(px)(py) != 0) {
  //          visited.add((px, py))
  //          queue.add((px, py))
  //          if (forest(px)(py) > 1) heap.add((px, py, forest(px)(py)))
  //        }
  //      }
  //    }
  //    ans
  //  }
}