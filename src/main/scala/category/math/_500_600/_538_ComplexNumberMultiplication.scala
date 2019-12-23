package category.math._500_600

/**
  * 537. Complex Number Multiplication
  */
object _538_ComplexNumberMultiplication {
  def complexNumberMultiply(a: String, b: String): String = {
    def extract(input: String): (Int, Int) = {
      val arr = input.split("\\+")
      (arr(0).toInt, arr(1).substring(0, arr(1).length - 1).toInt)
    }
    
    /* (a0+b0i)*(a1+b1*i) = (a0*a1-b0*b1) + (a1b0*i + a0b1*i) */
    val (a0, b0) = extract(a)
    val (a1, b1) = extract(b)
    val sb = new StringBuilder
    sb.append(a0 * a1 - b0 * b1)
    sb.append("+")
    sb.append(a1 * b0 + a0 * b1)
    sb.append("i")
    sb.toString()
  }
}