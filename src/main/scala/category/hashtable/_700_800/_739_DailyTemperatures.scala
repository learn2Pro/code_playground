package category.hashtable._700_800




/**
  * 739. Daily Temperatures
  */
object _739_DailyTemperatures {
  import scala.collection.mutable
  def dailyTemperatures(T: Array[Int]): Array[Int] = {
    val stack = new mutable.Stack[Int]()
    val ans = new Array[Int](T.length)
    for (i <- Range(T.length - 1, -1, -1)) {
      while (stack.nonEmpty && T(i) >= T(stack.top)) stack.pop()
      ans(i) = if (stack.isEmpty) 0 else stack.top - i
      stack.push(i)
    }
    ans
  }
}