package category.segment_tree

/**
  * 732. My Calendar III
  */
case class SegNode(s: Int, e: Int, var saved: Int = 0) {
  var left : SegNode = _
  var right: SegNode = _
  
  def increment(incr: Int): Unit = {
    this.saved += incr
  }
  
  def isLeaf: Boolean = s == e
}

case class SegTree(root: SegNode) {
  
  def add(i: Int, j: Int, v: Int): Unit = {
    def add0(current: SegNode, l: Int, r: Int): Unit = {
      if (l > r) return
      val lo = current.s
      val hi = current.e
      if (lo == hi) {current.increment(v); return}
      val mid = (lo + hi) >>> 1
      if (current.left == null) current.left = SegNode(lo, mid)
      if (current.right == null) current.right = SegNode(mid + 1, hi)
      add0(current.left, l, Math.min(r, mid))
      add0(current.right, Math.max(mid + 1, l), r)
      current.saved = Math.max(current.left.saved, current.right.saved)
    }
    
    add0(root, i, j)
  }
  
  def query(i: Int, j: Int): Int = {
    def query0(current: SegNode, l: Int, r: Int): Int = {
      if (l > r) return 0
      val lo = current.s
      val hi = current.e
      if (l == lo && r == hi) {return current.saved}
      val mid = (lo + hi) >>> 1
      if (current.left == null) current.left = SegNode(lo, mid)
      if (current.right == null) current.right = SegNode(mid + 1, hi)
      Math.max(query0(current.left, l, Math.min(r, mid)), query0(current.right, Math.max(mid + 1, l), r))
    }
    
    query0(root, i, j)
  }
}

class MyCalendarThree() {
  val segTree = SegTree(SegNode(0, 1000000000))
  
  def book(start: Int, end: Int): Int = {
    segTree.add(start, end - 1, 1)
    segTree.root.saved
  }
}

//class MyCalendarThree() {
//  val delta = new java.util.TreeMap[Int, Int]()
//
//  def book(start: Int, end: Int): Int = {
//    delta.put(start, delta.getOrDefault(start, 0) + 1)
//    delta.put(end, delta.getOrDefault(end, 0) - 1)
//    var active, ans = 0
//    delta.values().forEach(new Consumer[Int] {
//      override def accept(t: Int): Unit = {
//        active += t
//        ans = Math.max(ans, active)
//      }
//    })
//    ans
//  }

//}