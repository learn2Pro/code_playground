/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week35

/**
  *
  * @author derong.tdr
  * @version RotateImage.scala, v 0.1 2019年09月01日 22:42 tang Exp $
  */
object RotateImage {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    val size = matrix.length
    for (batch <- Range(size, 0, -2)) {
      rotateOnce(batch, matrix)
    }
  }

  private def rotateOnce(size: Int, matrix: Array[Array[Int]]): Unit = {
    if (size == 1 || size == 0) return
    val len = matrix.length
    //up
    val loc0 = ((len - size) / 2, (len - size) / 2)
    //right
    val loc1 = ((len - size) / 2, (len + size) / 2 - 1)
    //down
    val loc2 = ((len + size) / 2 - 1, (len + size) / 2 - 1)
    //left
    val loc3 = ((len + size) / 2 - 1, (len - size) / 2)
    for (i <- 0 until size - 1) {
      var tmp = pick(matrix, (loc0._1, loc0._2 + i))
      //up->right
      tmp = replace(matrix, (loc1._1 + i, loc1._2), tmp)
      //right->down
      tmp = replace(matrix, (loc2._2, loc2._2 - i), tmp)
      //down->left
      tmp = replace(matrix, (loc3._1 - i, loc3._2), tmp)
      //left->up
      tmp = replace(matrix, (loc0._1, loc0._2 + i), tmp)
    }
  }

  private def pick(matrix: Array[Array[Int]], loc: (Int, Int)): Int = {
    matrix(loc._1)(loc._2)
  }

  private def replace(matrix: Array[Array[Int]], loc: (Int, Int), updated: Int): Int = {
    val curr = pick(matrix, loc)
    matrix(loc._1)(loc._2) = updated
    curr
  }
}
