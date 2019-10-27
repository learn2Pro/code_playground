package category.time.week41

/**
  * 165. Compare Version Numbers
  */
object VersionComparison {
  def compareVersion(version1: String, version2: String): Int = {
    val split1 = version1.split("\\.")
    val split2 = version2.split("\\.")
    val len = Math.max(split1.length, split2.length)
    
    def compare(v0: Int, v1: Int): Int = {
      v0.compareTo(v1)
    }
    
    def get(idx: Int, split: Array[String]): Int = {
      if (idx >= split.length) {
        0
      } else {
        split(idx).toInt
      }
    }
    
    for (i <- 0 until len) {
      val get0 = get(i, split1)
      val get1 = get(i, split2)
      if (compare(get0, get1) != 0) return compare(get0, get1)
    }
    0
  }
}