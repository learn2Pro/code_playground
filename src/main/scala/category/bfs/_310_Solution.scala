/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.bfs

import java.util

/**
  * 310. Minimum Height Trees
  */
object _310_Solution {
  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
    if (n == 1) return List(0)
    val adjacencyList = Array.tabulate[java.util.Set[Int]](n)(_ => new util.HashSet[Int]())
    edges.foreach { case _@Array(s, e) =>
      adjacencyList(s).add(e)
      adjacencyList(e).add(s)
    }
    var N = n
    val leaves = new util.LinkedList[Int]()
    for (i <- adjacencyList.indices) {
      if (adjacencyList(i).size() <= 1) leaves.add(i)
    }
    while (N > 2) {
      val len = leaves.size()
      N -= len
      for (_ <- 0 until len) {
        val curr = leaves.remove()
        val index = adjacencyList(curr).iterator().next()
        val parent = adjacencyList(index)
        parent.remove(curr)
        if (parent.size() == 1) leaves.add(index)
      }
    }
    var ans: List[Int] = Nil
    while (!leaves.isEmpty) ans ::= leaves.remove()
    ans
  }
}
