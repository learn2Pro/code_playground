package category.time.week27

/**
  * @author tang
  * @date 2019/07/03
  */
object Int2RomanSolution {

    //sealed trait RomanNumber
    case class RomanNumber(decValue: Int, romanStr: String)
    val numbers = Seq(
      RomanNumber(1000, "M"),
      RomanNumber(900, "CM"),
      RomanNumber(500, "D"),
      RomanNumber(400, "CD"),
      RomanNumber(100, "C"),
      RomanNumber(90, "XC"),
      RomanNumber(50, "L"),
      RomanNumber(40, "XL"),
      RomanNumber(10, "X"),
      RomanNumber(9, "IX"),
      RomanNumber(5, "V"),
      RomanNumber(4, "IV"),
      RomanNumber(1, "I")
    )
    def intToRoman(num: Int): String = {
      def loop(num:Int, romans: Seq[RomanNumber]): String = {
        romans match {
          case RomanNumber(x, s) :: _ if x < num => s + loop(num-x, romans)
          case RomanNumber(x, s) :: _ if x == num => s
          case RomanNumber(x, s) :: tail if x > num => loop(num, tail)
        }
      }
      loop(num, numbers)
    }

//  val mapping: Map[Int, (Char, Char, Char)] = Map(
//    1 -> ('I', 'V', 'X'), 2 -> ('X', 'L', 'C'), 3 -> ('C', 'D', 'M'), 4 -> ('M', null.asInstanceOf[Char], null.asInstanceOf[Char])
//  )
//
//  def intToRoman(num: Int): String = {
//    var tmp = num
//    var round = 1
//    val sb = new StringBuilder
//    while (tmp > 0) {
//      sb.insert(0, choose(parse(tmp % 10), round))
//      round += 1
//      tmp /= 10
//    }
//    sb.toString()
//  }
//
//  /**
//    * left,mid,right
//    * 0 , V, III
//    *
//    * @param num
//    * @return
//    */
//  def parse(num: Int): (Int, Int, Int) = {
//    if (num >= 0 && num <= 3) {
//      (0, 0, num)
//    } else if (num == 4) {
//      (1, 1, 0)
//    } else if (num < 9) {
//      (0, 1, num - 5)
//    } else {
//      (1, 2, 0)
//    }
//  }
//
//  def choose(index: (Int, Int, Int), round: Int): String = {
//    var left = index._1
//    var mid = index._2
//    var right = index._3
//    var s = ""
//    while (left > 0) {
//      s += mapping(round)._1
//      left -= 1
//    }
//    mid match {
//      case 0 =>
//      case 1 =>
//        s += mapping(round)._2
//      case 2 =>
//        s += mapping(round)._3
//    }
//    while (right > 0) {
//      s += mapping(round)._1
//      right -= 1
//    }
//    s
//  }

}
