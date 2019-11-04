package category.array



/**
  * 670. Maximum Swap
  */
object MaximumSwap {
  import scala.annotation.tailrec
  def maximumSwap(num: Int): Int = {
    
    @tailrec
    def backTrack(str: String, last: String): String = {
      if (str.isEmpty) return last
      val maxChar = str.max
      if (str(0) != maxChar) {
        val chars = str.toCharArray
        val lastIndex = chars.lastIndexOf(maxChar)
        val tmp = chars(0)
        chars(0) = chars(lastIndex)
        chars(lastIndex) = tmp
        return last + chars.mkString
      }
      backTrack(str.substring(1), last + str.substring(0, 1))
    }
    
    backTrack(num.toString, "").toInt
  }
}