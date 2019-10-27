package category.time.week39


object SingleNumberII {
  
  /**
    * version 2
    * a+b = a&b<<1 + a^b
    **/
  def singleNumber(nums: Array[Int]): Int = {
    val parsedLong = nums.map(_.toLong)
    var xor = parsedLong.head
    var and = parsedLong.head
    var sum1 = parsedLong.head
    for (i <- 1 until parsedLong.length) {
      xor ^= parsedLong(i)
      and &= parsedLong(i)
      sum1 += parsedLong(i)
    }
    val sum0 = (and << 1) + xor
    ((sum0 * 3 - sum1) / 2).toInt
  }
  
  import java.util
  
  /**
    * version 1
    */
  def singleNumber1(nums: Array[Int]): Int = {
    val set = new util.HashSet[Long]()
    val parsedLong = nums.map(_.toLong)
    val sum0 = parsedLong.sum
    val sum1 = parsedLong.foldLeft(0L) { case (last, curr) =>
      if (set.contains(curr)) last - curr
      else {
        set.add(curr)
        last + curr
      }
    }
    ((sum1 * 3 + sum0) / 4).toInt
  }
  
  
}