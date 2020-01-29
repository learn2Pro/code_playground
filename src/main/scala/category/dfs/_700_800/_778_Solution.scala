package category.dfs._700_800


/**
  * 778. Swim in Rising Water
  */
object _778_Solution {
  
  import scala.collection.mutable
  
  def swimInWater(grid: Array[Array[Int]]): Int = {
    val N = grid.length
    val directions = Array((-1, 0), (1, 0), (0, -1), (0, 1))
    /*heap*/
    val candidate = new mutable.PriorityQueue[(Int, Int, Int)]()(new Ordering[(Int, Int, Int)] {
      override def compare(x: (Int, Int, Int), y: (Int, Int, Int)): Int = y._3 - x._3
    })
    candidate.enqueue((0, 0, grid(0)(0)))
    val seen = new java.util.HashSet[(Int, Int)]
    while (candidate.nonEmpty) {
      val (x, y, weight) = candidate.dequeue()
      if (x == N - 1 && y == N - 1) return weight
      if (!seen.contains((x, y))) {
        seen.add((x, y))
        directions.foreach { case (sx, sy) =>
          val p0 = x + sx
          val p1 = y + sy
          val boarder = p0 < 0 || p0 >= N || p1 < 0 || p1 >= N
          if (!boarder && !seen.contains((p0, p1))) {
            val dis = Math.max(0, grid(p0)(p1) - Math.max(weight, grid(x)(y)))
            candidate.enqueue((p0, p1, weight + dis))
          }
        }
      }
    }
    throw new RuntimeException("can not be here")
  }
  
  //  def swimInWater(grid: Array[Array[Int]]): Int = {
  //    val N = grid.length
  //    /*use bfs*/
  //    val directions = Array((-1, 0), (1, 0), (0, -1), (0, 1))
  //    val queue = Array.tabulate(2)(_ => new util.Stack[(Int, Int)]())
  //    var time = 0
  //
  //    def curr = queue(time % 2)
  //
  //    def next = queue((time + 1) % 2)
  //
  //    while (grid(0)(0) > time) time += 1
  //    queue(time % 2).add((0, 0))
  //    while (true) {
  //      val seen = new java.util.HashSet[(Int, Int)]
  //      while (!curr.isEmpty) {
  //        val (x, y) = curr.pop()
  //        if (x == N - 1 && y == N - 1) return time
  //        seen.add((x, y))
  //        next.add((x, y))
  //        directions.foreach { case (sx, sy) =>
  //          val p0 = x + sx
  //          val p1 = y + sy
  //          val boarder = p0 < 0 || p0 >= N || p1 < 0 || p1 >= N
  //          if (!boarder && !seen.contains((p0, p1)) && grid(p0)(p1) <= time) {
  //            curr.push((p0, p1))
  //          }
  //        }
  //      }
  //      time += 1
  //    }
  //    throw new RuntimeException("can not be here")
  //  }
}