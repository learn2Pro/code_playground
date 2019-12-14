package category.dp._600_700

/**
  * 698. Partition to K Equal Sum Subsets
  */
object _698_PartitionToKEqSumSubsets {
  
  def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
    val sum = nums.sum
    if (sum % k != 0) return false
    val target = sum / k
    val sorted = nums.sorted
    var location = sorted.length - 1
    var remain = k
    while (sorted(location) == target) {
      location -= 1
      remain -= 1
    }
    
    def search(arr: Array[Int]): Boolean = {
      if (location < 0) return true
      var earlyStop = false
      for (i <- arr.indices if !earlyStop) {
        if (arr(i) + sorted(location) <= target) {
          arr(i) += sorted(location)
          location -= 1
          if (search(arr)) return true
          location += 1
          arr(i) -= sorted(location)
        }
        if (arr(i) == 0) earlyStop = true
      }
      false
    }
    
    search(new Array[Int](remain))
  }
  
  
}