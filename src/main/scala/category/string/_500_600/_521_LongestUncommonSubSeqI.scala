package category.string._500_600

/**
  * 521. Longest Uncommon Subsequence I
  */
object _521_LongestUncommonSubSeqI {
  def findLUSlength(a: String, b: String): Int = {
    if (a == b) return -1
    Math.max(a.length, b.length)
  }
}