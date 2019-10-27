/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36

/**
  *
  * @author derong.tdr
  * @version SpiralMatrix.scala, v 0.1 2019年09月07日 11:08 tang Exp $
  */
object SpiralMatrix {

  var leftTop    : (Int, Int) = _
  var leftBottom : (Int, Int) = _
  var rightTop   : (Int, Int) = _
  var rightBottom: (Int, Int) = _

  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    if (matrix == null || matrix.isEmpty) return Nil
    init(matrix)
    var ans: List[Int] = Nil
    while (leftTop._1 <= rightBottom._1 || leftTop._2 <= rightBottom._2) {
      ans ++= downOneRow(matrix)
      ans ++= moveColumnRight(matrix)
      ans ++= upOneRow(matrix)
      ans ++= moveColumnLeft(matrix)
    }
    ans
  }

  private def init(matrix: Array[Array[Int]]) = {
    leftTop = (0, 0)
    leftBottom = (matrix.length - 1, 0)
    rightTop = (0, matrix(0).length - 1)
    rightBottom = (matrix.length - 1, matrix(0).length - 1)
  }

  private def downOneRow(matrix: Array[Array[Int]]): List[Int] = {
    val ans = if (rightBottom._1 - leftTop._1 >= 0) {
      Range.inclusive(leftTop._2, rightTop._2).foldLeft[List[Int]](Nil) { case (arr, idx) =>
        arr ++ List(matrix(leftTop._1)(idx))
      }
    } else {
      Nil
    }
    leftTop = (leftTop._1 + 1, leftTop._2)
    rightTop = (rightTop._1 + 1, rightTop._2)
    ans
  }

  private def upOneRow(matrix: Array[Array[Int]]) = {
    val ans = if (rightBottom._1 - leftTop._1 >= 0) {
      Range.inclusive(rightBottom._2, leftBottom._2, -1).foldLeft[List[Int]](Nil) { case (arr, idx) =>
        arr ++ List(matrix(leftBottom._1)(idx))
      }
    } else {
      Nil
    }
    leftBottom = (leftBottom._1 - 1, leftBottom._2)
    rightBottom = (rightBottom._1 - 1, rightBottom._2)
    ans
  }

  private def moveColumnLeft(matrix: Array[Array[Int]]) = {
    val ans = if (rightBottom._2 - leftTop._2 >= 0) {
      Range.inclusive(leftBottom._1, leftTop._1, -1).foldLeft[List[Int]](Nil) { case (arr, idx) =>
        arr ++ List(matrix(idx)(leftBottom._2))
      }
    } else {
      Nil
    }
    leftTop = (leftTop._1, leftTop._2 + 1)
    leftBottom = (leftBottom._1, leftBottom._2 + 1)
    ans
  }

  private def moveColumnRight(matrix: Array[Array[Int]]) = {
    val ans = if (rightBottom._2 - leftTop._2 >= 0) {
      Range.inclusive(rightTop._1, rightBottom._1).foldLeft[List[Int]](Nil) { case (arr, idx) =>
        arr ++ List(matrix(idx)(rightBottom._2))
      }
    } else {
      Nil
    }
    rightTop = (rightTop._1, rightTop._2 - 1)
    rightBottom = (rightBottom._1, rightBottom._2 - 1)
    ans
  }
}
