package category.time.week41

/**
  * 162. Find Peak Element
  */
object FindPeek {
  def findPeakElement(nums: Array[Int]): Int = {
    var l = 0
    var r = nums.length - 1
    while (l < r) {
      val mid = l + (r - l) / 2
      if (nums(mid) < nums(mid + 1)) l = mid + 1
      else r = mid
    }
    l
  }
  
  //  def findPeakElement(nums: Array[Int]): Int = {
  //    def isPeak(idx: Int): Boolean = {
  //      if (idx == 0) nums(idx) > nums(idx + 1)
  //      else if (idx == nums.length - 1) nums(idx - 1) < nums(idx)
  //      else nums(idx) > nums(idx - 1) && nums(idx) > nums(idx + 1)
  //    }
  //
  //    if (nums.length == 1) return 0
  //    var idx = 0
  //    while (idx < nums.length) {
  //      if (isPeak(idx)) return idx
  //      idx += 1
  //    }
  //    -1
  //  }
  
  
}