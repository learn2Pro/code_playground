package category.string._700_800

/**
  * 709. To Lower Case
  */
object _709_ToLowerCase {
  def toLowerCase(str: String): String = {
    if (str.isEmpty) return str
    val chars = str.toCharArray
    val N = chars.length
    for (i <- 0 until N) {
      if (chars(i) >= 65 && chars(i) <= 90) chars(i) = (chars(i) + 32).toChar
    }
    new String(chars)
  }
}