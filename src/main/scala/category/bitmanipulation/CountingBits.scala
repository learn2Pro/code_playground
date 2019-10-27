package category.bitmanipulation

/**
  * 338. Counting Bits
  */
object CountingBits {
  //  def countBits(num: Int): Array[Int] = {
  //    require(num >= 0)
  //    (for (i <- 0 to num) yield {
  //      java.lang.Integer.bitCount(i)
  //    }).toArray
  //  }
  
  def countBits(num: Int): Array[Int] = {
    require(num >= 0)
    if (num == 0) return Array(0)
    val ans = Array.tabulate(num + 1)(_ => 0)
    var i, j = 1
    while (i <= num) {
      if ((i & (i - 1)) == 0) {
        j = 0
      }
      ans(i) = 1 + ans(j)
      i += 1
      j += 1
    }
    ans
  }
}