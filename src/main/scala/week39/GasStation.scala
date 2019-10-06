package week39

/**
  * 134. Gas Station
  */
object GasStation {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    var start, lack = 0
    val ans = gas.zip(cost).zipWithIndex.foldLeft(0) { case (last, ((g, c), idx)) =>
      val remain = last + (g - c)
      if (remain < 0) {
        lack = remain
        start = idx + 1
        0
      } else {
        remain
      }
    }
    if (ans + lack >= 0) start else -1
  }
  
  //  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
  //    val len = gas.length
  //    var loc = 0
  //    while (loc < len) {
  //      val couldPass = startInLoc(loc, gas, cost)
  //      if (couldPass) return loc
  //      loc += 1
  //    }
  //    -1
  //  }
  //
  //  private def startInLoc(loc: Int, gas: Array[Int], cost: Array[Int]): Boolean = {
  //    var state = 0
  //    var idx = loc
  //    while (idx - loc < gas.length) {
  //      state += (gas(whichIndex(idx, gas.length)) - cost(whichIndex(idx, gas.length)))
  //      if (state < 0) return false
  //      idx += 1
  //    }
  //    true
  //  }
  //
  //  private def whichIndex(loc: Int, len: Int) = {
  //    loc % len
  //  }
}