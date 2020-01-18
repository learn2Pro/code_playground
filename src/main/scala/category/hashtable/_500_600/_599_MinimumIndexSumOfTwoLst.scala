package category.hashtable._500_600



/**
  * 599. Minimum Index Sum of Two Lists
  */
object _599_MinimumIndexSumOfTwoLst {
  import scala.collection.mutable
  def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
    val m0 = list1.zipWithIndex.toMap
    val m1 = list2.zipWithIndex.toMap
    var maxIndexSum = list1.length + list2.length - 1
    val ans = new mutable.HashMap[String, Int]()
    list1.foreach { rest =>
      if (m0.contains(rest) && m1.contains(rest) && m0(rest) + m1(rest) <= maxIndexSum) {
        ans.put(rest, m0(rest) + m1(rest))
        maxIndexSum = Math.min(maxIndexSum, m0(rest) + m1(rest))
      }
    }
    ans.filter(_._2 == maxIndexSum).keys.toArray
  }
}