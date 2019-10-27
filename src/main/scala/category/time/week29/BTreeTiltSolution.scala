package category.time.week29

/**
  * @author tang
  * @date 2019/07/21
  */
/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  * var value: Int = _value
  * var left: TreeNode = null
  * var right: TreeNode = null
  * }
  */
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object BTreeTiltSolution {
  def findTilt(root: TreeNode): Int = {
    searchTilt(root)._1
  }

  /**
    * return (tiltSum,numSum)
    *
    * @param node
    * @return
    */
  private def searchTilt(node: TreeNode): (Int, Int) = {
    if (node == null) return (0, 0)
    val left = searchTilt(node.left)
    val right = searchTilt(node.right)
    val tiltSum = Math.abs(left._2 - right._2) + left._1 + right._1
    val numSum = left._2 + right._2 + node.value
    tiltSum -> numSum
  }
}
