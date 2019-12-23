package category.math._400_500

/**
  * 483. Smallest Good Base
  */
object _483_SmallestGoodBase {
  def smallestGoodBase(n: String): String = {
    val N = n.toLong
    val upper = (Math.log(N) / Math.log(2)).toInt
    for (m <- Range(upper, 1, -1)) {
      /*k+1 > m-th root of n > k*/
      val k = Math.pow(N, 1.0 / m).toInt
      /*(k^(m+1) - 1)/(k - 1) = n*/
      if ((BigDecimal(k).pow(m + 1) - 1) / (k - 1) == N) return String.valueOf(k)
    }
    String.valueOf(N - 1)
  }
}