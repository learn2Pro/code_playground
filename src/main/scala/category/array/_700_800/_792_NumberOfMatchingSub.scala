package category.array._700_800

/**
  * 792. Number of Matching Subsequences
  */
object _792_NumberOfMatchingSub {
  
  def numMatchingSubseq(S: String, words: Array[String]): Int = {
    def isSubsequence(s: String, t: String): Boolean = {
      var lastOccur = -1
      for (letter <- s) {
        val index = t.indexOf(letter, lastOccur)
        if (index == -1) return false
        else lastOccur = index + 1
      }
      true
    }
    val holder = S.zipWithIndex.map { case (c, i) =>
      c -> i
    }.groupBy(_._1).map { inner =>
      inner._1 -> inner._2.map(_._2)
    }
  
    def isSubsequenceV1(s: String): Boolean = {
      
      def binarySearch(i: Int, seq: Seq[Int]): Int = {
        var lo = 0
        var hi = seq.length - 1
        while (lo < hi) {
          val mid = (lo + hi) >>> 1
          if (i > seq(mid)) lo = mid + 1
          else hi = mid
        }
        if (hi == seq.length - 1 && seq(hi) < i) -1
        else lo
      }
    
      var idx = 0
      s.foreach { c =>
        val seq = holder.getOrElse(c, return false)
      
        val location = binarySearch(idx, seq)
        if (location < 0) return false
        idx = seq(location) + 1
      }
      true
    
    }
    
    var ans = 0
    words.foreach { word =>
      if(isSubsequenceV1(word)) ans+=1
    }
    ans
  }
}