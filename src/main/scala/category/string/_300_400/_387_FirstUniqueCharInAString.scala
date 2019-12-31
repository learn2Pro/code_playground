package category.string._300_400

/**
  * 387. First Unique Character in a String
  */
object _387_FirstUniqueCharInAString {
  def firstUniqChar(s: String): Int = {
    if (s.isEmpty) return -1
    val N = s.length
    val chars = new Array[Int](26)
    val orders = Array.tabulate(26)(_ => Int.MaxValue)
    var idx = 0
    s.foreach { c =>
      chars(c - 'a') += 1
      orders(c - 'a') = Math.min(idx, orders(c - 'a'))
      idx += 1
    }
    var ans = N
    for (i <- 0 until 26) {
      if (chars(i) == 1) ans = Math.min(ans, orders(i))
    }
    if (ans == N) -1 else ans
  }
}