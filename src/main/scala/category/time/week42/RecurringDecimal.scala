package category.time.week42

/**
  * 166. Fraction to Recurring Decimal
  */
object RecurringDecimal {
  
  import java.util
  
  import scala.collection.mutable.ArrayBuffer
  
  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    if (numerator == 0) return "0"
    val p0 = Math.abs(numerator.toLong)
    val p1 = Math.abs(denominator.toLong)
    val flag = if ((numerator ^ denominator) < 0) "-" else ""
    val appear = new ArrayBuffer[String]
    val remainAndLocation = new util.HashMap[Long, Int]()
    appear.append((p0 / p1).toString)
    var loc = 2
    var remain = p0 % p1
    var last = remain * 10
    var recurring = false
    while (remain != 0 && !recurring) {
      if (loc == 2) appear.append(".")
      if (remainAndLocation.containsKey(last)) {
        recurring = true
      } else {
        remainAndLocation.put(last, loc)
        appear.append((last / p1).toString)
        remain = last % p1
        last = remain * 10
        loc += 1
      }
    }
    if (recurring) {
      appear.insert(remainAndLocation.get(last), "(")
      appear.append(")")
    }
    flag + appear.mkString
  }
  
}