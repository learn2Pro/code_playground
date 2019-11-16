/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._700_800


/**
  * 775. Global and Local Inversions
  */
object _775_GlobalAndLocalInversions {
  
  def isIdealPermutation(A: Array[Int]): Boolean = {
    var local = 0
    var global = Math.max(2 * A(0) - 1, 0)
    for (i <- 1 until A.length) {
      if (A(i - 1) < A(i)) {
        global += Math.max(2 * Math.abs(A(i) - i) - 1, 0)
      } else {
        local += 1
      }
    }
    local == global
  }
  
  //    def isIdealPermutation(A: Array[Int]): Boolean = {
  //      val stack = new java.util.Stack[Int]
  //      var local, global = 0
  //      for (i <- A.indices) {
  //        if (stack.isEmpty || stack.peek() < A(i)) {
  //          stack.push(A(i))
  //          global += Math.abs(A(i) - i)
  //        }
  //        else {
  //          local += 1
  //          while (!stack.isEmpty && stack.peek() > A(i)) {
  //            stack.pop()
  //          }
  //          stack.push(A(i))
  //        }
  //      }
  //      local == global
  //    }
}
