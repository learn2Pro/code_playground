package category.bsearch._500_600

import java.util

/**
  * 528. Random Pick with Weight
  *
  * @param _w
  */
class _528_Solution(_w: Array[Int]) {
  val rnd  = new java.util.Random()
  var sum  = 0
  var tree = new util.TreeMap[Int, Int]()
  for (i <- _w.indices) {
    sum += _w(i)
    tree.put(sum, i)
  }
  
  def pickIndex(): Int = {
    tree.ceilingEntry(rnd.nextInt(sum) + 1).getValue
  }
  
}