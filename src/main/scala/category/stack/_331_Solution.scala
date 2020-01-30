package category.stack

import java.util

/**
  * 331. Verify Preorder Serialization of a Binary Tree
  * test case
  * "9,3,4,#,#,1,#,#,2,#,6,#,#"
  * "1,#"
  * "9,#,#,1"
  * "1,#,#"
  * "1,2,#,#,#"
  * "#,#,3,5,#"
  */
object _331_Solution {
  def isValidSerialization(preorder: String): Boolean = {
    val stack = new util.Stack[String]
    val elements = preorder.split(",")
    for (ele <- elements) {
      while (ele == "#" && !stack.empty() && stack.peek() == "#") {
        stack.pop()
        if (stack.empty()) return false
        stack.pop()
      }
      stack.push(ele)
    }
    stack.size() == 1 && stack.peek() == "#"
  }
  
  /*indegre-outdegree == 0*/
  //  def isValidSerialization(preorder: String): Boolean = {
  //    val elements = preorder.split(',')
  //    var diff = 1
  //    for (ele <- elements) {
  //      if ( {diff -= 1; diff} < 0) return false
  //      if (!(ele == "#")) diff += 2
  //    }
  //    diff == 0
  //  }
}