package category.segment_tree

/**
  * 699. Falling Squares
  */
object _699_Solution {
  
  case class SegTree(size: Int) {
    val seg   = new Array[Int](size << 2)
    val _lazy = new Array[Int](size << 2)
    
    def push(index: Int, isLeaf: Boolean): Unit = {
      if (!isLeaf) _lazy(index * 2) = Math.max(_lazy(index), _lazy(index * 2))
      if (!isLeaf) _lazy(index * 2 + 1) = Math.max(_lazy(index), _lazy(index * 2 + 1))
      seg(index) = Math.max(_lazy(index), seg(index))
      _lazy(index) = 0
    }
    
    def updateRange(i: Int, j: Int, v: Int): Unit = {
      def update0(index: Int, lo: Int, hi: Int, left: Int, right: Int): Unit = {
        if (_lazy(index) != 0) push(index, lo == hi)
        if (left > right) return
        if (left <= lo && right >= hi) {seg(index) = v; _lazy(index) = v; return}
        val mid = (lo + hi) >>> 1
        update0(index * 2, lo, mid, left, Math.min(right, mid))
        update0(index * 2 + 1, mid + 1, hi, Math.max(mid + 1, left), right)
        seg(index) = Math.max(seg(index * 2), seg(index * 2 + 1))
      }
      
      update0(1, 0, size - 1, i, j)
    }
    
    def lazyQuery(i: Int, j: Int): Int = {
      if (i > j) throw new RuntimeException("range must positive!")
      
      def query0(index: Int, lo: Int, hi: Int, l: Int, r: Int): Int = {
        if (l > r) return 0
        if (_lazy(index) != 0) push(index, lo == hi)
        if (l == lo && r == hi) return seg(index)
        val mid = (lo + hi) >>> 1
        Math.max(
          query0(index * 2, lo, mid, l, Math.min(r, mid)),
          query0(index * 2 + 1, mid + 1, hi, Math.max(mid + 1, l), r)
        )
      }
      
      query0(1, 0, size - 1, i, j)
    }
    
    //    def update(pos: Int, v: Int): Unit = {
    //      if (pos < 0 || pos >= size) return
    //
    //      def update0(index: Int, lo: Int, hi: Int): Unit = {
    //        if (lo == hi) {seg(index) = v; return}
    //        val mid = (lo + hi) >>> 1
    //        if (pos <= mid) update0(index * 2, lo, mid)
    //        else update0(index * 2 + 1, mid + 1, hi)
    //        seg(index) = Math.max(seg(index * 2), seg(index * 2 + 1))
    //      }
    //
    //      update0(1, 0, size - 1)
    //    }
    //
    //    def query(i: Int, j: Int): Int = {
    //      if (i > j) throw new RuntimeException("range must positive!")
    //
    //      def query0(index: Int, lo: Int, hi: Int, l: Int, r: Int): Int = {
    //        if (l > r) return 0
    //        if (l == lo && r == hi) return seg(index)
    //        val mid = (lo + hi) >>> 1
    //        Math.max(
    //          query0(index * 2, lo, mid, l, Math.min(r, mid)),
    //          query0(index * 2 + 1, mid + 1, hi, Math.max(mid + 1, l), r)
    //        )
    //      }
    //
    //      query0(1, 0, size - 1, i, j)
    //    }
  }
  
  def fallingSquares(positions: Array[Array[Int]]): List[Int] = {
    val points = positions.flatMap { case _@Array(left, sz) =>
      Iterator(left, left + sz - 1)
    }.distinct.sorted.zipWithIndex.toMap
    val segTree = SegTree(points.size)
    var ans: List[Int] = Nil
    var maxHeight = 0
    positions.foreach { case _@Array(left, sz) =>
      /*avoid 2/2*/
      val p0 = points(left)
      val p1 = points(left + sz - 1)
      val h = segTree.lazyQuery(p0, p1)
      maxHeight = Math.max(maxHeight, h + sz)
      ans ::= maxHeight
      segTree.updateRange(p0, p1, h + sz)
    }
    ans.reverse
  }
  
  //  def fallingSquares(positions: Array[Array[Int]]): List[Int] = {
  //    val tree = new util.TreeMap[Int, (Int, Int)]()
  //    var max = 0
  //    var ans: List[Int] = Nil
  //    positions.foreach { case _@Array(left, sideLength) =>
  //      val floor = tree.floorEntry(left)
  //      val ceil = tree.ceilingEntry(left)
  //      if (floor != null && ceil != null) {
  //        val (w0, h0) = floor.getValue
  //        val (w1, h1) = ceil.getValue
  //        var origin = sideLength
  //        if (floor.getKey + w0 > left) origin = Math.max(origin, sideLength + h0)
  //        if (left + sideLength > ceil.getKey) origin = Math.max(origin, sideLength + h1)
  //      }
  //    }
  //  }
}