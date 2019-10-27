package category.time.week28

import scala.collection.mutable.ArrayBuffer

/**
  * @author tang
  * @date 2019/07/14
  */
object RelativeSortArrSolution {
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val remain = new ArrayBuffer[Int]()
    val relation = arr2.zipWithIndex.toMap
    val bufferArr = arr2.map(r => new ArrayBuffer[Int]())
    arr1.foreach {
      num =>
        if (relation.contains(num)) {
          bufferArr(relation(num)).append(num)
        } else {
          remain.append(num)
        }
    }
    (bufferArr.reduce(_ ++ _) ++ remain.sorted).toArray
  }
}
