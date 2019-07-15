package week28

import scala.collection.mutable

/**
  * @author tang
  * @date 2019/07/13
  */
object ValidParenthesesSolution {

  val relation = Map(
    ')' -> '(',
    ']' -> '[',
    '}' -> '{'
  )


  def isValid(s: String): Boolean = {
    s.isEmpty || {
      val stack = new mutable.ArrayStack[Char]()
      s.foreach {
        case r@('(' | '[' | '{') =>
          stack.push(r)
        case r@(')' | ']' | '}') =>
          if (stack.nonEmpty && stack.top == relation(r)) {
            stack.pop()
          } else {
            return false
          }
      }
      stack.isEmpty
    }
  }
}
