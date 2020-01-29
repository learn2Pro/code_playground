package category.bsearch._400_500

import java.util
import java.util.Random

/**
  * 497. Random Point in Non-overlapping Rectangles
  */
class _497_Solution(_rects: Array[Array[Int]]) {
  val ran  = new Random()
  val tree = new util.TreeMap[Int, Int]()
  var sum  = 0
  for (i <- _rects.indices) {
    _rects(i) match {
      case _@Array(x0, y0, x1, y1) =>
        sum += (x1 - x0 + 1) * (y1 - y0 + 1)
        tree.put(sum, i)
    }
  }
  
  def pick(): Array[Int] = {
    val which = tree.ceilingEntry(ran.nextInt(sum) + 1).getValue
    val width = _rects(which)(2) - _rects(which)(0) + 1
    val height = _rects(which)(3) - _rects(which)(1) + 1
    val x = if (width == 0) 0 else ran.nextInt(width)
    val y = if (height == 0) 0 else ran.nextInt(height)
    Array(_rects(which)(0) + x, _rects(which)(1) + y)
  }
  
}