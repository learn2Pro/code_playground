package category.hashtable._600_700

/**
  * 632. Smallest Range Covering Elements from K Lists
  */
object _632_SmallestRangeCoveringElementsFromKLists {
  def smallestRange(nums: List[List[Int]]): Array[Int] = {
    val N = nums.length
    val pointers = new Array[Int](N)
    var min = Int.MaxValue
    var max = Int.MinValue
    val queue = new java.util.PriorityQueue[(Int, Int)](N, new Ordering[(Int, Int)] {
      override def compare(x: (Int, Int), y: (Int, Int)): Int = x._2 - y._2
    })
    for (i <- 0 until N) {
      queue.add((i, nums(i)(0)))
      max = Math.max(max, nums(i)(0))
      min = Math.min(min, nums(i)(0))
    }
    var ans: Array[Int] = Array(min, max)
    var minGap = max - min
    
    while (true) {
      val (index, _) = queue.poll()
      pointers(index) += 1
      if (pointers(index) >= nums(index).length) return ans
      queue.add((index, nums(index)(pointers(index))))
      max = Math.max(nums(index)(pointers(index)), max)
      min = queue.peek()._2
      if (max - min < minGap || (max - min == minGap && min < ans(0))) {
        minGap = max - min
        ans = Array(min, max)
      }
    }
    ans
  }
}