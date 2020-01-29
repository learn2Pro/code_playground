package category.bfs

import java.util

import scala.collection.mutable

/**
  * 407. Trapping Rain Water II
  */
object _407_Solution {
  def trapRainWater(heightMap: Array[Array[Int]]): Int = {
    if (heightMap.isEmpty || heightMap(0).isEmpty) return 0
    val M = heightMap.length
    val N = heightMap(0).length
    val heap = new mutable.PriorityQueue[(Int, Int, Int)]()(new Ordering[(Int, Int, Int)] {
      override def compare(x: (Int, Int, Int), y: (Int, Int, Int)): Int = y._3 - x._3
    })
    val position = Array((-1, 0), (1, 0), (0, -1), (0, 1))
    val visited = new util.HashSet[(Int, Int)]()
    for (i <- 0 until M) {
      heap.enqueue((i, 0, heightMap(i)(0)))
      heap.enqueue((i, N - 1, heightMap(i)(N - 1)))
      visited.add((i, 0)); visited.add((i, N - 1))
    }
    for (j <- 1 until N - 1) {
      heap.enqueue((0, j, heightMap(0)(j))); heap.enqueue((M - 1, j, heightMap(M - 1)(j)))
      visited.add((0, j)); visited.add((M - 1, j))
    }
    var ans, max = 0
    while (heap.nonEmpty) {
      val (x, y, h) = heap.dequeue()
      max = Math.max(max, h)
      ans += Math.max(0, max - h)
      position.foreach { case (sx, sy) =>
        val px = x + sx
        val py = y + sy
        val boarder = px < 0 || px >= M || py < 0 || py >= N
        if (!boarder && !visited.contains((px, py))) {
          visited.add((px, py))
          heap.enqueue((px, py, heightMap(px)(py)))
        }
      }
    }
    ans
  }
  
  //  def trapRainWater(heightMap: Array[Array[Int]]): Int = {
  //    if (heightMap.isEmpty || heightMap(0).isEmpty) return 0
  //    val maxHeight = heightMap.map(_.max).max
  //    val M = heightMap.length
  //    val N = heightMap(0).length
  //    var ans = 0
  //
  //    val position = Array((-1, 0), (1, 0), (0, -1), (0, 1))
  //
  //    def pass(x: Int, y: Int, height: Int, set: java.util.Set[(Int, Int)]): (Boolean, Int) = {
  //      val queue = new util.LinkedList[(Int, Int)]()
  //      queue.add((x, y))
  //      set.add((x, y))
  //      var count = 1
  //      var stop = false
  //      while (!queue.isEmpty) {
  //        val (cx, cy) = queue.remove()
  //        position.foreach { case (sx, sy) =>
  //          val px = sx + cx
  //          val py = sy + cy
  //          val border = px <= 0 || px >= M - 1 || py <= 0 || py >= N - 1
  //          if (border && heightMap(px)(py) < height) stop = true
  //          if (!border && heightMap(px)(py) < height && !set.contains((px, py))) {
  //            set.add((px, py))
  //            queue.add((px, py))
  //            count += 1
  //          }
  //        }
  //      }
  //      if (stop) (false, 0) else (true, count)
  //    }
  //
  //    def testify(x: Int, y: Int, height: Int, set: java.util.Set[(Int, Int)]): (Boolean, Int) = {
  //      if (heightMap(x)(y) >= height) return (false, 0)
  //      pass(x, y, height, set)
  //    }
  //
  //    for (h <- Range(maxHeight, 0, -1)) {
  //      val visited = new util.HashSet[(Int, Int)]()
  //      for (i <- 1 until M - 1)
  //        for (j <- 1 until N - 1 if !visited.contains((i, j))) {
  //          val (pass, sz) = testify(i, j, h, visited)
  //          if (pass) ans += sz
  //        }
  //      visited.clear()
  //    }
  //    ans
  //  }
}