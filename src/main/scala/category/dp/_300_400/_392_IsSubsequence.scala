package category.dp._300_400

/**
  * 392. Is Subsequence
  */
object _392_IsSubsequence {
  def isSubsequence(s: String, t: String): Boolean = {
    var lastOccur = -1
    for (letter <- s) {
      val index = t.indexOf(letter, lastOccur)
      if (index == -1) return false
      else lastOccur = index + 1
    }
    true
  }
  
  def isSubsequenceV1(s: String, t: String): Boolean = {
    val holder = t.zipWithIndex.map { case (c, i) =>
      c -> i
    }.groupBy(_._1).map { inner =>
      inner._1 -> inner._2.map(_._2)
    }
    
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
}