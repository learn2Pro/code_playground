package category.heap

/**
  * 218. The Skyline Problem
  *
  * [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
  * [[2,9,10],[3,7,15],[7,12,12],[15,20,10],[19,24,8]]
  */
object _218_Solution {
  def getSkyline(buildings: Array[Array[Int]]): List[List[Int]] = {
    var ans: List[List[Int]] = Nil
    val heap = new java.util.PriorityQueue[(Int, Int, Int)](new Ordering[(Int, Int, Int)] {
      override def compare(x: (Int, Int, Int), y: (Int, Int, Int)): Int = y._3 - x._3
    })
    val criticals = buildings.flatMap { case _@Array(l, r, h) =>
      Iterator(l -> (l, r, h), r -> (l, r, h))
    }.groupBy(_._1).mapValues(_.map(_._2)).toList.sortBy(_._1)
    criticals.foreach { case (x, arr) =>
      arr.foreach { case (l, r, h) =>
        if (x == l) heap.add((l, r, h))
        else heap.remove((l, r, h))
      }
      if (heap.isEmpty) ans ::= List(x, 0)
      else {
        val (_, _, height) = heap.peek()
        if (ans.isEmpty || ans.head.last != height) {
          ans ::= List(x, height)
        }
      }
    }
    ans.reverse.distinct
  }
}