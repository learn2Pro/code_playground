package category.timeline.week27

import scala.collection.mutable.ArrayBuffer

/**
  * @author tang
  * @date 2019/07/06
  */
object UglyNumber2Solution {
  def nthUglyNumber(n: Int): Int = {
    val uglyNums = new ArrayBuffer[Int](n)
    uglyNums.append(1)
    var i0 = 0
    var i1 = 0
    var i2 = 0
    while (uglyNums.length <= n) {
      val min0 = uglyNums(i0) * 2
      val min1 = uglyNums(i1) * 3
      val min2 = uglyNums(i2) * 5
      val min = Math.min(Math.min(min0, min1), uglyNums(i2) * 5)
      uglyNums.append(min)
      if (min == min0) {
        i0 += 1
      }
      if (min == min1) {
        i1 += 1
      }
      if (min == min2) {
        i2 += 1
      }
    }
    uglyNums(n - 1)

  }
}
