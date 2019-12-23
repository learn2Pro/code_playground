package category.math._700_800

/**
  * 754. Reach a Number
  */
object _754_ReachANumber {
  def reachNumber(target: Int): Int = {
    var absTarget = Math.abs(target)
    var i = 0
    while (absTarget > 0) {
      absTarget -= i
      i += 1
    }
    if (absTarget % 2 == 0) i else i + 1 + i % 2
  }
}