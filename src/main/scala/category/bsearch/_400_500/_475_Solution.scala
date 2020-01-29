package category.bsearch._400_500

import java.util

/**
  * 475. Heaters
  */
object _475_Solution {
  def findRadius(houses: Array[Int], heaters: Array[Int]): Int = {
    val set = new util.TreeSet[Integer]()
    heaters.foreach(set.add(_))
    var ans = 0
    houses.foreach { h =>
      val hi = set.ceiling(h)
      val lo = set.floor(h)
      if (hi == null && lo == null) return Int.MaxValue
      val min = if (hi == null) h - lo else if (lo == null) hi - h else Math.min(hi - h, h - lo)
      ans = Math.max(ans, min)
    }
    ans
  }
}