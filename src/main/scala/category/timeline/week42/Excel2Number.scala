package category.timeline.week42

/**
  * 171. Excel Sheet Column Number
  */
object Excel2Number {
  def titleToNumber(s: String): Int = {
    var sum = 0
    s.foldRight(1) { case (c, radix) =>
      sum += radix * (c - 'A' + 1)
      radix * 26
    }
    sum
  }
}