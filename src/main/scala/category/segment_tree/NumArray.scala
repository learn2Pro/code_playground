package category.segment_tree

/**
  * 307. Range Sum Query - Mutable
  */
class NumArray(_nums: Array[Int]) {
  /*start from index 1*/
  val N: Int = _nums.length
  val seg    = new Array[Int](_nums.length << 2)
  build(1, 0, N - 1)
  
  private def build(i: Int, lo: Int, hi: Int): Unit = {
    if (lo > hi) return
    if (lo == hi) {seg(i) = _nums(lo); return}
    val mid = (lo + hi) >>> 1
    build(i * 2, lo, mid)
    build(i * 2 + 1, mid + 1, hi)
    seg(i) = seg(i * 2) + seg(i * 2 + 1)
  }
  
  def update(i: Int, `val`: Int): Unit = {
    if (N == 0) return
    
    def update0(start: Int, lo: Int, hi: Int, pos: Int, v: Int): Unit = {
      if (lo == hi) {seg(start) = v; return}
      val mid = (lo + hi) >>> 1
      if (pos <= mid) update0(start * 2, lo, mid, pos, v)
      else update0(start * 2 + 1, mid + 1, hi, pos, v)
      seg(start) = seg(start * 2) + seg(start * 2 + 1)
    }
    
    update0(1, 0, N - 1, i, `val`)
  }
  
  def sumRange(i: Int, j: Int): Int = {
    if (N == 0) return 0
    
    def query0(start: Int, lo: Int, hi: Int, l: Int, r: Int): Int = {
      if (l > r) return 0
      if (l == lo && hi == r) return seg(start)
      val mid = (lo + hi) >>> 1
      query0(start * 2, lo, mid, l, Math.min(mid, r)) +
              query0(start * 2 + 1, mid + 1, hi, Math.max(l, mid + 1), r)
    }
    
    query0(1, 0, N - 1, Math.max(0, i), Math.min(N - 1, j))
  }
  
}