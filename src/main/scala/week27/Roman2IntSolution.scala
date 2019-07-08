package week27


/**
  * @author tang
  * @date 2019/07/06
  */
object Roman2IntSolution {

  case class RomanNum(num: Int, tag: String)

  val numbers = Seq(
    RomanNum(1000, "M"),
    RomanNum(900, "CM"),
    RomanNum(500, "D"),
    RomanNum(400, "CD"),
    RomanNum(100, "C"),
    RomanNum(90, "XC"),
    RomanNum(50, "L"),
    RomanNum(40, "XL"),
    RomanNum(10, "X"),
    RomanNum(9, "IX"),
    RomanNum(5, "V"),
    RomanNum(4, "IV"),
    RomanNum(1, "I")
  )

  def romanToInt(s: String): Int = {
    def loopNum(s: String, numbers: Seq[RomanNum]): Int = {
      numbers match {
        case RomanNum(digit, c) :: _ if s.startsWith(c) => digit + loopNum(s.substring(c.length), numbers)
        case RomanNum(digit, c) :: _ if s == c => digit
        case RomanNum(_, _) :: tail => loopNum(s, tail)
        case _ => 0
      }
    }

    loopNum(s, numbers)
  }
}
