package category.dp._500_600

/**
  * 552. Student Attendance Record II
  */
object _552_StudentAttendanceRecordII {
  def checkRecord(n: Int): Int = {
    if (n == 1) return 3
    if (n == 2) return 8
    if (n == 3) return 19
    val M = 1000000007
    val dp = Array.tabulate[Long](n, 3)((_, _) => 0L)
    dp(0)(0) = 1
    dp(0)(1) = 1
    dp(0)(2) = 1
    dp(1)(0) = 3
    dp(1)(1) = 2
    dp(1)(2) = 3
    dp(2)(0) = 8
    dp(2)(1) = 4
    dp(2)(2) = 7
    for (i <- 3 until n) {
      dp(i)(0) = (dp(i - 1)(0) % M + dp(i - 1)(1) % M + dp(i - 1)(2) % M) % M
      dp(i)(1) = (dp(i - 1)(1) % M + dp(i - 2)(1) % M + dp(i - 3)(1) % M) % M
      dp(i)(2) = (dp(i - 1)(0) % M + dp(i - 1)(1) % M + dp(i - 2)(0) % M + dp(i - 2)(1) % M) % M
    }
    ((dp(n - 1)(0) % M + dp(n - 1)(1) % M + dp(n - 1)(2) % M) % M).toInt
  }
  
  def checkRecordV1(n: Int): Int = {
    if (n == 0) return 0
    if (n == 1) return 3
    val dp = Array.tabulate(2, 6)((_, _) => 0)
    /*0.ALL,1.AL,2.A,3.LL,4.L,5.O*/
    dp(0)(2) = 1
    dp(0)(4) = 1
    dp(0)(5) = 1
    var ans = 0
    for (i <- 1 until n) {
      val last = (i - 1) % 2
      val curr = i % 2
      /*ALL*/
      dp(curr)(0) = dp(last)(1)
      if (i == n - 1) ans += dp(curr)(0)
      /*AL*/
      dp(curr)(1) = dp(last)(2)
      if (i == n - 1) ans += dp(curr)(1)
      /*A*/
      dp(curr)(2) = dp(last)(0) + dp(last)(1) + dp(last)(2) + dp(last)(3) + dp(last)(4) + dp(last)(5)
      if (i == n - 1) ans += dp(curr)(2)
      /*LL*/
      dp(curr)(3) = dp(last)(4)
      if (i == n - 1) ans += dp(curr)(3)
      /*L*/
      dp(curr)(4) = dp(last)(5)
      if (i == n - 1) ans += dp(curr)(4)
      /*O*/
      dp(curr)(5) = dp(last)(3) + dp(last)(4) + dp(last)(5)
      if (i == n - 1) ans += dp(curr)(5)
    }
    ans
  }
}