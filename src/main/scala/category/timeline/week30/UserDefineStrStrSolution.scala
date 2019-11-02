package category.timeline.week30

/**
  * kmp strstr()
  *
  * @author tang
  * @date 2019/07/27
  */
object UserDefineStrStrSolution {
  def strStr(haystack: String, needle: String): Int = {
    if (needle == null || needle.isEmpty) return 0
    if (haystack == null || haystack.isEmpty) return -1
    val kmp = new Array[Int](needle.length)
    for (i <- 1 until needle.length) {
      createKMP(needle.substring(0, i + 1), kmp)
    }
    var start = 0
    var lastMatch = 0
    while (start + needle.length <= haystack.length) {
      var curr = lastMatch
      while (curr < needle.length && needle(curr) == haystack(start + curr)) curr += 1
      if (curr == needle.length) return start
      else {
        val skip = if (curr > 0) {
          lastMatch = kmp(curr - 1)
          curr - lastMatch
        } else {
          //first unmatch skip=1 ,lastMatch=0
          lastMatch = 0
          1
        }
        start += skip
      }
    }
    -1
  }

  /**
    * kmp(n) means prefix == suffix max length of substr(0,n)
    * exclude the self
    *
    * kmp(n) = kmp(n-1)+kmp(substr.slice(kmp(n-1),n))
    *
    * @param pattern
    * @return
    */
  private def createKMP(pattern: String, kmp: Array[Int]): Unit = {
    val n = pattern.length - 1
    val last = kmp(n - 1)
    //kmp(n) = kmp(n-1) + 1
    if (pattern(n) == pattern(last)) {
      kmp(n) = last + 1
    } else {
      kmp(n) = searchCommon(pattern, pattern.length - last)
    }
  }

  private def searchCommon(s: String, start: Int): Int = {
    var i = start
    while (i < s.length) {
      while (i < s.length && s(i) != s(0)) i += 1
      var j = i + 1
      while (j < s.length && s(j) == s(j - i)) j += 1
      if (j == s.length) return j - i
      i += 1
    }
    0
  }
}
