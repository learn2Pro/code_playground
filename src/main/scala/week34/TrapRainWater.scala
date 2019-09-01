/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week34

/**
  *
  * @author derong.tdr
  * @version TrapRainWater.scala, v 0.1 2019年08月24日 13:12 tang Exp $
  */
object TrapRainWater {
  def trap(height: Array[Int]): Int = {
    var left = 0
    var right = height.length - 1
    var ans = 0
    var left_max = 0
    var right_max = 0
    while (left < right) {
      if (height(left) < height(right)) {
        if (height(left) >= left_max) {
          left_max = height(left)
        } else {
          ans += (left_max - height(left))
        }
        left += 1
      }
      else {
        if (height(right) >= right_max) {
          right_max = height(right)
        } else {
          ans += (right_max - height(right))
        }
        right -= 1
      }
    }
    ans
  }

  //  def trap(height: Array[Int]): Int = {
  //    if (height.isEmpty || height.length == 1) return 0
  //    var ans = 0
  //    val stack = new java.util.Stack[(Int, Int)]()
  //    height.zipWithIndex.filter(_._1 != 0).foreach { case (num, location) =>
  //      if (stack.empty()) stack.push((num, location))
  //      else {
  //        var last = 0
  //        while (!stack.empty() && stack.peek()._1 <= num) {
  //          val (top, loc) = stack.peek()
  //          ans += (top - last) * (location - loc - 1)
  //          last = top
  //          stack.pop()
  //        }
  //        if (!stack.empty()) {
  //          val (_, loc) = stack.peek()
  //          ans += (num - last) * (location - loc - 1)
  //        }
  //        stack.push((num, location))
  //      }
  //    }
  //    ans
  //  }

  //  def trap(height: Array[Int]): Int = {
  //    if (height.isEmpty || height.length == 1) return 0
  //    var ans = 0
  //    val maxHeight = height.max
  //    for (h <- Range(maxHeight, 0, -1)) {
  //      ans += step(height.zipWithIndex.filter(_._1 >= h).map(_._2))
  //    }
  //    ans
  //  }
  //
  //  private def step(current: Array[Int]): Int = {
  //    if (current == null || current.length == 1) return 0
  //    var sum = 0
  //    current.reduce[Int] { case (last: Int, location: Int) =>
  //      sum += (location - last - 1)
  //      location
  //    }
  //    sum
  //  }
}
