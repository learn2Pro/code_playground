/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week36

/**
  *
  * @author derong.tdr
  * @version SpiralMatrix.scala, v 0.1 2019年09月07日 11:08 tang Exp $
  */
object SpiralMatrixII {

  private var leftTop    : (Int, Int) = _
  private var leftBottom : (Int, Int) = _
  private var rightTop   : (Int, Int) = _
  private var rightBottom: (Int, Int) = _

  def generateMatrix(n: Int): Array[Array[Int]] = {
    var number: Int = 1
    val matrix = Array.tabulate[Int](n, n)((_, _) => 0)
    init(matrix)
    while (number <= n * n) {
      number += downOneRow(matrix, number)
      number += moveColumnRight(matrix, number)
      number += upOneRow(matrix, number)
      number += moveColumnLeft(matrix, number)
    }
    matrix
  }

  private def init(matrix: Array[Array[Int]]) = {
    leftTop = (0, 0)
    leftBottom = (matrix.length - 1, 0)
    rightTop = (0, matrix(0).length - 1)
    rightBottom = (matrix.length - 1, matrix(0).length - 1)
  }

  private def downOneRow(matrix: Array[Array[Int]], number: Int): Int = {
    val ans = if (rightBottom._1 - leftTop._1 >= 0) {
      Range.inclusive(leftTop._2, rightTop._2).zipWithIndex.foreach { case (idx, step) =>
        matrix(leftTop._1)(idx) = number + step
      }
      rightTop._2 - leftTop._2 + 1
    } else {
      0
    }
    leftTop = (leftTop._1 + 1, leftTop._2)
    rightTop = (rightTop._1 + 1, rightTop._2)
    ans
  }

  private def upOneRow(matrix: Array[Array[Int]], number: Int) = {
    val ans = if (rightBottom._1 - leftTop._1 >= 0) {
      Range.inclusive(rightBottom._2, leftBottom._2, -1).zipWithIndex.foreach { case (idx, step) =>
        matrix(leftBottom._1)(idx) = number + step
      }
      rightBottom._2 - leftBottom._2 + 1
    } else {
      0
    }
    leftBottom = (leftBottom._1 - 1, leftBottom._2)
    rightBottom = (rightBottom._1 - 1, rightBottom._2)
    ans
  }

  private def moveColumnLeft(matrix: Array[Array[Int]], number: Int) = {
    val ans = if (rightBottom._2 - leftTop._2 > 0) {
      Range.inclusive(leftBottom._1, leftTop._1, -1).zipWithIndex.foreach { case (idx, step) =>
        matrix(idx)(leftBottom._2) = number + step
      }
      leftBottom._1 - leftTop._1 + 1
    } else {
      0
    }
    leftTop = (leftTop._1, leftTop._2 + 1)
    leftBottom = (leftBottom._1, leftBottom._2 + 1)
    ans
  }

  private def moveColumnRight(matrix: Array[Array[Int]], number: Int) = {
    val ans = if (rightBottom._2 - leftTop._2 > 0) {
      Range.inclusive(rightTop._1, rightBottom._1).zipWithIndex.foreach { case (idx, step) =>
        matrix(idx)(rightBottom._2) = number + step
      }
      rightBottom._1 - rightTop._1 + 1
    } else {
      0
    }
    rightTop = (rightTop._1, rightTop._2 - 1)
    rightBottom = (rightBottom._1, rightBottom._2 - 1)
    ans
  }
}
