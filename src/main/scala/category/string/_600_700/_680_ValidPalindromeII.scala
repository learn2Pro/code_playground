package category.string._600_700

/**
  * 680. Valid Palindrome II
  */
object _680_ValidPalindromeII {
  
  def validPalindrome(s: String): Boolean = {
    val N = s.length
    
    def isPalinInRange(start: Int, end: Int, notMatch: Int): Boolean = {
      if (notMatch > 1) return false
      var lo = start
      var hi = end
      while (lo < hi) {
        if (s(lo) != s(hi)) {
          return isPalinInRange(lo + 1, hi, notMatch + 1) || isPalinInRange(lo, hi - 1, notMatch + 1)
        }
        lo += 1
        hi -= 1
      }
      true
    }
    
    isPalinInRange(0, N - 1, 0)
  }
}