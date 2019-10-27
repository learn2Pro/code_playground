/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week37



/**
  *
  * @author derong.tdr
  * @version MaximalRectangle.scala, v 0.1 2019年09月14日 15:13 tang Exp $
  */
object MaximalRectangle {
  import java.util
  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if (matrix == null || matrix.isEmpty) return 0
    val m = matrix.length
    val n = matrix(0).length
    var max = 0
    for (i <- 0 until m) {
      val arr = Array.tabulate(n) { j =>
        getHeight(i, j, matrix)
      }
      val area = largestRectangleArea(arr)
      max = Math.max(max, area)
    }
    max
  }

  private def largestRectangleArea(heights: Array[Int]): Int = {
    if (heights == null || heights.isEmpty) return 0
    if (heights.length == 1) return heights(0)
    val stack = new util.Stack[Int]()
    val pushed = heights ++ Array(0)
    var ans = 0
    for (i <- pushed.indices) {
      while (!stack.isEmpty && pushed(stack.peek()) >= pushed(i)) {
        val curr = stack.pop()
        val len = if (!stack.isEmpty) {
          i - stack.peek() - 1
        } else {
          i
        }
        ans = Math.max(ans, pushed(curr) * len)
      }
      stack.push(i)
    }
    ans
  }

  private def getHeight(i: Int, j: Int, matrix: Array[Array[Char]]): Int = {
    var step = i
    var height = 0
    while (step >= 0 && matrix(step)(j) == '1') {
      height += 1
      step -= 1
    }
    height
  }


}

