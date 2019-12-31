package category.string._400_500


/**
  * 459. Repeated Substring Pattern
  */
object _459_RepeatedSubstringPattern {
  
  def repeatedSubstringPattern(s: String): Boolean = {
    if (s == null) return false
    val N = s.length
    (s + s).substring(1, 2 * N - 1).indexOf(s) != -1
  }
}