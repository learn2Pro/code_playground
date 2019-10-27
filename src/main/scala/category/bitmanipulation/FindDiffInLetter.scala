package category.bitmanipulation

/**
  * 389. Find the Difference
  */
object FindDiffInLetter {
  def findTheDifference(s: String, t: String): Char = {
    def bitSet(word: String): Int = {
      word.map { c =>
        1 << (c - 'a')
      }.reduce(_ ^ _)
    }
    
    if (s.isEmpty) return t(0)
    ('a' + java.lang.Integer.numberOfTrailingZeros(bitSet(s) ^ bitSet(t))).toChar
  }
}