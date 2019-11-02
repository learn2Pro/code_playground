package category.timeline.week38

/**
  * 118. Pascal's Triangle
  */
object PascalTriangle {
  def generate(numRows: Int): List[List[Int]] = {
    val ans = List.tabulate(numRows)(i => Array.tabulate(i + 1)(_ => 1))
    for (i <- 2 until numRows)
      for (j <- 1 until i) {
        ans(i)(j) = ans(i - 1)(j - 1) + ans(i - 1)(j)
      }
    ans.map(_.toList)
  }
}