package category.math._500_600


/**
  * 592. Fraction Addition and Subtraction
  */
object _592_FractionAdditionAndSubtraction {
  
  import scala.collection.mutable.ArrayBuffer
  
  def fractionAddition(expression: String): String = {
    if (expression == null || expression.isEmpty) return ""
    var ops: Int = 1
    val numerators = new ArrayBuffer[Long]()
    val denominators = new ArrayBuffer[Long]()
    val N = expression.length
    
    /*1.extract*/
    def extract = {
      ops = if (expression(0) == '-') -1 else 1
      var last = if (expression(0) == '-') 1 else 0
      var curr = 1
      while (curr < N) {
        expression(curr) match {
          case '-' =>
            val tmp = expression.substring(last, curr).split("/")
            numerators += ops * tmp(0).toLong
            denominators += tmp(1).toLong
            ops = -1
            last = curr + 1
          case '+' =>
            val tmp = expression.substring(last, curr).split("/")
            numerators += ops * tmp(0).toLong
            denominators += tmp(1).toLong
            ops = 1
            last = curr + 1
          case _ =>
        }
        curr += 1
      }
      val tmp = expression.substring(last, curr).split("/")
      numerators += ops * tmp(0).toLong
      denominators += tmp(1).toLong
    }
    
    def gcd(m: Long, n: Long): Long = {
      if (n == 0) return m
      gcd(n, m % n)
    }
    
    extract
    val lcm = denominators.distinct.foldLeft(1L)((agg, curr) => agg * curr / gcd(agg, curr))
    var sum: Long = 0
    for (i <- denominators.indices) {
      sum += numerators(i) * (lcm / denominators(i))
    }
    if (sum == 0) return "0/1"
    val g = gcd(Math.abs(sum), lcm)
    (sum / g).toString + "/" + (lcm / g).toString
  }
}