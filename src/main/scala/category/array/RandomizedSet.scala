package category.array

import java.util.Random

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class RandomizedSet() {
  
  /** Initialize your data structure here. */
  val data                    = new mutable.HashSet[Int]
  var array: ArrayBuffer[Int] = new ArrayBuffer[Int]()
  val ran                     = new Random()
  
  
  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  def insert(`val`: Int): Boolean = {
    if (data.contains(`val`)) return false
    array.append(`val`)
    data.add(`val`)
  }
  
  /** Removes a value from the set. Returns true if the set contained the specified element. */
  def remove(`val`: Int): Boolean = {
    if (!data.contains(`val`)) return false
    array.remove(removeNumIndex(`val`))
    data.remove(`val`)
  }
  
  /** Get a random element from the set. */
  def getRandom(): Int = {
    array(ran.nextInt(data.size))
  }
  
  def removeNumIndex(num: Int): Int = {
    array.foldLeft(0) { case (idx, inner) =>
      if (inner == num) return idx
      idx + 1
    }
  }
  
}

/**
  * Your RandomizedSet object will be instantiated and called as such:
  * var obj = new RandomizedSet()
  * var param_1 = obj.insert(`val`)
  * var param_2 = obj.remove(`val`)
  * var param_3 = obj.getRandom()
  */