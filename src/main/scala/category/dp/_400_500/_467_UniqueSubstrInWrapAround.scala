package category.dp._400_500


/**
  * 467. Unique Substrings in Wraparound String
  */
object _467_UniqueSubstrInWrapAround {
  
  
  def findSubstringInWraproundString(p: String): Int = {
    if (p.isEmpty) return 0
    val n = p.length
    val ans = new Array[Int](26)
    ans(p(0) - 'a') = 1
    var state = 1
    for (i <- 1 until n) {
      val current = p(i) - 'a'
      if ((p(i) + 26 - p(i - 1)) % 26 == 1) {
        state += 1
      } else {
        state = 1
      }
      ans(current) = Math.max(ans(current), state)
    }
    ans.sum
  }
  
}