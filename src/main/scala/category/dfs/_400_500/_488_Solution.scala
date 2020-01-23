package category.dfs._400_500

/**
  * 488. Zuma Game
  */
object _488_Solution {
  def findMinStep(board: String, hand: String): Int = {
    
    def remove(board: StringBuilder): StringBuilder = {
      val N = board.length
      val sb = new StringBuilder
      var curr = 'X'
      var acc = 0
      for (i <- 0 until N) {
        if (board(i) == curr) acc += 1
        else {
          if (acc < 3) {
            for (j <- 0 until acc) sb.append(curr)
          }
          curr = board(i)
          acc = 1
        }
      }
      if (acc < 3) {
        for (_ <- 0 until acc) sb.append(curr)
      }
      if (board.equals(sb)) sb
      else remove(sb)
    }
    
    def min(curr: Int, other: Int): Int = {
      if (curr == -1) return other
      if (other == -1) return curr
      Math.min(curr, other)
    }
    
    val used = new java.util.HashSet[Int]
    val N = hand.length
    val holder = new Array[Int](26)
    hand.foreach(r => holder(r - 'A') += 1)
    
    def dfs(remainInBoard: StringBuilder, previous: Int): Int = {
      if (remainInBoard(0) == '#') return previous
      var j = 0
      var rs = 6
      val N = remainInBoard.length
      for (i <- 0 until N) {
        if (remainInBoard(i) != remainInBoard(j)) {
          val need = 3 - (i - j)
          if (holder(remainInBoard(j) - 'A') >= need) {
            holder(remainInBoard(j) - 'A') -= need
            val tmp = remainInBoard(j)
            rs = Math.min(rs, dfs(remove(remainInBoard.delete(j, i)), previous + need))
            for (_ <- 0 until (i - j)) remainInBoard.insert(j, tmp)
            holder(remainInBoard(j) - 'A') += need
          }
          j = i
        }
      }
      rs
    }
    //    def dfs(remainInBoard: StringBuilder, previous: Int, last: Int): Int = {
    //      if (remainInBoard.isEmpty) return previous
    //      if (used.size() == N) return -1
    //      var i = last
    //      var res = -1
    //      while (i < N) {
    //        if (!used.contains(i)) {
    //          used.add(i)
    //          for (j <- 0 to remainInBoard.length) {
    //            remainInBoard.insert(j, hand(i))
    //            res = min(res, dfs(remove(remainInBoard), previous + 1, i + 1))
    //            remainInBoard.deleteCharAt(j)
    //          }
    //          used.remove(i)
    //        }
    //        i += 1
    //      }
    //      res
    //    }
    
    //    dfs(new StringBuilder(board), 0, 0)
    val ans = dfs(new StringBuilder(board + "#"), 0)
    if (ans == 6) -1 else ans
    
  }
}