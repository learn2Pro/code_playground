package category.bitmanipulation

/**
  * 260. Single Number III
  */
object SingleNumberIII {
  def singleNumber(nums: Array[Int]): Array[Int] = {
    val xor = nums.reduce(_ ^ _)
    val diff = xor & (-xor)
    val ans = new Array[Int](2)
    nums.foreach { num =>
      if ((diff & num) == 0) {
        ans(0) ^= num
      } else {
        ans(1) ^= num
      }
    }
    ans
  }
}