package category.bitmanipulation

/**
  * 405. Convert a Number to Hexadecimal
  */
object Num2HexString {
  val digits = Array(
    '0', '1', '2', '3', '4', '5',
    '6', '7', '8', '9', 'a', 'b',
    'c', 'd', 'e', 'f'
  )
  
  def toHex(num: Int): String = {
    if (num == 0) return "0"
    val mag = 32 - java.lang.Integer.numberOfLeadingZeros(num)
    val charNum = Math.max((mag + 3) / 4, 1)
    val chars = Array.tabulate(charNum) { idx =>
      val mask = 0xf << (idx * 4)
      digits((mask & num) >>> (idx * 4))
    }
    chars.mkString.reverse
  }
}