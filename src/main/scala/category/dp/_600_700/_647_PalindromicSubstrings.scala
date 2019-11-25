package category.dp._600_700

/**
  * 647. Palindromic Substrings
  */
object _647_PalindromicSubstrings {
  def countSubstrings(s: String): Int = {
    if (s.isEmpty) return 1
    val A = new Array[Char](2 * s.length + 3)
    A(0) = '@'
    A(1) = '#'
    A(A.length - 1) = '$'
    var t = 2
    for (c <- s) {
      A(t) = c
      A(t + 1) = '#'
      t += 2
    }
    
    val Z = new Array[Int](A.length)
    var center = 0
    var right = 0
    for (i <- 1 until Z.length - 1) {
      if (i < right) Z(i) = Math.min(right - i, Z(2 * center - i))
      while (A(i + Z(i) + 1) == A(i - Z(i) - 1)) Z(i) += 1
      if (i + Z(i) > right) {
        center = i
        right = i + Z(i)
      }
    }
    var ans = 0
    for (v <- Z) {ans += (v + 1) / 2}
    ans
  }
  
  def countSubstringsV1(s: String): Int = {
    if (s.isEmpty) return 1
    val n = s.length
    val dp = Array.tabulate(n, n)((_, _) => 0)
    var ans = n
    for (j <- 0 until n) {
      dp(j)(j) = 1
      for (i <- Range(j - 1, -1, -1)) {
        if (s(i) == s(j)) {
          dp(i)(j) = if (i + 1 <= j - 1) {
            dp(i + 1)(j - 1)
          } else {
            1
          }
        }
        ans += dp(i)(j)
      }
    }
    ans
  }
}