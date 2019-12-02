package category.dp._300_400

/**
  * 363. Max Sum of Rectangle No Larger Than K
  */
object _363_MaxSumOfRectangleNoLargerThanK {
  
  def maxSumSubmatrix(matrix: Array[Array[Int]], k: Int): Int = {
    if (matrix.isEmpty || matrix(0).isEmpty) return 0
    val row = matrix.length
    val col = matrix(0).length
    var ans = Int.MinValue
    for (i <- 0 until row)
      for (j <- 1 until col) {
        matrix(i)(j) += matrix(i)(j - 1)
      }
    for (l <- 0 until col)
      for (r <- l until col) {
        val search = new java.util.TreeSet[Integer]()
        search.add(0)
        var sum = 0
        for (iter <- 0 until row) {
          if (l == 0) sum += matrix(iter)(r) else sum += (matrix(iter)(r) - matrix(iter)(l - 1))
          val num = search.ceiling(sum - k)
          if (num != null) ans = Math.max(ans, sum - num)
          search.add(sum)
        }
      }
    ans
  }
}