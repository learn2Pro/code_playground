package week38

/**
  * 119. Pascal's Triangle II
  */
object PascalTriangleII {
  def getRow(rowIndex: Int): List[Int] = {
    if (rowIndex == 0) return List(1)
    var last = List(1, 1)
    for (i <- 2 until rowIndex + 1) {
      val arr = Array.tabulate(i + 1)(_ => 1)
      for (j <- 1 until i) {
        arr(j) = last(j - 1) + last(j)
      }
      last = arr.toList
    }
    last
  }
}