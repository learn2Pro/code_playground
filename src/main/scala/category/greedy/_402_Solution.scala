package category.greedy

import scala.collection.mutable

/**
  * 402. Remove K Digits
  */
object _402_Solution {
  def removeKdigits(num: String, k: Int): String = {
    val stack = new mutable.Stack[Char]
    val sb = new mutable.StringBuilder()
    val N = num.length
    for (i <- 0 until N) {
      while (stack.nonEmpty && num(i) < stack.top && stack.size - i > -k) {
        stack.pop()
      }
      if (stack.size < N - k) stack.push(num(i))
    }
    stack.foreach(sb.append)
    while (sb.nonEmpty && sb.last == '0') sb.deleteCharAt(sb.length - 1)
    if (sb.isEmpty) "0" else sb.reverse.toString()
  }
}