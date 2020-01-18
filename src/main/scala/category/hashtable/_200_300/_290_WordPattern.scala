package category.hashtable._200_300

/**
  * 290. Word Pattern
  */
object _290_WordPattern {
  def wordPattern(pattern: String, str: String): Boolean = {
    val l = new Array[Int](26)
    val r = new java.util.HashMap[String, Int]
    val strs = str.split(' ')
    if (pattern.length != strs.length) return false
    for (i <- pattern.indices) {
      if (l(pattern(i) - 'a') != r.get(strs(i))) return false
      l(pattern(i) - 'a') = i + 1
      r.put(strs(i), i + 1)
    }
    true
  }
}