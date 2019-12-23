package category.math._500_600

/**
  * 640. Solve the Equation
  */
object _640_SolveTheEquation {
  def solveEquation(equation: String): String = {
    def extract(exp: String) = {
      var coe = 0
      var constant = 0
      val N = exp.length
      var i = 1
      var ops = if (exp(0) == '-') -1 else 1
      var last = if (exp(0) == '-') 1 else 0
      
      def innerSelect(s: Int, e: Int) = {
        val tmp = exp.substring(s, e)
        if (tmp == "x") {
          coe += ops
        } else if (tmp.contains("x")) {
          coe += ops * tmp.substring(0, tmp.length - 1).toInt
        } else {
          constant += ops * tmp.toInt
        }
      }
      
      while (i < N) {
        exp(i) match {
          case '+' | '-' =>
            innerSelect(last, i)
            last = i + 1
            ops = if (exp(i) == '-') -1 else 1
          case _ =>
        }
        i += 1
      }
      innerSelect(last, i)
      coe -> constant
    }
    
    val splits = equation.split("=")
    val (l0, l1) = extract(splits(0))
    val (r0, r1) = extract(splits(1))
    val (coe, constant) = (l0 - r0, r1 - l1)
    if (coe == 0 && constant == 0) "Infinite solutions"
    else if (coe == 0 && constant != 0) "No solution"
    else "x=" + constant / coe
  }
}