package category.math._700_800


/**
  * 794. Valid Tic-Tac-Toe State
  */
object _794_ValidTicTacToeState {
  
  import java.util
  
  trait Rule {
    def check(state: Array[String]): Boolean
  }
  
  class SizeChecker extends Rule {
    override def check(state: Array[String]): Boolean = state.length == 3 && state.forall(_.length == 3)
  }
  
  class TurnChecker extends Rule {
    override def check(state: Array[String]): Boolean = {
      val ops = new util.HashMap[Char, Int]()
      state.foreach(str => str.foreach(c => if (ops.containsKey(c)) ops.put(c, ops.get(c) + 1) else ops.put(c, 1)))
      ops.get('O') == ops.get('X') || ops.get('O') + 1 == ops.get('X')
    }
  }
  
  class StateChecker extends Rule {
    private def rowWin(c: Char, state: Array[String]) = {
      state.exists(_.forall(_ == c))
    }
    
    private def colWin(c: Char, state: Array[String]) = {
      Range(0, 3).exists(idx => state.forall(_ (idx) == c))
    }
    
    private def diagonalWin(c: Char, state: Array[String]) = {
      Array(Array(state(0)(0), state(1)(1), state(2)(2)), Array(state(0)(2), state(1)(1), state(2)(0)))
              .exists(chars => chars.forall(_ == c))
    }
    
    private def win(c: Char, state: Array[String]) = {
      rowWin(c, state) || colWin(c, state) || diagonalWin(c, state)
    }
    
    override def check(state: Array[String]): Boolean = {
      val winO = win('O', state)
      val winX = win('X', state)
      val ops = new util.HashMap[Char, Int]()
      state.foreach(str => str.foreach(c => if (ops.containsKey(c)) ops.put(c, ops.get(c) + 1) else ops.put(c, 1)))
      if (winX && winO) false
      else if (winX && !winO) ops.get('O') + 1 == ops.get('X')
      else if (!winX && winO) ops.get('O') == ops.get('X')
      else true
    }
  }
  
  def validTicTacToe(board: Array[String]): Boolean = {
    Array(new StateChecker, new TurnChecker, new SizeChecker).forall(_.check(board))
  }
}