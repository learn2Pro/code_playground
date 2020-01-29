package category.bsearch._200_300



/**
  * 240. Search a 2D Matrix II
  */
object _240_Solution {
  import java.util
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    matrix.exists { partial =>
      util.Arrays.binarySearch(partial,target) >= 0
    }
  }
}