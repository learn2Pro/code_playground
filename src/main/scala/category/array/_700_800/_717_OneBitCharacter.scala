package category.array._700_800

/**
  * 717. 1-bit and 2-bit Characters
  */
object _717_OneBitCharacter {
  def isOneBitCharacter(bits: Array[Int]): Boolean = {
    var i = 0
    while (i < bits.length - 1) {
      i += (bits(i) + 1)
    }
    i == bits.length - 1
  }
}