package category.hashtable._400_500

/**
  * 447. Number of Boomerangs
  */
object _447_NumberOfBoomerangs {
  def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
    if (points.isEmpty) return 0
    
    def distance(us: Array[Int], other: Array[Int]): Int = {
      (us(0) - other(0)) * (us(0) - other(0)) + (us(1) - other(1)) * (us(1) - other(1))
    }
    
    val counter = new scala.collection.mutable.HashMap[(Int, Int, Int), Int]
    val N = points.length
    for (i <- 0 until N)
      for (j <- 0 until N if i != j) {
        val l = points(i)
        val r = points(j)
        val ans = (l(0), l(1), distance(l, r))
        counter.put(ans, counter.getOrElse(ans, 0) + 1)
      }
    
    var ans = 0
    counter.foreach { case (_, size) =>
      ans += (size * (size - 1))
    }
    ans
  }
}