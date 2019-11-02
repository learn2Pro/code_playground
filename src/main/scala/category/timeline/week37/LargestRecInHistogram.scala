/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week37


/**
  *
  * @author derong.tdr
  * @version LargestRecInHistogram.scala, v 0.1 2019年09月14日 13:15 tang Exp $
  */
object LargestRecInHistogram {

  import java.util

  def largestRectangleArea(heights: Array[Int]): Int = {
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


}
