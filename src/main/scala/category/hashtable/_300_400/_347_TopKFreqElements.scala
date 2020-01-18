/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.hashtable._300_400

/**
  * 347. Top K Frequent Elements
  */
object _347_TopKFreqElements {
  def topKFrequent(nums: Array[Int], k: Int): List[Int] = {
    val mapping = new scala.collection.mutable.HashMap[Int, Int]
    nums.foreach { num =>
      mapping.put(num, mapping.getOrElse(num, 0) + 1)
    }
    mapping.toList.sortBy(_._2)(new Ordering[Int] {
      override def compare(x: Int, y: Int): Int = y - x
    }).map(_._1).slice(0, k)
  }
}
