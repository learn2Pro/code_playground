package category.time.week37


object GrayCode {

  import java.util

  def grayCode(n: Int): List[Int] = {
    if (n == 0) return List(0)
    val bs = new java.util.BitSet(n)
    val alreadyAdded = new util.HashSet[Int]()
    var len = 1
    val limit = 1 << n
    var ans: List[Int] = List(0)
    alreadyAdded.add(0)
    var i = 0
    while (len < limit && i < n) {
      bs.flip(i)
      if (!alreadyAdded.contains(bitset2Int(bs))) {
        val newlyFinded = bitset2Int(bs)
        alreadyAdded.add(newlyFinded)
        ans = ans ++ List(newlyFinded)
        len += 1
        i = 0
      } else {
        bs.flip(i)
        i += 1
      }
    }
    ans
  }

  private def bitset2Int(bs: java.util.BitSet) = {
    var ans = 0
    for (i <- 0 until bs.length()) {
      val bit = if (bs.get(i)) 1 else 0
      ans += bit << i
    }
    ans
  }
}