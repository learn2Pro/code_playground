package category.bitmanipulation

/**
  * 231. Power of Two
  */
object PowerOfTwo {
  def isPowerOfTwo(n: Int): Boolean = {
    (n & (n - 1)) == 0
  }
}