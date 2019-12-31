package category.string._400_500

/**
  * 443. String Compression
  */
object _443_StringCompression {
  def compress(chars: Array[Char]): Int = {
    var ans = 0
    var seg = 1
    var idx = 0
    
    def refresh(seg: Int, c: Char): Unit = {
      val num = seg.toString
      num.foreach { c =>
        chars(idx) = c
        idx += 1
      }
      ans += num.length + 1
    }
    
    val last = chars.reduce[Char] { case (c0, c1) =>
      if (c0 == c1) seg += 1
      else {
        chars(idx) = c0
        idx += 1
        if (seg == 1) {
          ans += 1
        } else {
          refresh(seg, c0)
        }
        seg = 1
      }
      c1
    }
    chars(idx) = last
    idx += 1
    if (seg == 1) ans += 1 else refresh(seg, last)
    ans
  }
  
  
}