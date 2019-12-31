package category.string._500_600

/**
  * 541. Reverse String II
  */
object _541_ReverseStringII {
  def reverseStr(s: String, k: Int): String = {
    val chars = s.toCharArray
    
    def reverseArr(start: Int, end: Int): Unit = {
      var lo = start
      var hi = end
      while (lo < hi) {
        val tmp = chars(lo)
        chars(lo) = chars(hi)
        chars(hi) = tmp
        lo += 1
        hi -= 1
      }
    }
    
    var reverse: Boolean = false
    var i = 0
    while (i < chars.length) {
      if (i % k == 0) reverse = !reverse
      if (i % k == k - 1 && reverse) {
        reverseArr(i - i % k, i)
      }
      i += 1
    }
    if (reverse && (i - 1) % k != k - 1) {
      reverseArr(i - (i - 1) % k - 1, i - 1)
    }
    new String(chars)
  }
}