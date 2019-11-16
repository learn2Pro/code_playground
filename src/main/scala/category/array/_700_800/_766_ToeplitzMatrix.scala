package category.array._700_800

/**
  * 766. Toeplitz Matrix
  */
object _766_ToeplitzMatrix {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    def shiftSame(first: Array[Int], second: Array[Int], shift: Int): Boolean = {
      for (i <- 0 until first.length - shift if i + shift < second.length) {
        if (first(i) != second(i + shift)) return false
      }
      true
    }
    
    /*compare row*/
    for (row <- 1 until matrix.length) {
      if (!shiftSame(matrix(0), matrix(row), row)) return false
    }
    
    val firstCol = matrix.map(_ (0))
    /*compare col*/
    for (col <- 1 until matrix(0).length) {
      if (!shiftSame(firstCol, matrix.map(_ (col)), col)) return false
    }
    true
    
  }
}