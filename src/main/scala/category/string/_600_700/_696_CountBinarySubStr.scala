package category.string._600_700

/**
  * 696. Count Binary Substrings
  */
object _696_CountBinarySubStr {
  def countBinarySubstrings(s: String): Int = {
    val N = s.length
    
    def extract(start: Int, reverseSize: Int, c: Char): Int = {
      var i = start
      var size = 0
      val reverse = if (c == '1') '0' else '1'
      while (i < N && s(i) == reverse) {
        i += 1
        size += 1
      }
      size
    }
    
    var idx, ans, initial = 0
    while (idx < N && s(idx) == s(0)) {
      initial += 1
      idx += 1
    }
    while (idx < N) {
      val size = extract(idx, initial, s(idx - 1))
      ans += Math.min(initial, size)
      initial = size
      idx += size
    }
    ans
  }
  
  def countBinarySubstringsV1(s: String): Int = {
    val N = s.length
    var ans = 0
    val dp = Array.tabulate(N, N)((_, _) => 0)
    for (i <- Range(N - 2, -1, -1)) {
      if ((s(i) == '0' && s(i + 1) == '1') || (s(i) == '1' && s(i + 1) == '0')) {
        dp(i)(i + 1) = 1
        ans += 1
      }
      for (j <- i + 3 until N if dp(i + 1)(j - 1) == 1 && s(i + 1) == s(i) && s(j - 1) == s(j)) {
        dp(i)(j) = 1
        ans += 1
      }
    }
    ans
  }
}