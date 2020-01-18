package category.hashtable._400_500

/**
  * 451. Sort Characters By Frequency
  */
object _451_SortCharByFreq {
  def frequencySort(s: String): String = {
    val arr = new Array[Int](256)
    s.foreach(arr(_) += 1)
    val sb = new StringBuilder
    arr.zipWithIndex.sortBy(-_._1).foreach { case (size, c) =>
      for (_ <- 0 until size) sb.append(c.toChar)
    }
    sb.toString()
  }
}