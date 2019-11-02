package category.array

/**
  * 289. Game of Life
  */
object GameOfLife {
  
  def gameOfLife(board: Array[Array[Int]]): Unit = {
    val m = board.length
    val n = board(0).length
    
    val rules = Array(
      LiveFewerThanTwo(board),
      LiveWithTwoOrThree(board),
      LiveOverThree(board),
      DeadWithThreeLive(board)
    )
    for (i <- 0 until m)
      for (j <- 0 until n) {
        rules.foreach(_.exec(i, j))
      }
    for (i <- 0 until m)
      for (j <- 0 until n) {
        if (board(i)(j) == -1) {
          board(i)(j) = 0
        }
        if (board(i)(j) == -2) {
          board(i)(j) = 1
        }
        
      }
    
  }
}

trait Rule {
  /*-1 is 1->0 */
  protected final val stateOfLive = Set(1, -1)
  /*-2 is 0->1 */
  protected final val stateOfDead = Set(0, -2)
  
  def board: Array[Array[Int]]
  
  def pass(x: Int, y: Int): Boolean
  
  def transition(x: Int, y: Int): Int
  
  lazy val m = board.length
  lazy val n = board(0).length
  
  def locate(x: Int, y: Int): Int = {
    if (x < 0 || x >= m) return 0
    if (y < 0 || y >= n) return 0
    val curr = board(x)(y)
    if (stateOfLive.contains(curr)) 1 else 0
  }
  
  def collectNeighbors(x: Int, y: Int): Int = {
    locate(x - 1, y) + locate(x + 1, y) + locate(x, y - 1) + locate(x, y + 1) +
            locate(x - 1, y - 1) + locate(x - 1, y + 1) + locate(x + 1, y - 1) + locate(x + 1, y + 1)
  }
  
  def exec(x: Int, y: Int) = {
    if (pass(x, y)) {
      board(x)(y) = transition(x, y)
    }
  }
}

case class LiveFewerThanTwo(board: Array[Array[Int]]) extends Rule {
  override def pass(x: Int, y: Int): Boolean = {
    stateOfLive.contains(board(x)(y)) && collectNeighbors(x, y) < 2
  }
  
  override def transition(x: Int, y: Int): Int = -1
}

case class LiveWithTwoOrThree(board: Array[Array[Int]]) extends Rule {
  override def pass(x: Int, y: Int): Boolean = {
    stateOfLive.contains(board(x)(y)) && (collectNeighbors(x, y) == 2 || collectNeighbors(x, y) == 3)
  }
  
  override def transition(x: Int, y: Int): Int = 1
}

case class LiveOverThree(board: Array[Array[Int]]) extends Rule {
  override def pass(x: Int, y: Int): Boolean = {
    stateOfLive.contains(board(x)(y)) && collectNeighbors(x, y) > 3
  }
  
  override def transition(x: Int, y: Int): Int = -1
}

case class DeadWithThreeLive(board: Array[Array[Int]]) extends Rule {
  override def pass(x: Int, y: Int): Boolean = {
    stateOfDead.contains(board(x)(y)) && collectNeighbors(x, y) == 3
  }
  
  override def transition(x: Int, y: Int): Int = -2
}