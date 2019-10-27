package category.bitmanipulation

/**
  * 461. Hamming Distance
  */
object HammingDistance {
  def hammingDistance(x: Int, y: Int): Int = {
    java.lang.Integer.bitCount(x ^ y)
  }
}