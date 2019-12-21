package category.math._400_500

/**
  * 423. Reconstruct Original Digits from English
  */
object _423_ReconstructOriginDigitFromEng {
  /**
    * zero z
    */
  val ZERO  = Array(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1)
  /**
    * one o
    */
  val ONE   = Array(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  /**
    * two w
    */
  val TWO   = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0)
  /**
    * three
    */
  val THREE = Array(0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0)
  /**
    * four u
    */
  val FOUR  = Array(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0)
  /**
    * five f
    */
  val FIVE  = Array(0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0)
  /**
    * six x
    */
  val SIX   = Array(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0)
  /**
    * seven v
    */
  val SEVEN = Array(0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0)
  /**
    * eight g
    */
  val EIGHT = Array(0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
  /**
    * nine
    */
  val NINE  = Array(0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  
  trait Extractor {
    def coding: Array[Int]
    
    def minus(chars: Array[Int], times: Int): Unit = {
      for (_ <- 0 until times) {
        for (i <- 0 until 26) {
          chars(i) -= coding(i)
        }
      }
    }
    
    def tagExtract(chars: Array[Int], loc: Int, which: Int): String = if (chars(loc) > 0) {
      val tmp = chars(loc)
      minus(chars, chars(loc))
      Array.tabulate(tmp)(_ => s"$which").mkString("")
    } else {
      ""
    }
    
    def extract(chars: Array[Int]): String
  }
  
  case class ZeroExtractor(coding: Array[Int] = ZERO) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 25, 0)
  }
  
  case class TwoExtractor(coding: Array[Int] = TWO) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 22, 2)
  }
  
  case class FourExtractor(coding: Array[Int] = FOUR) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 20, 4)
  }
  
  case class FiveExtractor(coding: Array[Int] = FIVE) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 5, 5)
  }
  
  case class SixExtractor(coding: Array[Int] = SIX) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 23, 6)
  }
  
  case class SevenExtractor(coding: Array[Int] = SEVEN) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 21, 7)
  }
  
  case class EightExtractor(coding: Array[Int] = EIGHT) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 6, 8)
  }
  
  case class OneExtractor(coding: Array[Int] = ONE) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 14, 1)
  }
  
  case class ThreeExtractor(coding: Array[Int] = THREE) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 17, 3)
  }
  
  case class NineExtractor(coding: Array[Int] = NINE) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 8, 9)
  }
  
  def originalDigits(s: String): String = {
    val chars = new Array[Int](26)
    s.foreach { c =>
      chars(c - 'a') += 1
    }
    
    
    val sb = new StringBuilder
    sb.append(ZeroExtractor().extract(chars))
    sb.append(TwoExtractor().extract(chars))
    sb.append(FourExtractor().extract(chars))
    sb.append(FiveExtractor().extract(chars))
    sb.append(SixExtractor().extract(chars))
    sb.append(SevenExtractor().extract(chars))
    sb.append(EightExtractor().extract(chars))
    sb.append(OneExtractor().extract(chars))
    sb.append(ThreeExtractor().extract(chars))
    sb.append(NineExtractor().extract(chars))
    /*handle zero*/
    sb.toString().sorted
  }
}