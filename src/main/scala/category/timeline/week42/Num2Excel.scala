package category.timeline.week42

/**
  * 168. Excel Sheet Column Title
  */
object Num2Excel {
  def convertToTitle(n: Int): String = {
    var tmp = n
    var ans = ""
    while (tmp > 0) {
      val remain = if (tmp % 26 == 0) {
        tmp -= 26
        26
      } else {
        tmp % 26
      }
      ans = (remain + 64).toChar + ans
      tmp /= 26
    }
    ans
  }
}