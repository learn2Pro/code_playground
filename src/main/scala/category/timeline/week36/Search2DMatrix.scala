/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week36

/**
  *
  * @author derong.tdr
  * @version Search2DMatrix.scala, v 0.1 2019年09月08日 19:44 tang Exp $
  */
object Search2DMatrix {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix == null || matrix.isEmpty || matrix(0).isEmpty) return false
    val rowNum = matrix.length
    val colNum = matrix(0).length
    findMid(matrix, 0, rowNum * colNum - 1, target)
  }

  private def findMid(matrix: Array[Array[Int]], start: Int, end: Int, target: Int): Boolean = {
    val colNum = matrix(0).length
    if (start + 1 >= end) {
      val (x0, y0) = transIndex2Loc(start, colNum)
      val (x1, y1) = transIndex2Loc(end, colNum)
      matrix(x0)(y0) == target || matrix(x1)(y1) == target
    }
    else {
      val step = (end - start) / 2
      val mid = start + step
      val (x, y) = transIndex2Loc(mid, colNum)
      if (matrix(x)(y) == target) true
      else if (matrix(x)(y) < target) findMid(matrix, mid, end, target)
      else findMid(matrix, start, mid, target)
    }
  }

  private def transIndex2Loc(idx: Int, row: Int): (Int, Int) = {
    val x = idx / row
    val y = idx % row
    (x, y)
  }
}
