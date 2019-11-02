package category.timeline.week27

/**
  * @author tang
  * @date 2019/07/06
  */
object UglyNumSolution {

  def isUgly(num: Int): Boolean = {
    var tmp: Int = num
    val factors = Array(2, 3, 5)
    var idx = 0
    while (tmp > 1 && idx < factors.length) {
      while (tmp % factors(idx) == 0) {
        tmp /= factors(idx)
      }
      idx += 1
    }
    tmp == 1
  }

}
