package category.bitmanipulation

object PowerOfFour {
  def isPowerOfFour(num: Int): Boolean = {
    num > 0 && 0x4fffffff % num == 0
  }
}