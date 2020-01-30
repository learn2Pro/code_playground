package category.stack

import scala.collection.mutable

/**
  * 735. Asteroid Collision
  *
  * [5,10,-5]
  * [-2,1]
  * [8,-8]
  * [-8,8]
  * [10,2,-5]
  * [-2, -1, 1, 2]
  * []
  */
object _735_Solution {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    val stack = new mutable.Stack[Int]
    asteroids.foreach { item =>
      var curr = item
      while (stack.nonEmpty && curr < 0 && stack.top > 0) {
        if (Math.abs(curr) < Math.abs(stack.top)) {curr = 0}
        else if (Math.abs(curr) == Math.abs(stack.top)) {stack.pop; curr = 0}
        else {stack.pop; curr = item}
      }
      if (curr != 0) stack.push(item)
    }
    stack.toArray.reverse
  }
}