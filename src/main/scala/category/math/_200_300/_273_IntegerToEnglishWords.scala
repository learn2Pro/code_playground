package category.math._200_300

/**
  * 273. Integer to English Words
  */
object _273_IntegerToEnglishWords {
  private val Ones     = Array("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
  private val Tens_0   = Array("Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
  private val Tens_1   = Array("Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
  private val Hundreds = Array("One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred",
    "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred")
  private val Units    = Array("", "Thousand", "Million", "Billion")
  
  trait Printer {
    def num: Int
    
    def output(): String
  }
  
  private case class HundredPrinter(num: Int) extends Printer {
    override def output(): String = if (num == 0) "" else Hundreds(num - 1)
  }
  
  private case class TensPrinter(num: Int) extends Printer {
    require(num != 1, "num must not eq 1!")
    
    override def output(): String = if (num == 0) "" else Tens_1(num - 2)
  }
  
  private case class Less2TensPrinter(num: Int) extends Printer {
    require(num >= 10 && num <= 19, "num range from 10 to 19")
    
    override def output(): String = Tens_0(num - 10)
  }
  
  private case class OnesPrinter(num: Int) extends Printer {
    require(num >= 0 && num <= 9, "num range from 10 to 19")
    
    override def output(): String = if (num == 0) "" else Ones(num - 1)
  }
  
  def numberToWords(num: Int): String = {
    
    def output(less1000: Int): String = {
      /*十位为1*/
      (if (less1000 % 100 / 10 == 1) {
        HundredPrinter(less1000 / 100).output() + " " + Less2TensPrinter(less1000 % 100).output()
      } else {
        val tens = TensPrinter(less1000 % 100 / 10).output()
        val mid = if (tens.isEmpty) "" else tens + " "
        HundredPrinter(less1000 / 100).output() + " " + mid + OnesPrinter(less1000 % 10).output()
      }).trim
    }
    
    if (num == 0) return "Zero"
    
    var tmp = num
    var i = 0
    var ans = ""
    while (tmp > 0) {
      val part = output(tmp % 1000)
      val mid = if (part.nonEmpty) part + " " + Units(i) + " " else ""
      ans = mid + ans
      tmp /= 1000
      i += 1
    }
    ans.trim
    
  }
}