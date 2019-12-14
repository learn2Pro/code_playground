package category.math._300_400

/**
  * 313. Super Ugly Number
  */
object _313_SuperUglyNumber {
  def nthSuperUglyNumber(n: Int, primes: Array[Int]): Int = {
    val arr = Array.tabulate(n)(_ => 1)
    val index = Array.tabulate(primes.length)(_ => 0)
    var i = 1
    while (i < n) {
      val (next, minIdx) = index.zip(primes).zipWithIndex.map { case ((idx, prime), where) =>
        arr(idx) * prime -> where
      }.minBy(_._1)
      index(minIdx) += 1
      if (next > arr(i - 1)) arr(i) = next
      else i -= 1
      i += 1
    }
    arr.last
  }
}