package category.twopointer

/**
  * 424. Longest Repeating Character Replacement
  */
object _424_Solution {
  def characterReplacement(s: String, k: Int): Int = {
    var p0, p1, maxCnt, maxLength = 0
    val bucket = new Array[Int](26)
    while (p1 < s.length) {
      maxCnt = Math.max(maxCnt, {bucket(s(p1) - 'A') += 1; bucket(s(p1) - 'A')})
      if (p1 - p0 + 1 - maxCnt > k) {bucket(s(p0) - 'A') -= 1; p0 += 1}
      maxLength = Math.max(maxLength, p1 - p0 + 1)
      p1 += 1
    }
    maxLength
  }
  
  //  def characterReplacement(s: String, k: Int): Int = {
  //    var p0, p1, max = 0
  //    while (p0 < s.length) {
  //      var remain = k
  //      val base = s(p0)
  //      val start = p0
  //      while (p0 < s.length && s(p0) == base) p0 += 1
  //      p1 = p0
  //      while (remain >= 0 && p1 < s.length) {
  //        if (s(p1) != base) remain -= 1
  //        p1 += 1
  //      }
  //      max = Math.max(max, p1 + remain - start)
  //    }
  //    Math.min(s.length, max)
  //  }
}