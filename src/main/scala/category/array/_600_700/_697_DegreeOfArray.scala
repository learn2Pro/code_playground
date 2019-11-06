package category.array._600_700

/**
  * 697. Degree of an Array
  */
object _697_DegreeOfArray {
  
  case class Degree(var start: Int, var end: Int, var size: Int) {
    def increment(idx: Int) = {
      size += 1
      end = idx
    }
  }
  
  import scala.collection.mutable
  
  def findShortestSubArray(nums: Array[Int]): Int = {
    val store = new mutable.HashMap[Int, Degree]
    for (i <- nums.indices) {
      store.getOrElseUpdate(nums(i), Degree(i, i, 1)).increment(i)
    }
    val ans = store.values.maxBy { degree =>
      val gap = 50000 - degree.end + degree.start
      degree.size -> gap
    }
    ans.end - ans.start + 1
  }
}