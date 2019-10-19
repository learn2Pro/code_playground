package week40



/**
  * 150. Evaluate Reverse Polish Notation
  */
object RPNEvaluator {
  
  private val Operators: Set[String] = Set("+", "-", "*", "/")
  
  import java.util
  def evalRPN(tokens: Array[String]): Int = {
    if (tokens == null || tokens.isEmpty) return 0
    val rpn = new util.Stack[String]
    
    def op(operator: String): Int = {
      val right = rpn.pop()
      val left = rpn.pop()
      operator match {
        case "+" =>
          left.toInt + right.toInt
        case "-" =>
          left.toInt - right.toInt
        case "*" =>
          left.toInt * right.toInt
        case "/" =>
          left.toInt / right.toInt
      }
    }
    
    tokens.foreach { token =>
      if (Operators.contains(token)) {
        rpn.push(op(token).toString)
      } else {
        rpn.push(token)
      }
    }
    rpn.pop().toInt
  }
}