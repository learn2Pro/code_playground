/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36

import scala.annotation.tailrec

/**
  *
  * @author derong.tdr
  * @version TriangleMinimumSum.scala, v 0.1 2019年09月02日 23:37 tang Exp $
  */
object TriangleMinimumSum {

  var height: Int = _
  var width : Int = _

  def minimumTotal(triangle: List[List[Int]]): Int = {
    height = triangle.length
    width = triangle(height - 1).length * 2 - 1
    minimum((width / 2, 0), triangle)
  }

  private def minimum(start: (Int, Int), triangle: List[List[Int]]): Int = {
    val child = childNodes(start, triangle)
    val curr = nodeValue(start, triangle)
    if (child._1 == 0 && child._2 == 0) return curr
    if (Math.abs(child._2 - child._1) >= start._2) {
      minimum(pickLeastChild(start, child), triangle) + curr
    } else {
      Math.min(
        minimum((start._1 - 1, start._2 + 1), triangle) + curr,
        minimum((start._1 + 1, start._2 + 1), triangle) + curr
      )
    }
  }

  private def pickLeastChild(start: (Int, Int), value: (Int, Int)): (Int, Int) = {
    if (value._1 < value._2) {
      (start._1 - 1, start._2 + 1)
    } else {
      (start._1 + 1, start._2 + 1)
    }
  }


  private def nodeValue(coordinate: (Int, Int), triangle: List[List[Int]]): Int = {
    val loc = trans2Location((coordinate._1, coordinate._2), width, height)
    triangle(loc._2)(loc._1)
  }

  /**
    * child node of (left,righ)
    */
  private def childNodes(coordinate: (Int, Int), triangle: List[List[Int]]): (Int, Int) = {
    if (coordinate._2 + 1 >= height) {(0, 0)}
    else {
      (nodeValue((coordinate._1 - 1, coordinate._2 + 1), triangle), nodeValue((coordinate._1 + 1, coordinate._2 + 1), triangle))
    }
  }

  /**
    * tree loc to array loc
    */
  private def trans2Location(coordinate: (Int, Int), width: Int, height: Int): (Int, Int) = {
    val offset = height - 1 - coordinate._2
    ((coordinate._1 - offset) / 2, coordinate._2)
  }

}
