package category.bsearch._300_400

import java.util

import scala.collection.mutable.ArrayBuffer

/**
  * 352. Data Stream as Disjoint Intervals
  */
class _352_Solution() {
  
  /** Initialize your data structure here. */
  val bits = new util.BitSet(Int.MaxValue)
  
  def addNum(`val`: Int): Unit = {
    bits.set(`val`)
  }
  
  def getIntervals(): Array[Array[Int]] = {
    var from = 0
    val buffer = new ArrayBuffer[Array[Int]]()
    while (from >= 0) {
      val start = bits.nextSetBit(from)
      if (start >= 0) {
        val end = bits.nextClearBit(start)
        buffer += Array(start, end - 1)
        from = end
      } else from = start
    }
    buffer.toArray
  }
  
}