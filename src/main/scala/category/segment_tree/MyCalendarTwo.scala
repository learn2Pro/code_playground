package category.segment_tree

/**
  * 731. My Calendar II
  */


class MyCalendarTwo() {
  val tree = new java.util.TreeMap[Int, Int]()
  
  def book(start: Int, end: Int): Boolean = {
    tree.put(start, tree.getOrDefault(start, 0) + 1)
    tree.put(end, tree.getOrDefault(end, 0) - 1)
    
    var active = 0
    val col = tree.values.iterator()
    while (col.hasNext) {
      val d = col.next()
      active += d
      if (active >= 3) {
        tree.put(start, tree.get(start) - 1)
        tree.put(end, tree.get(end) + 1)
        if (tree.get(start) == 0) tree.remove(start)
        return false
      }
    }
    true
  }
  
}