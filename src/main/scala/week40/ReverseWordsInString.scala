package week40

/**
  * 151. Reverse Words in a String
  */
object ReverseWordsInString {
  def reverseWords(s: String): String = {
    if (s == null || s.isEmpty) return s
    s.trim.split("(\u0020)+").reverse.mkString(" ")
  }
}