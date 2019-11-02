/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week36

import scala.collection.mutable


/**
  *
  * @author derong.tdr
  * @version SetMatrixZeroes.scala, v 0.1 2019年09月08日 18:58 tang Exp $
  */
object SetMatrixZeroes {

  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val rows = new mutable.HashSet[Int]()
    val cols = new mutable.HashSet[Int]()
    val m = matrix.length
    val n = matrix(0).length
    for (i <- 0 until m)
      for (j <- 0 until n) {
        if (matrix(i)(j) == 0) {
          rows.add(i)
          cols.add(j)
        }
      }
    rows.foreach { idx =>
      val arr = matrix(idx)
      for (i <- arr.indices) arr(i) = 0
    }
    cols.foreach { idx =>
      for (i <- 0 until m) {
        matrix(i)(idx) = 0
      }
    }

  }
}
