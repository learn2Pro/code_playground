package category.stack._500_600

/**
  * 503. Next Greater Element II
  */
object _503_NextGreaterElementII {
  def nextGreaterElements(nums: Array[Int]): Array[Int] = {
    val mapping = new java.util.HashMap[Int, Int]()
    val stack = new java.util.Stack[(Int, Int)]()
    val N = nums.length
    for (idx <- 0 until 2 * N) {
      val num = nums(idx % N)
      while (!stack.isEmpty && stack.peek()._2 < num) mapping.put(stack.pop()._1, num)
      stack.push((idx % N, num))
    }
    var i = 0
    nums.map { _ =>
      val ans = mapping.getOrDefault(i, -1)
      i += 1
      ans
    }
  }
}