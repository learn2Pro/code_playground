package category.math._200_300

/**
  * 258. Add Digits
  */
object _258_AddDigits {
  def addDigits(num: Int): Int = {
    if (num == 0) 0 else {
      (num - 1) % 9 + 1
    }
  }
}