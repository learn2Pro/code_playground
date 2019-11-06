/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._400_500

/**
  * 457. Circular Array Loop
  */
object _457_ArrayCircular {
  
  import scala.collection.mutable
  
  def circularArrayLoop(nums: Array[Int]): Boolean = {
    val visited = new mutable.HashSet[Int]
    val multi = 1000 / nums.length + 1
    
    def visit(start: Int): Boolean = {
      /*is loop logic*/
      var hare, tortoise = start
      var loop = 0
      
      def next(index: Int): Int = {
        visited.add(index)
        (nums(index) + index + multi * nums.length) % nums.length
      }
      
      do {
        hare = next(next(hare))
        tortoise = next(tortoise)
        loop += 1
        if (loop > nums.length * 2) return false
      } while (hare != tortoise)
      
      var pointer = hare
      val state = nums(hare)
      
      loop = 0
      do {
        if (state * nums(pointer) < 0) return false
        pointer = next(pointer)
        loop += 1
      } while (pointer != hare)
      
      if (loop == 1) false else true
    }
    
    if (nums == null || nums.isEmpty) return false
    for (i <- nums.indices if !visited.contains(i)) {
      val res = visit(i)
      if (res) return true
    }
    false
  }
}
