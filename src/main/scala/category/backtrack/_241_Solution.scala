package category.backtrack

/**
  * 241. Different Ways to Add Parentheses
  */
object _241_Solution {
  def diffWaysToCompute(input: String): List[Int] = {
    if (input.isEmpty) return Nil
    if (!input.contains('+') && !input.contains('-') && !input.contains('*')) return List(input.toInt)
    var ans: List[Int] = Nil
    for (i <- 0 until input.length) {
      if (input(i) == '+' || input(i) == '-' || input(i) == '*') {
        val left = diffWaysToCompute(input.substring(0, i))
        val right = diffWaysToCompute(input.substring(i + 1))
        left.foreach { l =>
          right.foreach { r =>
            input(i) match {
              case '+' =>
                ans ::= l + r
              case '-' =>
                ans ::= l - r
              case '*' =>
                ans ::= l * r
            }
          }
        }
      }
    }
    ans
  }
}