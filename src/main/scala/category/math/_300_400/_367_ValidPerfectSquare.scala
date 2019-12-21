package category.math._300_400

/**
  * 367. Valid Perfect Square
  */
object _367_ValidPerfectSquare {
  def isPerfectSquare(num: Int): Boolean = {
    val sqrt = Math.sqrt(num).toInt
    sqrt * sqrt == num
  }
}