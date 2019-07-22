package week29

import scala.collection.mutable.ArrayBuffer

/**
  * @author tang
  * @date 2019/07/20
  */
object ChunkedPalindromeSolution {

  def findPalindromeNum(s: String): Int = {
    if (s == null || s.length == 0) return 1
    search(s, 0, s.length - 1)
  }

  private def search(s: String, start: Int, end: Int): Int = {
    var left = start + 1
    var right = end
    val probNumAndLimit = new ArrayBuffer[(Int, Int, Int)]()
    while (left < right) {
      if (s.substring(start, left) == s.substring(right, end + 1)) {
        probNumAndLimit.append((1, left, right))
      }
      left += 1
      right -= 1
    }
    probNumAndLimit.foldLeft(1) {
      case (curr, (_, left, right)) =>
        curr + search(s, left, right)
    }
  }

}
