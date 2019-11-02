package category.timeline.week28

/**
  * @author tang
  * @date 2019/07/14
  */
object GenerateParenthesesSolution {

  def generateParenthesis(n: Int): List[String] = {
    val stack = new java.util.Stack[Char]()
    generate(stack, n, n).toList
  }

  def generate(input: java.util.Stack[Char], left: Int, right: Int): Array[String] = {
    //exit
    if (left == 0 && right == 1) {
      Array(")")
    }
    //left ==0
    else if (left == 0) {
      val stack = input.clone().asInstanceOf[java.util.Stack[Char]]
      stack.pop()
      generate(stack, left, right - 1).map {
        sub =>
          ")" + sub
      }
    }
    //well-formed consideration
    else if (input.isEmpty) {
      val stack = input.clone().asInstanceOf[java.util.Stack[Char]]
      stack.push('(')
      generate(stack, left - 1, right).map {
        sub =>
          "(" + sub
      }
    } else {
      Array("(", ")").flatMap {
        case "(" =>
          val stack = input.clone().asInstanceOf[java.util.Stack[Char]]
          stack.push('(')
          generate(stack, left - 1, right).map {
            sub =>
              "(" + sub
          }
        case ")" =>
          val stack = input.clone().asInstanceOf[java.util.Stack[Char]]
          stack.pop()
          generate(stack, left, right - 1).map {
            sub =>
              ")" + sub
          }
      }
    }
  }

}
