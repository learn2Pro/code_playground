/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.heap

/**
  *
  * @author derong.tdr
  * @version QuickSort.scala, v 0.1 2020年01月27日 14:47 tang Exp $
  */
object QuickSort {
  def sort[T: Ordering](inputs: Array[T]): Array[T] = {
    def swap(i: Int, j: Int): Int = {
      val tmp = inputs(i)
      inputs(i) = inputs(j)
      inputs(j) = tmp
      j
    }
    
    def partition(start: Int, end: Int): Int = {
      import Ordered._
      val pivot = inputs(start)
      var i = start
      var j = end + 1
      while (true) {
        while (i < end && {i += 1; inputs(i) < pivot}) {}
        while (j > start && {j -= 1; inputs(j) > pivot}) {}
        if (i >= j) return swap(start, j)
        swap(i, j)
      }
      throw new IllegalAccessError("can not be here!")
    }
    
    def sort0(lo: Int, hi: Int): Unit = {
      if (lo >= hi) return
      val idx = partition(lo, hi)
      sort0(lo, idx - 1)
      sort0(idx + 1, hi)
    }
    
    sort0(0, inputs.length - 1)
    inputs
  }
  
}
