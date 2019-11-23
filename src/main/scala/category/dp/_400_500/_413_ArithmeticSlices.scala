package category.dp._400_500

/**
  * 413. Arithmetic Slices
  */
object _413_ArithmeticSlices {
  def numberOfArithmeticSlices(A: Array[Int]): Int = {
    var count: Int = 0
    var sum: Int = 0
    var i: Int = 2
    for (i <- 2 until A.length) {
      if (A(i) - A(i - 1) == A(i - 1) - A(i - 2)) {
        count += 1
      } else {
        sum += (count + 1) * count / 2
        count = 0
      }
    }
    sum += count * (count + 1) / 2
    sum
  }
  
  def numberOfArithmeticSlicesV1(A: Array[Int]): Int = {
    def isSlices(i: Int): Boolean = {
      A(i - 1) - A(i - 2) == A(i) - A(i - 1)
    }
    
    def sliceNum(i: Int): Int = {
      val condition = isSlices(i)
      if (condition) 1 else 0
    }
    
    val n = A.length
    if (n < 3) return 0
    var state = 0
    var ans = 0
    for (i <- 2 until n) {
      if (state != 0 && isSlices(i)) {
        state += 1
      } else {
        state = sliceNum(i)
      }
      ans += state
    }
    ans
  }
}

