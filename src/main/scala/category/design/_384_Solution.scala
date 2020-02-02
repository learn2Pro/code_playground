package category.design

/**
  * 384. Shuffle an Array
  *
  * @param _nums
  */
class _384_Solution(_nums: Array[Int]) {
  
  val rnd    = new java.util.Random()
  val origin = _nums.clone()
  
  /** Resets the array to its original configuration and return it. */
  def reset(): Array[Int] = {
    origin
  }
  
  /** Returns a random shuffling of the array. */
  def shuffle(): Array[Int] = {
    for (i <- _nums.indices) {
      val swap = rnd.nextInt(_nums.length)
      val tmp = _nums(i)
      _nums(i) = _nums(swap)
      _nums(swap) = tmp
    }
    _nums
  }
  
}
