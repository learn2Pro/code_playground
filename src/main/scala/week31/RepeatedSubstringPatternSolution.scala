package week31

/**
  * @author tang
  * @date 2019/08/03
  */
object RepeatedSubstringPatternSolution {
  def repeatedSubstringPattern(s: String): Boolean = {
    if (s == null || s.isEmpty) return true
    val len = s.length
    val kmp = new Array[Int](len)
    createKMP(s, kmp)
    val lastCommon = kmp(len - 1)
    if (lastCommon <= 0) {
      false
    } else {
      lastCommon % (len - lastCommon) == 0
    }
  }

  private def createKMP(pattern: String, kmp: Array[Int]): Unit = {
    val len = pattern.length
    for (idx <- 1 until len) {
      var last = kmp(idx - 1)
      while (last > 0 && pattern(last) != pattern(idx)) last = kmp(last - 1)
      if (pattern(last) == pattern(idx)) last += 1
      kmp(idx) = last
    }
  }
}
