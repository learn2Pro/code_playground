package category.string._600_700

/**
  * 657. Robot Return to Origin
  */
object _657_RobotReturnToOrigin {
  def judgeCircle(moves: String): Boolean = {
    if (moves.isEmpty) return true
    var row, col = 0
    moves.foreach {
      case 'L' =>
        row -= 1
      case 'R' =>
        row += 1
      case 'U' =>
        col += 1
      case 'D' =>
        col -= 1
    }
    row == 0 && col == 0
  }
}