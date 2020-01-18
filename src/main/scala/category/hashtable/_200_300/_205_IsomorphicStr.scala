package category.hashtable._200_300

/**
  * 205. Isomorphic Strings
  */
object _205_IsomorphicStr {
  def isIsomorphic(s: String, t: String): Boolean = {
    val src, dst = new Array[Int](256)
    for (i <- s.indices) {
      if (src(s(i)) != dst(t(i))) return false
      src(s(i)) = i + 1
      dst(t(i)) = i + 1
    }
    true
  }
  
  //  def isIsomorphic(s: String, t: String): Boolean = {
  //    val mapping = new java.util.HashMap[Char, Char]
  //    val dst = new java.util.HashSet[Char]
  //    val N = s.length
  //    for (i <- 0 until N) {
  //      if (mapping.containsKey(s(i)) && mapping.get(s(i)) != t(i)) return false
  //      else if (dst.contains(t(i)) && mapping.get(s(i)) != t(i)) return false
  //      else {
  //        mapping.put(s(i), t(i))
  //        dst.add(t(i))
  //      }
  //    }
  //    true
  //  }
}