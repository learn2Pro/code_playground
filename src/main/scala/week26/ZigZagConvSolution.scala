package week26

/**
  * @author tang
  * @date 2019/06/29
  */
object ZigZagConvSolution {

  def convert(s: String, numRows: Int): String = {
    val len = s.length
    if (numRows == 1) {
      s
    } else {
      val skip = 2 * numRows - 2

      var ans = ""
      for (idx <- 0 until numRows) {
        var round = 0
        var curr = idx + round * skip
        //可以超出长度，来添加left数字
        while (curr >= 0 && curr < len + skip) {
          if (round * skip - idx < curr &&
            round * skip - idx > curr - skip &&
            round * skip - idx > 0 &&
            round * skip - idx < len) {
            ans = ans + (s(round * skip - idx))
          }
          if (curr >= 0 && curr < len) {
            ans = ans + s(curr)
          }
          //迭代轮次
          round += 1
          //移动下标
          curr = idx + round * skip
        }
      }
      ans
    }

  }


}
