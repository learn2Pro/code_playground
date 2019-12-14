package category.math._200_300


/**
  * 224. Basic Calculator
  */
object _224_BasicCalculator {
  def calculate(s: String): Int = {
    val stack = new java.util.Stack[String]()
    
    def eval(s: Seq[String]): String = {
      var ans: Long = 0
      var curr = true
      s.foreach {
        case "+" =>
          curr = true
        case "-" =>
          curr = false
        case r@_ =>
          if (curr) ans += r.toInt else ans -= r.toInt
      }
      ans.toString
    }
    
    var idx = 0
    while (idx < s.length) {
      if (s(idx) != ' ') {
        s(idx) match {
          case ')' =>
            val buffer = new scala.collection.mutable.ArrayBuffer[String]()
            while (!stack.isEmpty && stack.peek() != "(") buffer.insert(0, stack.pop())
            stack.pop()
            stack.push(eval(buffer))
          case '+' | '-' | '(' =>
            stack.push(s"${s(idx)}")
          case _ =>
            var item = ""
            while (idx < s.length && s(idx) != '+' && s(idx) != '-' && s(idx) != '(' && s(idx) != ')') {
              if (s(idx) != ' ') {
                item += s(idx)
              }
              idx += 1
            }
            idx -= 1
            stack.push(item)
        }
      }
      idx += 1
    }
    import scala.collection.JavaConversions._
    eval(stack).toInt
  }
}