package category.hashtable._200_300

/**
  * 274. H-Index
  */
object _274_HIndex {
  def hIndex(citations: Array[Int]): Int = {
    if (citations == null || citations.isEmpty) return 0
    val N = citations.length
    val counter = new Array[Int](N + 1)
    
    def update(end: Int): Unit = {
      val i = Math.min(end, N)
      counter(i) += 1
    }
    
    citations.foreach { c =>
      counter(Math.min(c, N)) += 1
    }
    var total = 0
    for (i <- Range(N, -1, -1)) {
      total += counter(i)
      if (total >= i) return i
    }
    0
  }
}