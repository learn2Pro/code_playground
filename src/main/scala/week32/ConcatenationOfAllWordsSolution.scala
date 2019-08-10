///**
//  * Alipay.com Inc.
//  * Copyright (c) 2004-2019 All Rights Reserved.
//  */
//package week32
//
//import java.util.{HashMap => JHashMap}
//
//import scala.collection.mutable
//import scala.collection.mutable.ArrayBuffer
//
///**
//  *
//  * @author derong.tdr
//  * @version ConcatenationOfAllWordsSolution.scala, v 0.1 2019年08月07日 22:16 tang Exp $
//  */
//object ConcatenationOfAllWordsSolution {
//
//  def findSubstring(s: String, words: Array[String]): List[Int] = {
//    if (s == null || s.isEmpty) return List.empty[Int]
//    if (words == null || words.isEmpty) return List.empty[Int]
//    if (s.toCharArray.distinct.length == 1 && words.distinct.length == 1) {
//      val range = s.length - words.map(_.length).sum
//      return List.range(0, range + 1)
//    }
//    val ans = new ArrayBuffer[Int]()
//    val holder = WordHolder.create(words)
//    val wordLen = words.head.length
//    val window = new mutable.Queue[String]
//    var coordinator: Int = 0
//    while (coordinator < s.length) {
//      coordinator += findNext(s, coordinator, wordLen, words.length, window, holder, ans)
//    }
//
//    ans.toList
//  }
//
//  /**
//    * 寻找下一个位置
//    *
//    */
//  private def findNext(s: String, coordinator: Int,
//                       wordLen: Int, size: Int,
//                       holder: WordHolder, ans: ArrayBuffer[Int]): Int = {
//    holder.add(s.substring(coordinator, coordinator + wordLen))
//    if (holder.counter == 0) ans += coordinator
//    if (coordinator - size * wordLen > 0) 0
//    0
//  }
//
//  private def propagate(s: String, coordinator: Int,
//                        wordLen: Int, window: mutable.Queue[String],
//                        copy: WordHolder, holder: WordHolder, ans: ArrayBuffer[Int]): Int = {
//    var idx = coordinator + window.length * wordLen
//    while (idx + wordLen <= s.length && copy.contains(s.substring(idx, idx + wordLen))) {
//      val curr = s.substring(idx, idx + wordLen)
//      copy.minus(curr)
//      window.enqueue(curr)
//      idx += wordLen
//    }
//    if (copy.isEmpty) {
//      ans += coordinator
//      wordLen
//    } else {
//      if (idx + wordLen > s.length) return s.length
//      val curr = s.substring(idx, idx + wordLen)
//      if (holder.contains(curr)) {
//        var idx = 0
//        while (window.nonEmpty && window.head != curr) {
//          window.dequeue()
//          idx += 1
//        }
//        if (window.nonEmpty) {
//          window.dequeue()
//          idx += 1
//        }
//        idx * wordLen
//      } else {
//        window.clear()
//        idx + 1 - coordinator
//      }
//    }
//  }
//}
//
//object WordHolder {
//  def create(words: Array[String]): WordHolder = {
//    val holder = new WordHolder()
//    words.foreach(holder.add)
//    holder
//  }
//}
//
//case class WordHolder(lookUp: JHashMap[String, Int] = new JHashMap[String, Int]()) {
//
//  var counter: Int = lookUp.keySet().size()
//
//  override def clone(): AnyRef = {
//    WordHolder(lookUp.clone().asInstanceOf[JHashMap[String, Int]])
//  }
//
//  def isEmpty: Boolean = lookUp.isEmpty
//
//  def contains(word: String): Boolean = lookUp.containsKey(word)
//
//  /**
//    * 添加
//    *
//    * @param word
//    */
//  def add(word: String): Unit = {
//    if (lookUp.containsKey(word)) {
//      val add = lookUp.get(word) + 1
//      if (add > 0) counter += 1
//      lookUp.put(word, add)
//    } else {
//      lookUp.put(word, 1)
//      counter += 1
//    }
//  }
//
//  /**
//    * 删除
//    *
//    * @param word
//    */
//  def minus(word: String): Unit = {
//    if (lookUp.containsKey(word)) {
//      val minus = lookUp.get(word) - 1
//      if (minus == 0) {
//        counter -= 1
//      }
//      lookUp.put(word, minus)
//    }
//  }
//}
