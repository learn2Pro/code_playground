package category.dp._300_400


/**
  * 357. Count Numbers with Unique Digits
  */
object _357_CountNumbersWithUniqueDigits {
  
  import scala.annotation.tailrec
  
  
  def countNumbersWithUniqueDigits(n: Int): Int = {
    
    @tailrec
    def backTrack(n: Int, last: Int): Int = {
      if (n == 1) return 10 + last
      var appendix = 9
      for (i <- 1 until n) {
        appendix *= (10 - i)
      }
      backTrack(n - 1, appendix + last)
    }
    
    if (n == 0) return 1
    backTrack(n, 0)
    
  }
}