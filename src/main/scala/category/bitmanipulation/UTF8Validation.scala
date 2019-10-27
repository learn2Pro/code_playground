package category.bitmanipulation

/**
  * 393. UTF-8 Validation
  */
object UTF8Validation {
  def validUtf8(data: Array[Int]): Boolean = {
    def followerLength(b: Int) = {
      var mask = 0x80
      var size = 0
      while ((mask & b) == mask && mask != 0) {
        size += 1
        mask >>= 1
      }
      size
    }
    
    def howLong(b: Int): Int = {
      if ((b & 0x80) == 0) 1
      else {
        val follower = followerLength(b)
        if (follower == 1) 5
        else follower
      }
    }
    
    var idx = 0
    while (idx < data.length) {
      val len = howLong(data(idx))
      if (len > 4) return false
      for (j <- 1 until len) {
        if (idx + len > data.length || followerLength(data(idx + j)) != 1) return false
      }
      idx += len
    }
    true
  }
}