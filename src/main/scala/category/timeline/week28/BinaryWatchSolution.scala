package category.timeline.week28

import java.util

import scala.collection.mutable.ArrayBuffer

/**
  * @author tang
  * @date 2019/07/13
  */
object BinaryWatchSolution {
  def readBinaryWatch(num: Int): List[String] = {
    (for (hour <- 0 to num) yield {
      val minute = num - hour
      val hours = findHour(hour)
      val minutes = findMinute(minute)
      (for (hh <- hours) yield {
        for (mm <- minutes) yield {
          hh + ":" + mm
        }
      }).flatten
    }).flatten.toList
  }

  def findHour(on: Int): ArrayBuffer[String] = {
    val bitSet = new java.util.BitSet(4)
    pick(bitSet, on, 4 - on, 0).map {
      bitSet =>
        bitSet2String(bitSet, 4)
    }.filter(_ != null)
  }

  def findMinute(on: Int): ArrayBuffer[String] = {
    val bitSet = new java.util.BitSet(6)
    pick(bitSet, on, 6 - on, 0).map {
      bitSet =>
        val str = bitSet2String(bitSet, 6)
        if (str != null && str.length == 1) {
          "0" + str
        } else {
          str
        }
    }.filter(_ != null)
  }

  def bitSet2String(bitSet: util.BitSet, len: Int) = {
    var ans = 0
    var idx = 0
    while (idx < len) {
      if (bitSet.get(idx)) {
        ans += 1 << idx
      }
      idx += 1
    }
    //hour
    if (len == 4) {
      if (ans >= 0 && ans < 12) {
        ans.toString
      } else {
        null
      }
    } else {
      if (ans >= 0 && ans <= 59) {
        ans.toString
      } else {
        null
      }
    }
  }

  def pick(bitSet: java.util.BitSet, one: Int, zero: Int, idx: Int): ArrayBuffer[util.BitSet] = {
    val tmp = bitSet.clone().asInstanceOf[util.BitSet]
    //end
    if (zero == 1 && one == 0) {
      tmp.clear(idx)
      ArrayBuffer(tmp)
    }
    else if (zero == 0 && one == 1) {
      tmp.set(idx)
      ArrayBuffer(tmp)
    }
    //iter
    else {
      val buffer = new ArrayBuffer[util.BitSet]()
      if (zero > 0) {
        tmp.clear(idx)
        buffer ++= pick(tmp, one, zero - 1, idx + 1)
      }
      if (one > 0) {
        tmp.set(idx)
        buffer ++= pick(tmp, one - 1, zero, idx + 1)
      }
      buffer
    }
  }

}
