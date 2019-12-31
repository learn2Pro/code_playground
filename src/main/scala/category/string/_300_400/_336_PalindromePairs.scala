package category.string._300_400

/**
  * 336. Palindrome Pairs
  */
object _336_PalindromePairs {
  def palindromePairs(words: Array[String]): List[List[Int]] = {
    if (words.isEmpty) return Nil
    val wordsHolder = words.zipWithIndex.toMap
    
    def findPair(input: String, idx: Int): List[List[Int]] = {
      var ans: List[List[Int]] = Nil
      val N = input.length
      val reverse = input.reverse
      if (reverse == input) {
        if (wordsHolder.contains("") && idx != wordsHolder("")) {
          ans ::= List(idx, wordsHolder(""))
          ans ::= List(wordsHolder(""), idx)
        }
      } else if (wordsHolder.contains(reverse)) {
        ans ::= List(idx, wordsHolder(reverse))
      }
      /*backward*/
      for (l <- 1 until N if isPalin(input, l, N - 1)) {
        val r = input.substring(0, l).reverse
        if (wordsHolder.contains(r)) ans ::= List(idx, wordsHolder(r))
      }
      /*forward*/
      for (r <- Range(N - 2, -1, -1) if isPalin(input, 0, r)) {
        val reverse = input.substring(r + 1, N).reverse
        if (wordsHolder.contains(reverse)) ans ::= List(wordsHolder(reverse), idx)
      }
      ans
    }
    
    def isPalin(input: String, start: Int, end: Int): Boolean = {
      var lo = start
      var hi = end
      while (lo < hi) {
        if (input(lo) != input(hi)) return false
        lo += 1
        hi -= 1
      }
      true
    }
    
    var ans: List[List[Int]] = Nil
    var idx = 0
    words.foreach { word =>
      ans ++= findPair(word, idx)
      idx += 1
    }
    ans
  }
}