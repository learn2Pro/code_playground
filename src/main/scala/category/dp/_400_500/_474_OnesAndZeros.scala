package category.dp._400_500

/**
  * 474. Ones and Zeroes
  */
object _474_OnesAndZeros {
  def findMaxForm(strs: Array[String], m: Int, n: Int): Int = {
    val dp = Array.tabulate(m + 1, n + 1)((_, _) => 0)
    strs.foreach { str =>
      var one, zero = 0
      str.foreach { c =>
        if (c == '1') one += 1
        else zero += 1
      }
      for (i <- Range(m, zero - 1, -1))
        for (j <- Range(n, one - 1, -1)) {
          dp(i)(j) = Math.max(dp(i - zero)(j - one) + 1, dp(i)(j))
        }
    }
    dp(m)(n)
  }
  
  def findMaxFormV1(strs: Array[String], m: Int, n: Int): Int = {
    
    case class OneAndZero(one: Int, zero: Int) {
      def sum(other: OneAndZero): OneAndZero = {
        OneAndZero(one + other.one, zero + other.zero)
      }
      
      def below = {
        one <= n && zero <= m
      }
      
      def equal = {
        one == n && zero == m
      }
      
      def <(other: OneAndZero): Boolean = {
        this.one + this.zero < other.one + other.zero
      }
    }
    
    def of(s: String): OneAndZero = {
      var one, zero = 0
      s.foreach { c =>
        if (c == '1') one += 1
        else zero += 1
      }
      OneAndZero(one, zero)
    }
    
    val arr = strs.map(of).filter(_.below)
    val dp = Array.tabulate[(OneAndZero, Int)](arr.length)(_ => null)
    if (arr.isEmpty) return 0
    dp(0) = (arr(0), 1)
    var ans = 0
    for (i <- 1 until arr.length) {
      dp(i) = (arr(i), 1)
      for (k <- Range(i - 1, -1, -1)) {
        val merge = arr(i).sum(dp(k)._1)
        val len = dp(k)._2 + 1
        if (merge.below && (dp(i) == null || len > dp(i)._2 || (len == dp(i)._2 && merge < dp(i)._1))) {
          dp(i) = (merge, len)
        }
        ans = Math.max(ans, dp(i)._2)
      }
    }
    ans
  }
}