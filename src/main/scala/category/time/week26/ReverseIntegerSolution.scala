package category.time.week26

/**
  * @author tang
  * @date 2019/06/29
  */
object ReverseIntegerSolution {
  //  def reverse(x: Int): Int = {
  //    var flag = 0
  //    var ans = 0
  //    var tmp = if (x >= 0) {
  //      flag = 1
  //      x
  //    } else {
  //      flag = -1
  //      x * -1
  //    }
  //    //2147483647
  //    //-2147483412
  //    //-2147483648
  //    var remain = 0
  //    while (tmp > 0) {
  //      remain = tmp % 10
  //      ans = ans * 10 + remain
  //      tmp /= 10
  //    }
  //    if (ans % 10 == remain) {
  //      flag * ans
  //    } else {
  //      0
  //    }
  //  }

  def reverse(x: Int): Int = {
    var ret: Long = 0
    var tmp = x
    while (tmp != 0) {
      ret = ret * 10 + tmp % 10
      tmp /= 10
    }
    if (ret.asInstanceOf[Int] == ret) {
      ret.asInstanceOf[Int]
    } else {
      0
    }
  }
}
