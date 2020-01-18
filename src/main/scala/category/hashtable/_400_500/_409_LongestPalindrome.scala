package category.hashtable._400_500

/**
  * 409. Longest Palindrome
  */
object _409_LongestPalindrome {
  def longestPalindrome(s: String): Int = {
    val lst = s.toCharArray.groupBy(identity).mapValues(_.length)
    val N = s.length
    var ans = 0
    lst.foreach { case (c, s) =>
      if (s % 2 == 0) {
        ans += s
      } else {
        ans += (s - 1)
      }
    }
    val odd = if (N - ans > 0) 1 else 0
    ans + odd
  }
}