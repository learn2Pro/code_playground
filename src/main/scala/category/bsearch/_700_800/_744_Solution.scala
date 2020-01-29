package category.bsearch._700_800

/**
  * 744. Find Smallest Letter Greater Than Target
  */
object _744_Solution {
  def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
    var lo = 0
    var hi = letters.length
    while (lo < hi) {
      val mid = (lo + hi) >>> 1
      if (target >= letters(mid)) lo = mid + 1
      else hi = mid
    }
    letters(lo % letters.length)
  }
}