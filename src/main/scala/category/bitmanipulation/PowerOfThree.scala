package category.bitmanipulation

object PowerOfThree {
  def isPowerOfThree(num: Int): Boolean = {
    num > 0 && 1162261467 % num == 0
  }
}