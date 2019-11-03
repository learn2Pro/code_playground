package category.array

/**
  * 442. Find All Duplicates in an Array
  */
object DuplicateNumberFinderII {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    var ans: List[Int] = Nil
    for (i <- nums.indices) {
      val idx = Math.abs(nums(i))
      if (nums(idx - 1) < 0) ans ::= idx
      nums(idx - 1) *= -1
    }
    ans
  }
  
  //  def findDuplicates(nums: Array[Int]): List[Int] = {
  //    if (nums == null || nums.isEmpty || nums.length == 1) return Nil
  //    nums.groupBy(identity).filter(_._2.length == 2).keys.toList
  //  }
}