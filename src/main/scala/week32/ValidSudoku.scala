package week32

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 2019/8/11 0011.
  */
object ValidSudoku {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    var valid = true
    for (i <- 0 until 9) {
      valid = isValid(fetchRow(board, i))
      if (!valid) return false
    }
    for (i <- 0 until 9) {
      valid = isValid(fetchColumn(board, i))
      if (!valid) return false
    }
    for (x <- 0 until 3; y <- 0 until 3) {
      valid = isValid(fetchMatrix(board, (x * 3, y * 3)))
      if (!valid) return false
    }
    valid
  }

  private def fetchRow(board: Array[Array[Char]], position: Int): Array[Char] = {
    board(position)
  }

  private def fetchColumn(board: Array[Array[Char]], position: Int): Array[Char] = {
    val buffer = new ArrayBuffer[Char]()
    board.foldLeft(buffer) {
      case (holder, row) =>
        holder.append(row(position))
        buffer
    }
    buffer.toArray
  }

  private def fetchMatrix(board: Array[Array[Char]], position: (Int, Int)): Array[Char] = {
    val buffer = new ArrayBuffer[Char]()
    for (row <- position._1 until position._1 + 3; col <- position._2 until position._2 + 3) {
      buffer.append(board(row)(col))
    }
    buffer.toArray
  }

  private def isValid(arr: Array[Char]): Boolean = {
    val compare = arr.filter(_ != '.')
    compare.length == compare.distinct.length
  }

}
