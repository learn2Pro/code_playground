package category.mock_exam

object MockExam_20191130_1 {
  def canWinNim(n: Int): Boolean = {
    if (n <= 3) return true
    var i0 = true
    var i1 = true
    var i2 = true
    
    var tmp = false
    for (_ <- 4 to n) {
      tmp = !i0 || !i1 || !i2
      i0 = i1
      i1 = i2
      i2 = tmp
    }
    tmp
  }
}