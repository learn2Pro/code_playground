/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.dfs._700_800

/**
  * 721. Accounts Merge
  */
object _721_Solution {
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val edge = new scala.collection.mutable.HashSet[(Int, Int)]
    val N = accounts.length
    val emailMapping = new java.util.HashMap[String, Int]
    for (i <- 0 until N) {
      val n = accounts(i).length
      for (j <- 1 until n) {
        if (emailMapping.containsKey(accounts(i)(j))) {
          //          if (emailMapping.get(accounts(i)(j)) != i)
          edge.add((emailMapping.get(accounts(i)(j)), i))
        } else {
          emailMapping.put(accounts(i)(j), i)
        }
      }
    }
    case class Dsu(size: Int) {
      val parent = Array.tabulate(size)(_ => -1)
      
      def find(x: Int): Int = {
        if (parent(x) < 0) return x
        find(parent(x))
      }
      
      def union(i: Int, j: Int): Unit = {
        val left = find(i)
        val right = find(j)
        val s0 = Math.abs(parent(left))
        val s1 = Math.abs(parent(right))
        if (left == right) return
        if (s0 > s1) {
          parent(right) = left
          parent(left) -= s1
        } else {
          parent(left) = right
          parent(right) -= s0
        }
      }
      
      def group(): List[List[Int]] = {
        var ans: List[List[Int]] = Nil
        var i = -1
        parent.map { v =>
          i += 1
          if (v < 0) i -> i else find(v) -> i
        }.groupBy(_._1).foreach { case (_, lst) =>
          ans ::= lst.map(_._2).toList
        }
        ans
      }
    }
    
    /*merge*/
    
    val dsu = Dsu(N)
    edge.foreach { case (src, dst) =>
      dsu.union(src, dst)
    }
    dsu.group().map { lst =>
      val head = lst.head
      val account = accounts(head).head
      account :: lst.flatMap { one =>
        accounts(one).tail
      }.distinct.sorted
    }
  }
}
