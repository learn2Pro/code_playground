package category.timeline.week32

/**
  * Created by Administrator on 2019/8/11 0011.
  */
object PlusOne {
  def plusOne(digits: Array[Int]): Array[Int] = {
    var index = digits.length - 1
    val carry = digits.foldRight(1) {
      case (digit, plus) =>
        digits(index) = (digit + plus) % 10
        index -= 1
        if (digit + plus >= 10) 1 else 0
    }
    if (carry == 1) Array(1) ++ digits
    else digits
  }
}
