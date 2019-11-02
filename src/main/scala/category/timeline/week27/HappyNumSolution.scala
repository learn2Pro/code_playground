package category.timeline.week27

import java.util

/**
  * @author tang
  * @date 2019/07/06
  */
object HappyNumSolution {
  def isHappy(n: Int): Boolean = {
    val history = new util.HashSet[Int]()
    var find = false
    var tmp: Int = n
    while (!history.contains(tmp) && !find) {
      history.add(tmp)
      tmp = square(tmp)
      if (tmp == 1) {
        find = true
      }
    }
    find
  }

  def square(n: Int): Int = {
    var tmp = n
    var sqr = 0
    while (tmp > 0) {
      sqr += (tmp % 10) * (tmp % 10)
      tmp /= 10
    }
    sqr
  }
}
