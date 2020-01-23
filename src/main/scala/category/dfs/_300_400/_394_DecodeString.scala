package category.dfs._300_400

/**
  * 394. Decode String
  */
object _394_DecodeString {
  def decodeString(s: String): String = {
    if (s == null || s.isEmpty) return s
    val stack = new scala.collection.mutable.Stack[String]
    val stackNum = new scala.collection.mutable.Stack[Int]
    var i = 0
    val N = s.length
    while (i < N) {
      s(i) match {
        case ']' =>
          val sb = new StringBuilder
          while (stack.nonEmpty && stack.top != "[") sb.insert(0, stack.pop())
          if (stack.nonEmpty) stack.pop()
          val s = sb.toString()
          stack.push(Array.tabulate(stackNum.pop())(_ => s).mkString)
          i += 1
        case c@_ =>
          if (Character.isDigit(c)) {
            val start = i
            while (Character.isDigit(s(i))) i += 1
            stackNum.push(s.substring(start, i).toInt)
          } else {
            stack.push(c.toString)
            i += 1
          }
      }
    }
    val sb = new StringBuilder
    while (stack.nonEmpty) sb.insert(0, stack.pop())
    sb.toString()
  }
}