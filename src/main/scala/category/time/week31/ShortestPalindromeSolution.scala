package category.time.week31

/**
  * @author tang
  * @date 2019/08/03
  */
object ShortestPalindromeSolution {

  def shortestPalindrome(s: String): String = {
    if (s == null || s.isEmpty) return s
    val string = s + '#' + new StringBuilder(s).reverse.toString()
    val kmp = new Array[Int](string.length)
    createKMP(string, kmp)
    genAnswer(kmp.last, s)
  }

  private def createKMP(pattern: String, kmp: Array[Int]): Unit = {
    val len = pattern.length
    for (idx <- 1 until len) {
      var last = kmp(idx - 1)
      while (last > 0 && pattern(last) != pattern(idx)) last = kmp(last - 1)
      if (pattern(last) == pattern(idx)) last += 1
      kmp(idx) = last
    }
  }

  //  def shortestPalindrome(s: String): String = {
  //    if (s == null || s.isEmpty) return s
  //    var pointer = s.length - 2
  //    var last = 1
  //    while (pointer >= 0) {
  //      last = nextPalindrome(last, pointer, s)
  //      pointer -= 1
  //    }
  //    genAnswer(last, s)
  //  }

  private def genAnswer(size: Int, s: String): String = {
    s.substring(size).reverse + s
  }

  /**
    * palindrome(n) =
    * if(start==n) palindrome(n-1)+1
    * else searchSubStr(start,n-1)
    *
    * @param last
    * @param start
    * @param s
    * @return
    */
  private def nextPalindrome(last: Int, start: Int, s: String): Int = {
    //start == start+last+1
    if (start + last + 1 < s.length && s(start) == s(start + last + 1)) {
      last + 2
    } else {
      var right = start + last
      while (right > start && s(right) != s(start)) right -= 1
      //搜索palindrome
      if (right == start) {
        1
      } else {
        while (!isPalindrome(s.substring(start, right + 1)) && right > start) right -= 1
        right - start + 1
      }
    }
  }


  private def isPalindrome(s: String): Boolean = {
    val len = s.length
    var left = 0
    var right = len - 1
    while (left < right && s(left) == s(right)) {
      left += 1
      right -= 1
    }
    if (left >= right) true
    else false
  }

}
