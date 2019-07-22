package week29

import scala.collection.mutable.ArrayBuffer


/**
  * @author tang
  * @date 2019/07/21
  */
object PrintBTreeSolutionV2 {

//  import java.util
//
//  def printTree(root: Nothing): List[List[String]] = {
//    val height = getHeight(root)
//    val res = new Array[Array[String]](height, (1 << height) - 1)
//    for (arr <- res) {
//      util.Arrays.fill(arr, "")
//    }
//    val ans = new ArrayBuffer[ArrayBuffer[String]]()
//    fill(res, root, 0, 0, res(0).length)
//    for (arr <- res) {
//      ans.add(util.Arrays.asList(arr))
//    }
//    ans
//  }
//
//  def fill(res: Array[Array[String]], root: TreeNode, i: Int, l: Int, r: Int): Unit = {
//    if (root == null) return
//    res(i)((l + r) / 2) = "" + root.value
//    fill(res, root.left, i + 1, l, (l + r) / 2)
//    fill(res, root.right, i + 1, (l + r + 1) / 2, r)
//  }
//
//  def getHeight(root: TreeNode): Int = {
//    if (root == null) return 0
//    1 + Math.max(getHeight(root.left), getHeight(root.right))
//  }

}
