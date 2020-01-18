package category.hashtable._400_500

/**
  * 454. 4Sum II
  */
object _454_4SumII {
  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    val N = A.length
    def build(arr0: Array[Int], arr1: Array[Int], set: scala.collection.mutable.HashMap[Int, Int]): Unit = {
      for (i <- 0 until N)
        for (j <- 0 until N) {
          set.put(arr0(i) + arr1(j), set.getOrElse(arr0(i) + arr1(j), 0) + 1)
        }
    }
    
    val set0 = new scala.collection.mutable.HashMap[Int, Int]
    val set1 = new scala.collection.mutable.HashMap[Int, Int]
    build(A, B, set0)
    build(C, D, set1)
    var ans = 0
    set0.foreach { case (k, size) =>
      if (set1.contains(-1 * k)) {
        ans += (size * set1(-1 * k))
      }
    }
    ans
  }
}