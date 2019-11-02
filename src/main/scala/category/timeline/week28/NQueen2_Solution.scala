package category.timeline.week28

import java.util

import scala.collection.mutable.ArrayBuffer

/**
  * @author tang
  * @date 2019/07/14
  */
object NQueen2_Solution {
  def totalNQueens(n: Int): Int = {
    val constraints = QueenXConstraints(new java.util.HashMap[Int, MaskLookUp], n)
    solve(n, n, constraints)
  }

  private def solve(n: Int, size: Int, constraints: QueenXConstraints): Int = {
    //success exit
    if (n == 1 && constraints.searchExcludeSize(size - n) == size - n) {
      constraints.searchInclude(size - n).length
    }
    //prune
    else if (constraints.searchExcludeSize(size - n) == size) {
      0
    } else {
      val ans = (for (i <- 0 until size if !constraints.inConstraints(size - n, i)) yield {
        constraints.addConstraints(size - n, i)
        val solved = 1 * solve(n - 1, size, constraints)
        constraints.removeConstraints(size - n, i)
        solved
      }).sum
      ans
    }
  }

  case class MaskLookUp(loopUp: java.util.HashMap[Int, Int] = new util.HashMap[Int, Int]()) {
    def add(num: Int) = {
      if (loopUp.containsKey(num)) {
        loopUp.put(num, loopUp.get(num) + 1)
      } else {
        loopUp.put(num, 1)
      }
    }

    def del(num: Int) = {
      if (loopUp.containsKey(num)) {
        val v = loopUp.get(num)
        if (v - 1 == 0) {
          loopUp.remove(num)
        } else {
          loopUp.put(num, v - 1)
        }
      }
    }

    def contains(k: Int) = {
      loopUp.containsKey(k)
    }
  }

  case class QueenXConstraints(mask: java.util.HashMap[Int, MaskLookUp], size: Int) {

    private def addXy(x: Int, y: Int) = {
      if (mask.containsKey(x)) {
        mask.get(x).add(y)
      } else {
        val coordinator = MaskLookUp()
        coordinator.add(y)
        mask.put(x, coordinator)
      }
    }

    private def removeXy(x: Int, y: Int): Unit = {
      if (mask.containsKey(x)) {
        mask.get(x).del(y)
      }
    }

    private def addColumnExclude(col: Int) = {
      for (i <- 0 until size) {
        addXy(i, col)
      }
    }

    private def removeColumnExclude(col: Int) = {
      for (i <- 0 until size) {
        removeXy(i, col)
      }
    }

    private def addLeftDiagonal(x: Int, y: Int) = {
      var tmpX = x + 1
      var tmpY = y - 1
      while (tmpX >= 0 && tmpX < size && tmpY >= 0 && tmpY < size) {
        addXy(tmpX, tmpY)
        tmpX += 1
        tmpY -= 1
      }
    }

    private def removeLeftDiagonal(x: Int, y: Int) = {
      var tmpX = x + 1
      var tmpY = y - 1
      while (tmpX >= 0 && tmpX < size && tmpY >= 0 && tmpY < size) {
        removeXy(tmpX, tmpY)
        tmpX += 1
        tmpY -= 1
      }
    }

    private def addRightDiagonal(x: Int, y: Int) = {
      var tmpX = x + 1
      var tmpY = y + 1
      while (tmpX >= 0 && tmpX < size && tmpY >= 0 && tmpY < size) {
        addXy(tmpX, tmpY)
        tmpX += 1
        tmpY += 1
      }
    }

    private def removeRightDiagonal(x: Int, y: Int) = {
      var tmpX = x + 1
      var tmpY = y + 1
      while (tmpX >= 0 && tmpX < size && tmpY >= 0 && tmpY < size) {
        removeXy(tmpX, tmpY)
        tmpX += 1
        tmpY += 1
      }
    }

    def addConstraints(row: Int, col: Int) = {
      addColumnExclude(col)
      addLeftDiagonal(row, col)
      addRightDiagonal(row, col)
    }

    def removeConstraints(row: Int, col: Int) = {
      removeColumnExclude(col)
      removeLeftDiagonal(row, col)
      removeRightDiagonal(row, col)
    }

    def searchExcludeSize(row: Int) = {
      val constraints = mask.get(row)
      if (constraints == null) {
        0
      } else {
        constraints.loopUp.size()
      }
    }

    def searchInclude(row: Int) = {
      val buffer = new ArrayBuffer[ArrayBuffer[Int]]()
      for (i <- 0 until size if !inConstraints(row, i)) {
        buffer.append(ArrayBuffer(i))
      }
      buffer
    }

    def inConstraints(row: Int, col: Int) = {
      val constraints = mask.get(row)
      if (constraints != null) {
        mask.get(row).contains(col)
      } else {
        false
      }
    }

  }

}


