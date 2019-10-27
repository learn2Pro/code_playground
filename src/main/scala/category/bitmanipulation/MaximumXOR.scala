package category.bitmanipulation



/**
  * 421. Maximum XOR of Two Numbers in an Array
  */
object MaximumXOR {
  import scala.collection.mutable
  def findMaximumXOR(nums: Array[Int]): Int = {
    var res, mask = 0
    for (i <- Range(31, -1, -1)) {
      mask |= 1 << i
      val set = new mutable.HashSet[Int]()
      for (num <- nums) set.add(num & mask)
      for (n <- set if set.contains((res | 1 << i) ^ n)) {
        res |= 1 << i
      }
    }
    res
  }
}