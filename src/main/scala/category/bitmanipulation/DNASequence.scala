package category.bitmanipulation


/**
  * 187. Repeated DNA Sequences
  */
object DNASequence {
  /**
    * A:00
    * C:01
    * G:10
    * T:11
    *
    * @param s
    * @return
    */
  def findRepeatedDnaSequences(s: String): List[String] = {
    def calcBits(last: Int, dna: Char) = {
      dna match {
        case 'A' =>
          (last << 2 | 0x00) & 0xfffff
        case 'C' =>
          (last << 2 | 0x01) & 0xfffff
        case 'G' =>
          (last << 2 | 0x02) & 0xfffff
        case 'T' =>
          (last << 2 | 0x03) & 0xfffff
      }
    }
    
    def translate(bits: Int): String = {
      var state = bits
      (for (_ <- 0 until 10) yield {
        val part = state & 0x03 match {
          case 0 =>
            'A'
          case 1 =>
            'C'
          case 2 =>
            'G'
          case 3 =>
            'T'
        }
        state >>= 2
        part
      }).reverse.mkString
    }
    
    def init: Int = {
      val bits = s.slice(0, 9).foldLeft(0) { case (last, dna) =>
        calcBits(last, dna)
      }
      bits
    }
    
    
    import java.util
    val ans = new util.HashSet[Int]()
    if (s.length < 10) return Nil
    val holder = new util.HashSet[Int]()
    var bits = init
    for (i <- 9 until s.length) {
      val state = calcBits(bits, s(i))
      if (holder.contains(state)) ans.add(state)
      else holder.add(state)
      bits = state
    }
    import scala.collection.JavaConversions._
    ans.map { part =>
      translate(part)
    }.toList
  }
  
  
}
