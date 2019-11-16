package category.dp._300_400

/**
  * 303. Range Sum Query - Immutable
  *
  * @param _nums input array
  */
class _303_RangeSumQuery(_nums: Array[Int]) {
  
  val sumArr = new Array[Int](_nums.length + 1)
  for (i <- _nums.indices) {
    sumArr(i + 1) = sumArr(i) + _nums(i)
  }
  
  def sumRange(i: Int, j: Int): Int = {
    sumArr(j) - sumArr(i)
  }
  
}