package category.timeline.week37


/**
  * 93. Restore IP Addresses
  */
object RestoreIPAddresses {

  import scala.collection.mutable.ArrayBuffer

  def restoreIpAddresses(s: String): List[String] = {
    val ans = new ArrayBuffer[String]()
    acquireSplits(s, "", 4, ans)
    ans.toList
  }

  private def acquireSplits(s: String, prefix: String, size: Int, input: ArrayBuffer[String]): Unit = {
    if (size == 1) {
      if (restrictInIpSeg(s)) {
        input += prefix.substring(1) + "." + s
      }
      return
    }
    if (restrictInIpSeg(s.slice(0, 1))) {
      val seg = s.slice(1, s.length)
      acquireSplits(seg, prefix + "." + s.slice(0, 1), size - 1, input)
    }
    if (restrictInIpSeg(s.slice(0, 2))) {
      val seg = s.slice(2, s.length)
      acquireSplits(seg, prefix + "." + s.slice(0, 2), size - 1, input)
    }
    if (restrictInIpSeg(s.slice(0, 3))) {
      val seg = s.slice(3, s.length)
      acquireSplits(seg, prefix + "." + s.slice(0, 3), size - 1, input)
    }
  }

  private def restrictInIpSeg(s: String): Boolean = {
    if (s.isEmpty) {
      false
    } else {
      if (s.length == 1) {
        s(0) >= '0' && s(0) <= '9'
      }
      else if (s.length == 2) {
        s(0) >= '1' && s(0) <= '9' && s(1) >= '0' && s(1) <= '9'
      }
      else if (s.length == 3) {
        (s(0) == '1' && s(1) >= '0' && s(1) <= '9' && s(2) >= '0' && s(2) <= '9') ||
                (s(0) == '2' && s(1) >= '0' && s(1) <= '4' && s(2) >= '0' && s(2) <= '9') ||
                (s(0) == '2' && s(1) == '5' && s(2) >= '0' && s(2) <= '5')
      }
      else false
    }
  }
}