package category.string._700_800

/**
  * 736. Parse Lisp Expression
  */
object _736_ParseLispExpression {
  
  def min(i: Int, j: Int): Int = {
    if (i == -1) return j
    if (j == -1) return i
    Math.min(i, j)
  }
  
  trait Op {
    def stack: java.util.Stack[String]
    
    def eval(inputs: Seq[String]): Unit
    
    def isVariable(s: String): Boolean = {
      try {
        s.toInt
        true
      } catch {
        case e: NumberFormatException =>
          false
      }
    }
    
    def parse(s: String): Int = {
      s.toInt
    }
  }
  
  case class Add(stack: java.util.Stack[String]) extends Op {
    override def eval(inputs: Seq[String]): Unit = {
      val l = inputs(0)
      val r = inputs(1)
      if (isVariable(l) && isVariable(r)) {
        stack.push((parse(l) + parse(r)).toString)
      } else {
        stack.push("(" + l + "+" + r + ")")
      }
    }
  }
  
  case class Multi(stack: java.util.Stack[String]) extends Op {
    override def eval(inputs: Seq[String]): Unit = {
      val l = inputs(0)
      val r = inputs(1)
      if (isVariable(l) && isVariable(r)) {
        stack.push((parse(l) * parse(r)).toString)
      } else {
        stack.push("(" + l + "*" + r + ")")
      }
    }
  }
  
  case class Let(stack: java.util.Stack[String]) extends Op {
    override def eval(inputs: Seq[String]): Unit = {
      val variables = new java.util.HashMap[String, String]()
      val calcStack = new java.util.Stack[String]()
      
      def fetchReady(s: String): Boolean = {
        variables.containsKey(s) || isVariable(s)
      }
      
      def fetch(s: String): String = {
        if (variables.containsKey(s)) variables.get(s) else s
      }
      
      def calc0(exp: String): String = {
        var i = 0
        
        
        while (i < exp.length) {
          exp(i) match {
            case '(' | '+' | '*' =>
              calcStack.push(exp(i).toString)
            case ')' =>
              var inputs: List[String] = Nil
              while (!calcStack.isEmpty && calcStack.peek() != "(") inputs ::= calcStack.pop()
              calcStack.pop()
              val l = if (fetchReady(inputs(0))) fetch(inputs(0)).toString else inputs(0)
              val r = if (fetchReady(inputs(2))) fetch(inputs(2)).toString else inputs(2)
              /*calc*/
              if (inputs(1) == "+") Add(calcStack).eval(Seq(l, r))
              else Multi(calcStack).eval(Seq(l, r))
            case _ =>
              val end = min(exp.indexOf(")", i), min(exp.indexOf("+", i), exp.indexOf("*", i)))
              calcStack.push(exp.substring(i, end))
              i = end - 1
          }
          i += 1
        }
        calcStack.pop()
      }
      
      def calc(s: String): String = {
        if (s.contains("+") || s.contains("*")) {
          calc0(s)
        } else {
          fetch(s)
        }
      }
      
      inputs.grouped(2).foreach { pair =>
        if (pair.size == 1) stack.push(calc(pair.head))
        else {
          val v = calc(pair(1))
          variables.put(pair.head, v)
        }
      }
    }
  }
  
  def evaluate(expression: String): Int = {
    val stack = new java.util.Stack[String]()
    var i = 0
    val N = expression.length
    
    
    while (i < N) {
      if (expression(i) == ' ') {}
      else if (expression(i) == '(') stack.push(expression(i).toString)
      else if (expression(i) == ')') {
        var inputs: List[String] = Nil
        while (!stack.isEmpty && stack.peek() != "(") inputs ::= stack.pop()
        if (stack.peek() == "(") stack.pop()
        inputs.head match {
          case "add" =>
            Add(stack).eval(inputs.tail)
          case "mult" =>
            Multi(stack).eval(inputs.tail)
          case "let" =>
            Let(stack).eval(inputs.tail)
        }
      } else {
        val end = min(expression.indexOf(' ', i), expression.indexOf(')', i))
        stack.push(expression.substring(i, end))
        i = if (expression(end) == ' ') end else end - 1
      }
      i += 1
    }
    stack.pop().toInt
  }
}