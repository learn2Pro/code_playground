package category.time.week38


/**
  * 128. Longest Consecutive Sequence
  */
object LongestConsecutive {
  //  def longestConsecutive(nums: Array[Int]): Int = {
  //    if (nums == null || nums.isEmpty) return 0
  //    val sorted = nums.sorted.distinct
  //    var max = 1
  //    var curr = sorted(0)
  //    var expected = curr + 1
  //    var size = 1
  //    for (i <- 1 until sorted.length) {
  //      if (sorted(i) == expected) {
  //        size += 1
  //        expected += 1
  //      } else {
  //        curr = sorted(i)
  //        expected = curr + 1
  //        if (size > max) max = size
  //        size = 1
  //      }
  //    }
  //    Math.max(size, max)
  //  }
  
  def longestConsecutive(nums: Array[Int]): Int = {
    if (nums == null || nums.isEmpty) return 0
    val holder = new java.util.HashSet[Int]()
    val dp = new java.util.HashMap[Int, Int]()
    nums.foreach(holder.add)
    var max = 1
    for (num <- nums) {
      if (dp.containsKey(num - 1)) {
        val v = dp.get(num - 1) + 1
        dp.remove(num - 1)
        if (v > max) max = v
        dp.put(num, v)
      } else {
        if (holder.contains(num - 1)) {
          var curr = num
          var size = 1
          while (holder.contains(curr - 1)) {
            size += 1
            curr -= 1
          }
          if (size > max) max = size
          for (i <- 0 until size) {
            dp.put(num - i, size - i)
          }
        }
      }
    }
    max
  }
}