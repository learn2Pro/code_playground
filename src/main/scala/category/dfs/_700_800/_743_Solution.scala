package category.dfs._700_800


/**
  * 743. Network Delay Time
  */
object _743_Solution {
  
  import scala.collection.mutable
  
  def networkDelayTime(times: Array[Array[Int]], N: Int, K: Int): Int = {
    val state = new mutable.HashMap[Int, Int]
    val edges = times.map { case _@Array(s, d, w) =>
      s -> (d, w)
    }.groupBy(_._1).mapValues(_.map(_._2).sortBy(_._2))
    val heap = new mutable.PriorityQueue[(Int, Int)]()(new Ordering[(Int, Int)] {
      override def compare(x: (Int, Int), y: (Int, Int)): Int = y._1 - x._1
    })
    heap.enqueue((0, K))
    while (heap.nonEmpty) {
      val (previous, n) = heap.dequeue()
      if (!state.contains(n)) {
        state.put(n, previous)
        edges.getOrElse(n, Array.empty).foreach { case (dst, weight) =>
          if (!state.contains(dst)) heap.enqueue((weight + previous, dst))
        }
      }
    }
    if (state.size != N) -1 else state.values.max
  }
  
  //  def networkDelayTime(times: Array[Array[Int]], N: Int, K: Int): Int = {
  //    val state = Array.tabulate(N)(_ => Int.MaxValue)
  //
  //    val edges = times.map { case _@Array(s, d, w) =>
  //      s -> (d, w)
  //    }.groupBy(_._1).mapValues(_.map(_._2).sortBy(_._2))
  //
  //    def dfs(start: Int, previous: Int): Unit = {
  //      if (previous >= state(start - 1)) return
  //      state(start - 1) = previous
  //      edges.getOrElse(start, Array.empty).foreach { case (dst, w) =>
  //        val path = w + previous
  //        dfs(dst, path)
  //      }
  //    }
  //
  //    dfs(K, 0)
  //    if (state.contains(Int.MaxValue)) -1 else state.max
  //  }
}