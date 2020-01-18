package category.hashtable._500_600

/**
  * 554. Brick Wall
  */
object _554_BrickWall {
  def leastBricks(wall: List[List[Int]]): Int = {
    val mapping = new scala.collection.mutable.HashMap[Int, Int]
    val height = wall.length
    var ans = height
    wall.foreach { row =>
      val N = row.size
      var width = 0
      for (i <- 0 until N - 1) {
        width += row(i)
        val cnt = mapping.getOrElse(width, 0) + 1
        mapping.put(width, cnt)
        ans = Math.min(ans, height - cnt)
      }
    }
    ans
  }
  
  //  def leastBricks(wall: List[List[Int]]): Int = {
  //    val N = wall.length
  //    val arr = Array.tabulate(N)(i => (wall(i).head, 0))
  //    var ans = Int.MaxValue
  //    var sum = 0
  //    val range = new scala.collection.mutable.HashSet[Int]
  //    wall.foreach(lst => sum = lst.foldLeft(0) { case (i, last) =>
  //      range.add(i + last)
  //      i + last
  //    })
  //    range.remove(sum)
  //    val lst = range.toArray.sorted
  //    for (i <- lst) {
  //      var cnt = 0
  //      for (h <- 0 until N) {
  //        var (acc, loc) = arr(h)
  //        if (acc < i) {
  //          acc += wall(h)(loc + 1)
  //          arr(h) = (acc, loc + 1)
  //          if (acc != i || acc == sum) cnt += 1
  //        } else if (acc > i) {
  //          cnt += 1
  //        }
  //      }
  //      ans = Math.min(ans, cnt)
  //    }
  //    if (ans == Int.MaxValue) N else ans
  //  }
}