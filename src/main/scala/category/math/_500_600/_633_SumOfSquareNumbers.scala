package category.math._500_600

/**
  * 633. Sum of Square Numbers
  */
object _633_SumOfSquareNumbers {
  /*fermat theorem*/
  def judgeSquareSum(c: Int): Boolean = {
    var tmp = c
    var i = 2
    while (i * i <= tmp) {
      if (tmp % i == 0) {
        var cnt = 0
        while (tmp % i == 0) {
          cnt += 1
          tmp /= i
        }
        if (i % 4 == 3 && cnt % 2 != 0) return false
      }
      i += 1
    }
    tmp % 4 != 3
  }
}