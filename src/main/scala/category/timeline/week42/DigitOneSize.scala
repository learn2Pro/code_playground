package category.timeline.week42


/**
  * 233. Number of Digit One
  */
object DigitOneSize {
  
  def countDigitOne(n: Int): Int = {
    if (n < 0) return 0
    
    def run(s: String): Int = {
      if (s.length == 0) return 0
      /* 0-x99 */
      var part0 = radixCount(s.substring(0, 1).toInt, s.length - 1)
      /*0-1xxx*/
      if (s(0) == '1') part0 += (s.toInt - Math.pow(10, s.length - 1).toInt)
      part0 + run(s.substring(1))
    }
    
    run(n.toString)
  }
  
  def radixCount(multi: Int, radix: Int): Int = {
    if (multi == 0) return 0
    val previous = multi * fn(radix)
    if (multi == 1) previous + 1
    else previous + Math.pow(10, radix).toInt
  }
  
  /**
    * n=1 0-9 1
    * n=2 0-99 20
    * n=3 0-999 300
    * n=4 0-9999 4000
    *
    * @param n the radix
    */
  def fn(n: Int): Int = {
    if (n == 0) return 0
    if (n == 1) return 1
    fn(n - 1) * 10 + Math.pow(10, n - 1).toInt
  }
}