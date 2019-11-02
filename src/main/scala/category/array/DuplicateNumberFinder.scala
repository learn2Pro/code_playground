package category.array


/**
  * 287. Find the Duplicate Number
  */
object DuplicateNumberFinder {
  
  //  def findDuplicate(nums: Array[Int]): Int = {
  //    val bs = new util.BitSet(nums.length)
  //    nums.foreach { num =>
  //      if (bs.get(num)) return num
  //      else {
  //        bs.flip(num)
  //      }
  //    }
  //    throw new RuntimeException("not contains duplicate elements!")
  //  }
  
  //  def findDuplicate(nums: Array[Int]): Int = {
  //    val sorted = nums.sorted
  //    for (i <- 1 until nums.length) {
  //      if (sorted(i) == sorted(i - 1)) return sorted(i)
  //    }
  //    throw new RuntimeException("not contains duplicate elements!")
  //  }
  
  /**
    * cycle detection
    */
  def findDuplicate(nums: Array[Int]): Int = {
    var tortoise = nums(0)
    var hare = nums(0)
    do {
      tortoise = nums(tortoise)
      hare = nums(nums(hare))
    } while (tortoise != hare)
    var ptr1 = nums(0)
    var ptr2 = tortoise
    while (ptr1 != ptr2) {
      ptr1 = nums(ptr1)
      ptr2 = nums(ptr2)
    }
    ptr1
  }
}