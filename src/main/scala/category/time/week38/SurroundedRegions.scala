package category.time.week38


/**
  * 130. Surrounded Regions
  */
object SurroundedRegions {
  val TAG_X = 'X'
  val TAG_O = 'O'
  
  import java.util
  
  def solve(board: Array[Array[Char]]): Unit = {
    if (board == null || board.isEmpty || board(0).isEmpty) return
    case class Loc(x: Int, y: Int)
    def isBorder(loc: Loc): Boolean = {
      loc.x == 0 || loc.x == board.length - 1 ||
              loc.y == 0 || loc.y == board(0).length - 1
    }
    
    def isAlive(loc: Loc, coords: java.util.HashSet[Loc]): Boolean = {
      board(loc.x)(loc.y) == TAG_O && !coords.contains(Loc(loc.x, loc.y))
    }
    
    def next(loc: Loc, coords: java.util.HashSet[Loc]): List[Loc] = {
      for ((i, j) <- List((-1, 0), (0, -1), (1, 0), (0, 1)) if !coords.contains(Loc(loc.x + i, loc.y + j)) && coord(Loc(loc.x + i, loc.y + j)) == TAG_O) yield {
        val newly = Loc(loc.x + i, loc.y + j)
        newly
      }
    }
    
    def coord(loc: Loc): Char = {
      if (loc.x < 0 || loc.x >= board.length) null.asInstanceOf[Char]
      else if (loc.y < 0 || loc.y >= board(0).length) null.asInstanceOf[Char]
      else {
        board(loc.x)(loc.y)
      }
    }
    
    
    import scala.collection.JavaConversions._
    val alreadyPassed = new util.HashSet[Loc]()
    val m = board.length
    val n = board(0).length
    for (i <- 1 until m - 1)
      for (j <- 1 until n - 1 if board(i)(j) == TAG_O && !alreadyPassed.contains(Loc(i, j))) {
        val coords = new util.HashSet[Loc]()
        var alived = List(Loc(i, j)).filter(isAlive(_, coords))
        coords.add(Loc(i, j))
        var find = false
        while (!find && alived.nonEmpty) {
          if (alived.exists(isBorder)) {
            find = true
          } else {
            alived = alived.flatMap(next(_, coords)).distinct
          }
          alived.foreach(coords.add)
        }
        if (!find) {
          coords.foreach { loc =>
            board(loc.x)(loc.y) = TAG_X
          }
        } else {
          alreadyPassed.addAll(coords)
        }
      }
  }
  
}