/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week37

/**
  *
  * @author derong.tdr
  * @version MaximalSquare.scala, v 0.1 2019年09月14日 16:33 tang Exp $
  */
object MaximalSquare {

  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    if (matrix == null || matrix.isEmpty) return 0
    //init
    val m = matrix.length
    val n = matrix(0).length
    val dp = Array.tabulate(m, n)((x, y) => if (matrix(x)(y) == '1') Location(1, 1) else Location())
    //iteration
    for (i <- 1 until m)
      for (j <- 1 until n if matrix(i)(j) == '1') {
        val diagonalInDp = dp(i - 1)(j - 1)
        val upInDp = dp(i - 1)(j)
        val leftInDp = dp(i)(j - 1)
        val diagonal = Location(Math.min(diagonalInDp.x, upInDp.x) + 1, Math.min(diagonalInDp.y, leftInDp.y) + 1)
        dp(i)(j) = diagonal.square
      }
    dp.flatMap(_.map(_.area)).max
  }

  private case class Location(x: Int = 0, y: Int = 0) {
    def area: Int = x * y

    def minLoc: Int = Math.min(x, y)

    def square: Location = Location(minLoc, minLoc)
  }


}
