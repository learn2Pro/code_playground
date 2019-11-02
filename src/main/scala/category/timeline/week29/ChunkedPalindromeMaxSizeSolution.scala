package category.timeline.week29


/**
  * @author tang
  * @date 2019/07/20
  */
object ChunkedPalindromeMaxSizeSolution {

  def findPalindromeMaxSize(s: String): Int = {
    if (s == null || s.length == 0) return 1
    var currLeft = 0
    var currRight = s.length
    var p0 = currLeft + 1
    var p1 = currRight - 1
    var maxLen = 1
    while (p0 <= p1) {
      if (s.substring(currLeft, p0) == s.substring(p1, currRight)) {
        maxLen += 2
        if (p0 == p1) maxLen -= 1
        currLeft = p0
        currRight = p1
      }
      p0 += 1
      p1 -= 1
    }
    maxLen
  }

}
