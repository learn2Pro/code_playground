package category.math._700_800

/**
  * 728. Self Dividing Numbers
  */
object _728_SelfDividingNumbers {
  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    def divisible(num: Int): Boolean = {
      for (c <- num.toString) {
        if (c - '0' == 0 || num % (c - '0') != 0) return false
      }
      true
    }
    
    var ans: List[Int] = Nil
    for (num <- Range(left, right + 1, 1)) {
      if (divisible(num)) ans ++= List(num)
    }
    ans
  }
}