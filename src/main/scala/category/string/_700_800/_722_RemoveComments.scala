package category.string._700_800


/**
  * 722. Remove Comments
  */
object _722_RemoveComments {
  
  import scala.collection.mutable.ArrayBuffer
  
  trait Remover {
    def replace(line: String, num: Int): String
  }
  
  class SingleLine extends Remover {
    override def replace(line: String, num: Int): String = {
      val l0 = line.indexOf("/*")
      val l1 = line.indexOf("//")
      if (l1 == -1) line
      else if (l0 == -1 && l1 != -1) line.substring(0, l1)
      else if (l0 < l1) line
      else line.substring(0, l1)
    }
  }
  
  class MultiLine extends Remover {
    var state  : Boolean = false
    var current: Int     = -1
    val single           = new SingleLine
    
    override def replace(line: String, num: Int): String = {
      val sb = new StringBuilder
      if (!state) {
        val where = line.indexOf("/*")
        if (where != -1) {
          this.state = true
          current = num
          sb.append(line.substring(0, where) + replace(line.substring(where), num))
        } else {
          sb.append(line)
        }
      } else {
        val special = line.indexOf("/*")
        val next = line.indexOf("*/")
        val where = if (num == current && special + 1 == next) line.indexOf("*/", special + 3) else next
        if (where != -1) {
          this.state = false
          sb.append(replace(single.replace(line.substring(where + 2), num), num))
        }
      }
      sb.toString()
    }
  }
  
  def removeComments(source: Array[String]): List[String] = {
    val single = new SingleLine
    val multi = new MultiLine
    val N = source.length
    var i = 0
    val buffer = new ArrayBuffer[String]()
    while (i < N) {
      var s = multi.replace(single.replace(source(i), i), i)
      while (i < N && multi.state) {
        i += 1
        s += multi.replace(source(i), i)
      }
      if (s.nonEmpty) buffer.append(s)
      i += 1
    }
    buffer.toList
  }
}