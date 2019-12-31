package category.string._500_600

/**
  * 557. Reverse Words in a String III
  */
object _557_ReverseWordsInAStringIII {
  def reverseWords(s: String): String = {
    if (s.isEmpty) return s
    s.split(' ').map(_.reverse).mkString(" ")
  }
}