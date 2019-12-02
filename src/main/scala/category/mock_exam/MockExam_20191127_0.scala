package category.mock_exam

/**
  *
  */
object MockExam_20191127_0 {
  def judgeCircle(moves: String): Boolean = {
    if (moves.isEmpty) return true
    var lr, ud = 0
    moves.foreach {
      case 'L' =>
        lr -= 1
      case 'R' =>
        lr += 1
      case 'U' =>
        ud -= 1
      case 'D' =>
        ud += 1
    }
    lr == 0 && ud == 0
  }
}