package week32

import java.util

import scala.collection.mutable.ArrayBuffer
import java.util.{HashMap, HashSet, Set => JSet, Map => JMap}

/**
  * Created by Administrator on 2019/8/11 0011.
  */
object Solution {
  def solveSudoku(board: Array[Array[Char]]): Unit = {
    new SolveSudoku(board).solveSudoku()
  }
}

class SolveSudoku(board: Array[Array[Char]],
                  rowCache: JMap[Int, Array[Char]] = new util.HashMap[Int, Array[Char]](),
                  colCache: JMap[Int, Array[Char]] = new util.HashMap[Int, Array[Char]](),
                  matrixCache: JMap[(Int, Int), Array[Char]] = new util.HashMap[(Int, Int), Array[Char]]()) {


  def solveSudoku(): Boolean = {
    var missingNum = 0
    for (i <- 0 until 9) {
      missingNum += fetchRow(board, i).count(_ == '.')
    }
    for (i <- 0 until 9) {
      fetchColumn(board, i).count(_ == '.')
    }
    for (x <- 0 until 3; y <- 0 until 3) {
      fetchMatrix(board, (x * 3, y * 3)).count(_ == '.')
    }
    solveNext(missingNum, board)
  }

  private def solveNext(missingNum: Int, board: Array[Array[Char]]): Boolean = {
    if (missingNum <= 0) return true
    var state = missingNum
    import scala.collection.JavaConversions._
    val rows = rowCache.map {
      case (k, v) => k -> v.count(_ != '.')
    }.filter(_._2 != 9)
    val maxRows = rows.filter(_._2 == rows.maxBy(_._2)._2)
    val cols = colCache.map {
      case (k, v) => k -> v.count(_ != '.')
    }.filter(_._2 != 9)
    val maxCols = cols.filter(_._2 == cols.maxBy(_._2)._2)
    val rowNums = (maxRows.keys ++ maxCols.flatMap {
      case (col, _) =>
        colCache.get(col).zipWithIndex.filter(_._1 == '.').map(_._2)
    }).toArray.distinct
    val colNums = (maxCols.keys ++ maxRows.flatMap {
      case (row, _) =>
        rowCache.get(row).zipWithIndex.filter(_._1 == '.').map(_._2)
    }).toArray.distinct

    for (x <- rowNums; y <- colNums if board(x)(y) == '.') {
      state -= findUnique((x, y), board)
    }
    if (state == missingNum) {
      for (x <- rowNums; y <- colNums if board(x)(y) == '.') {
        val v2 = findUniqueV2((x, y), board)
        if (!v2._2) return false
        else {
          state -= v2._1
        }
      }
    }
    solveNext(state, board)
  }

  def findUnique(position: (Int, Int), board: Array[Array[Char]]): Int = {
    val copy = createDigits
    rowCache.get(position._1).foreach(copy.remove)
    colCache.get(position._2).foreach(copy.remove)
    val coord = (position._1 / 3 * 3, position._2 / 3 * 3)
    matrixCache.get(coord).foreach(copy.remove)
    if (copy.size() == 1) {
      val update = copy.iterator().next()
      updateCache(position, update)
      updateBoard(position, update, board)
      1
    } else 0
  }

  def findUniqueV2(position: (Int, Int), board: Array[Array[Char]]): (Int, Boolean) = {
    val copy = createDigits
    rowCache.get(position._1).foreach(copy.remove)
    colCache.get(position._2).foreach(copy.remove)
    val coord = (position._1 / 3 * 3, position._2 / 3 * 3)
    matrixCache.get(coord).foreach(copy.remove)
    if (copy.size() == 1) {
      val update = copy.iterator().next()
      updateCache(position, update)
      updateBoard(position, update, board)
      1 -> true
    } else if (copy.size() == 2) {
      val iter = copy.iterator()
      val first = iter.next()
      val second = iter.next()
      val cp1 = copyBoard(board)
      updateBoard(position, first, cp1)
      if (new SolveSudoku(cp1).solveSudoku()) {
        copy2Board(board, cp1)
        return 81 -> true
      }
      val cp2 = copyBoard(board)
      updateBoard(position, second, cp2)
      if (new SolveSudoku(cp2).solveSudoku()) {
        copy2Board(board, cp2)
        return 81 -> true
      }
      return 81 -> false
    } else if (copy.size() == 0) {
      0 -> false
    } else {
      0 -> true
    }
  }

  def copy2Board(board: Array[Array[Char]], other: Array[Array[Char]]): Unit = {
    board.zip(other).foreach {
      case (arr0, arr1) =>
        arr1.copyToArray(arr0)
    }
  }

  def copyBoard(board: Array[Array[Char]]): Array[Array[Char]] = {
    val buffer = new ArrayBuffer[Array[Char]]()
    board.foreach {
      arr =>
        val newArr = new Array[Char](arr.length)
        arr.copyToArray(newArr)
        buffer.append(newArr)
    }
    buffer.toArray
  }

  def createDigits: JSet[Char] = {
    val digits: JSet[Char] = new util.HashSet()
    Array('1', '2', '3', '4', '5', '6', '7', '8', '9').foreach(digits.add)
    digits
  }

  private def updateBoard(position: (Int, Int), update: Char, board: Array[Array[Char]]): Unit = {
    board(position._1)(position._2) = update
  }

  private def updateCache(position: (Int, Int), update: Char): Unit = {
    rowCache.get(position._1)(position._2) = update
    colCache.get(position._2)(position._1) = update
    val coord = (position._1 / 3 * 3, position._2 / 3 * 3)
    matrixCache.get(coord)((position._1 - coord._1) * 3 + position._2 - coord._2) = update
  }

  private def fetchRow(board: Array[Array[Char]], position: Int): Array[Char] = {
    if (!rowCache.containsKey(position)) {
      rowCache.put(position, board(position))
    }
    rowCache.get(position)
  }

  private def fetchColumn(board: Array[Array[Char]], position: Int): Array[Char] = {
    if (!colCache.containsKey(position)) {
      val buffer = new ArrayBuffer[Char]()
      board.foldLeft(buffer) {
        case (holder, row) =>
          holder.append(row(position))
          buffer
      }
      colCache.put(position, buffer.toArray)
    }
    colCache.get(position)
  }

  private def fetchMatrix(board: Array[Array[Char]], position: (Int, Int)): Array[Char] = {
    if (!matrixCache.containsKey(position)) {
      val buffer = new ArrayBuffer[Char]()
      for (row <- position._1 until position._1 + 3; col <- position._2 until position._2 + 3) {
        buffer.append(board(row)(col))
      }
      matrixCache.put(position, buffer.toArray)
    }
    matrixCache.get(position)
  }

}
