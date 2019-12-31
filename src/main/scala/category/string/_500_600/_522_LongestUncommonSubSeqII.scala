package category.string._500_600

/**
  * 522. Longest Uncommon Subsequence II
  */
object _522_LongestUncommonSubSeqII {
  def findLUSlength(strs: Array[String]): Int = {
    /**
      * s0<s1
      */
    def isSubSeq(s0: String, s1: String): Boolean = {
      var i, j = 0
      while (i < s0.length && j < s1.length) {
        while (j < s1.length && s1(j) != s0(i)) j += 1
        if (j != s1.length) {
          i += 1
          j += 1
        }
      }
      i == s0.length
    }
    
    val sorted = strs.sorted(new Ordering[String] {
      override def compare(x: String, y: String): Int = if (x.length == y.length) {
        x.compareTo(y)
      } else {
        x.length - y.length
      }
    })
    var ans = -1
    for (i <- sorted.indices) {
      var earlyStop = false
      if (i >= 1 && sorted(i) == sorted(i - 1)) earlyStop = true
      for (j <- i + 1 until sorted.length if !earlyStop) {
        if (isSubSeq(sorted(i), sorted(j))) earlyStop = true
      }
      if (!earlyStop) {
        ans = Math.max(ans, sorted(i).length)
      }
    }
    ans
  }
}