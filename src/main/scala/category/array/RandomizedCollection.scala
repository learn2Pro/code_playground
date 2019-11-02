package category.array

import java.util.Random

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class RandomizedCollection() {
  
  /** Initialize your data structure here. */
  val num2Index               = new mutable.HashMap[Int, mutable.Set[Int]]
  var array: ArrayBuffer[Int] = new ArrayBuffer[Int]()
  val ran                     = new Random()
  
  
  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  def insert(`val`: Int): Boolean = {
    array.append(`val`)
    if (num2Index.contains(`val`)) {
      num2Index.put(`val`, mutable.Set(array.length - 1) ++ num2Index(`val`))
      false
    } else {
      num2Index.put(`val`, mutable.Set(array.length - 1))
      true
    }
  }
  
  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  def remove(`val`: Int): Boolean = {
    if (num2Index.contains(`val`) && num2Index(`val`).nonEmpty) {
      val indexes = num2Index(`val`)
      val theNumIndex = indexes.head
      val last = array.last
      array(theNumIndex) = last
      num2Index(`val`).remove(theNumIndex)
      num2Index(last).add(theNumIndex)
      num2Index(last).remove(array.size - 1)
      array.remove(array.size - 1)
      true
    } else {
      false
    }
    
  }
  
  /** Get a random element from the collection. */
  def getRandom(): Int = {
    array(ran.nextInt(array.length))
  }
  
}

/**
  * Your RandomizedCollection object will be instantiated and called as such:
  * var obj = new RandomizedCollection()
  * var param_1 = obj.insert(`val`)
  * var param_2 = obj.remove(`val`)
  * var param_3 = obj.getRandom()
  */