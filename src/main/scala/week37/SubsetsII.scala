package week37

object SubsetsII {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    val sorted = nums.sorted
    sorted.foldLeft[List[List[Int]]](List(List())) { case (x, y) =>
      x ++ x.map(z => y :: z)
    }.distinct
  }


}