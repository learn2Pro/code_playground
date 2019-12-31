package category.string._500_600

/**
  * 564. Find the Closest Palindrome
  */
object _563_FindTheClosestPalin {
  def nearestPalindromic(n: String): String = {
    val N = n.length
    val base = Math.pow(10, N / 2).toLong
    val ans = n.toLong
    
    def mirror(input: Long): Long = {
      val chars = input.toString.toCharArray
      var lo = 0
      var hi = chars.length - 1
      while (lo < hi) {
        chars(hi) = chars(lo)
        lo += 1
        hi -= 1
      }
      new String(chars).toLong
    }
    
    val noChange = mirror(ans)
    var addOne = mirror((ans / base) * base + base)
    var minusOne = mirror((ans / base) * base - 1)
    if (noChange > ans) addOne = Math.min(addOne, noChange)
    if (noChange < ans) minusOne = Math.max(minusOne, noChange)
    if (addOne - ans >= ans - minusOne) minusOne.toString else addOne.toString
    
  }
  
  def nearestPalindromicV1(n: String): String = {
    val N = n.length
    
    def midSubPalin(): Int = {
      var mid = 0
      var lo = 0
      var hi = N - 1
      while (lo <= hi) {
        if (n(lo) == n(hi)) mid += (if (lo == hi) 1 else 2)
        else mid = 0
        lo += 1
        hi -= 1
      }
      mid
    }
    
    if (N == 1) return Math.min(Math.abs(n.toInt - 1), n.toInt + 1).toString
    val mid = midSubPalin()
    val start = (N - mid) / 2
    val end = (N - mid) / 2 + mid
    val part0 = n.substring(0, start)
    val part1 = n.substring(end, N)
    val diff = Math.abs(part0.toInt - part1.toInt)
    if (mid == 1) {
      if (n(start) > '0' && Math.abs(("1" + part1).toInt - part0.toInt) < diff) {
        part0 + (n(start) - '0' - 1) + part0.reverse
      } else if (n(start) == '0' && Math.abs(("1" + part1).toInt - part0.toInt) - 1 < diff) {
        (part0.toInt - 1).toString + "9" + (part0.toInt - 1).toString.reverse
      } else {
        part0 + n(start) + part0.reverse
      }
    } else {
      part0 + n.substring(start, end) + part0.reverse
    }
    
    
  }
}