package week29


/**
  * @author tang
  * @date 2019/07/21
  */
object PrintBTreeSolution {


  import scala.collection.mutable.ArrayBuffer

  def printTree(root: TreeNode): List[List[String]] = {
    val maxHeight = getHeight(root)
    val buffer = new ArrayBuffer[ArrayBuffer[String]](maxHeight)
    val width = getWidth(maxHeight - 1)
    for (i <- 0 until maxHeight) {
      val sub = new ArrayBuffer[String](width)
      for (i <- 0 until 2 * width + 1) {
        sub.append("")
      }
      buffer.append(sub)
    }
    printNode(root, 0, buffer, 0, width * 2 + 1)
    buffer.map(_.toList).toList
  }

  private def getHeight(node: TreeNode): Int = {
    if (node == null) return 0
    if (node.left == null && node.right == null) return 1
    Math.max(getHeight(node.left), getHeight(node.right)) + 1
  }

  private def printNode(node: TreeNode, height: Int, buffer: ArrayBuffer[ArrayBuffer[String]], l: Int, r: Int): Unit = {
    //print left and right
    if (node == null) return
    buffer(height)((l + r) / 2) = node.value.toString
    printNode(node.left, height + 1, buffer, l, l / 2 + r / 2)
    printNode(node.right, height + 1, buffer, (l + r + 1) / 2, r)
  }

  /**
    * 打印当前行
    *
    * @param height
    * @param maxHeight
    * @param node
    * @param buffer
    */
  private def printRow(height: Int, maxHeight: Int, node: TreeNode, buffer: ArrayBuffer[ArrayBuffer[String]]) = {
    if (node != null) {
      buffer(height).append(node.value.toString)
    } else {
      buffer(height).append("")
    }
  }

  /**
    * height range [0-9]
    *
    * @param height
    * @return
    */
  private def getWidth(height: Int): Int = {
    if (height == 0) return 0
    Math.pow(2, height).toInt - 1
  }

  //  private def adjustBtree(leftWidth: Int, rightWidth: Int, height: Int, buffer: ArrayBuffer[ArrayBuffer[String]]): Int = {
  //    if (leftWidth == -1 || rightWidth == -1) return Math.max(leftWidth, rightWidth)
  //    if (leftWidth < rightWidth) {
  //      var curr = (rightWidth - leftWidth) * 2
  //      for (i <- height + 1 until buffer.length - 1) {
  //        curr = curr / 2
  //        for (_ <- 0 until curr) {
  //          buffer(i).insert(0, "")
  //          buffer(i).insert(2 * rightWidth + 1, "")
  //        }
  //      }
  //
  //    } else if (leftWidth > rightWidth) {
  //      var curr = (rightWidth - leftWidth) * 2
  //      for (i <- height + 1 until buffer.length - 1) {
  //        curr = curr / 2
  //        for (_ <- 0 until curr) {
  //          buffer(i).insert(2 * leftWidth + 1, "")
  //          buffer(i).append("")
  //        }
  //      }
  //    }
  //    Math.max(leftWidth, rightWidth)
  //  }


}
