package week41

/**
  * 164. Maximum Gap
  */
object MaximumGap {
  
  case class Bucket(min: Int, max: Int)
  
  def maximumGap(nums: Array[Int]): Int = {
    if (nums.length < 2) return 0
    var min = Int.MaxValue
    var max = Int.MinValue
    for (num <- nums) {
      min = Math.min(min, num)
      max = Math.max(max, num)
    }
    val bucketRange = Math.max(1, (max - min) / (nums.length - 1))
    val bucketNum = (max - min) / bucketRange + 1
    val bucketArr = Array.tabulate[Bucket](bucketNum)(_ => null)
    
    def fillBucket(num: Int) = {
      val idx = (num - min) / bucketRange
      if (bucketArr(idx) == null) {
        bucketArr(idx) = Bucket(num, num)
      } else {
        val old = bucketArr(idx)
        bucketArr(idx) = old.copy(min = Math.min(old.min, num), max = Math.max(old.max, num))
      }
    }
    
    nums.foreach { num =>
      fillBucket(num)
    }
    var preBucket: Bucket = null
    bucketArr.foldLeft(0) { case (gap, bucket) =>
      if (preBucket != null && bucket != null) {
        val maxGap = Math.max(gap, bucket.min - preBucket.max)
        preBucket = bucket
        maxGap
      } else {
        if (bucket != null) {
          preBucket = bucket
        }
        gap
      }
    }
    
  }
  
  //  def maximumGap(nums: Array[Int]): Int = {
  //    if (nums.length < 2) return 0
  //    val sortedArr = nums.sorted
  //    var maxGap = 0
  //    for (i <- 1 until nums.length) {
  //      maxGap = Math.max(maxGap, sortedArr(i) - sortedArr(i - 1))
  //    }
  //    maxGap
  //  }
}