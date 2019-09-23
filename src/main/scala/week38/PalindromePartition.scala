package week38

/**
  * 131. Palindrome Partitioning
  */
object PalindromePartition {
  def partition(s: String): List[List[String]] = {
    iterate(s, Nil)
  }
  
  private def iterate(s: String, mid: List[List[String]]): List[List[String]] = {
    if (s.length == 0) return mid
    if (s.length == 1) return mid.map(s :: _)
    var updated: List[List[String]] = Nil
    if (isPalindrome(s)) {
      updated = List(List(s))
    }
    (for (i <- 1 until s.length) yield {
      iterate(s.substring(0, i), mid).flatMap { outer =>
        iterate(s.substring(i, s.length), mid).map { inner =>
          outer ++ inner
        }
      }
    }).flatten.toList ++ updated
  }
  
  private def isPalindrome(s: String): Boolean = {
    var l = 0
    var r = s.length - 1
    var find = false
    while (l <= r && !find) {
      if (s(l) != s(r)) {
        find = true
      }
      l += 1
      r -= 1
    }
    !find
  }
}