package category.stack

import scala.collection.mutable

/**
  * 682. Baseball Game
  *
  * ["5","2","C","D","+"]
  * ["5","-2","4","C","D","9","+","+"]
  * ["5"]
  */
object _682_Solution {
  def calPoints(ops: Array[String]): Int = {
    val stack = new mutable.Stack[Int]
    ops.foreach {
      case "+" =>
        val right = stack.pop()
        val left = stack.pop()
        stack.push(left)
        stack.push(right)
        stack.push(left + right)
      case "C" =>
        if (stack.nonEmpty) stack.pop()
      case "D" =>
        stack.push(stack.top * 2)
      case s: String =>
        stack.push(s.toInt)
    }
    stack.sum
  }
}