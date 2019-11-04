package category.array

/**
  * 561. Array Partition I
  */
object ArrayPartitionI {
  /**
    * use sort count
    *
    * @param nums
    * @return
    */
  def arrayPairSum(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val max = 10000
    val min = -10000
    val countOfSort = new Array[Int](max - min + 1)
    nums.foreach { num =>
      countOfSort(num - min) += 1
    }
    var ans = 0
    var odd = true
    for (i <- countOfSort.indices if countOfSort(i) != 0) {
      while (countOfSort(i) > 0) {
        if (odd) ans += (i + min)
        odd = !odd
        countOfSort(i) -= 1
      }
    }
    ans
  }
  
  //  def arrayPairSum(nums: Array[Int]): Int = {
  //    if (nums.isEmpty) return 0
  //    nums.sorted.grouped(2).map(_ (0)).sum
  //  }
}