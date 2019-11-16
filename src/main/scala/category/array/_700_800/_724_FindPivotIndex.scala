package category.array._700_800

/**
  * 724. Find Pivot Index
  */
object _724_FindPivotIndex {
  def pivotIndex(nums: Array[Int]): Int = {
    val n = nums.length + 1
    val sumArray = new Array[Int](n)
    for (i <- nums.indices) {
      sumArray(i + 1) += (sumArray(i) + nums(i))
    }
    for (pivot <- nums.indices) {
      if (sumArray(pivot) + sumArray(pivot + 1) == sumArray(n - 1)) return pivot
    }
    -1
  }
}