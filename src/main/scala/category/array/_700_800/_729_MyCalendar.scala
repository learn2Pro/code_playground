package category.array._700_800


/**
  * 729. My Calendar I
  */
class _729_MyCalendar() {
  
  import scala.collection.mutable.ArrayBuffer
  
  val schedule = new ArrayBuffer[Range](16)
  
  case class Range(start: Int, end: Int) {
    def intersect(other: Range): Boolean = {
      if (this.end <= other.start || other.end <= this.start) false
      else true
    }
  }
  
  def book(start: Int, end: Int): Boolean = {
    val input = Range(start, end)
    var lo = 0
    var hi = schedule.length - 1
    while (lo < hi) {
      val mid = (lo + hi) >>> 1
      if (schedule(mid).intersect(input)) return false
      if (schedule(mid).end < input.start) lo = mid + 1
      else hi = mid
    }
    if (lo < schedule.length && schedule(lo).intersect(input)) return false
    if (lo + 1 < schedule.length && schedule(lo + 1).intersect(input)) return false
    if (lo < schedule.length && input.start >= schedule(lo).end) schedule.insert(lo + 1, input)
    else schedule.insert(lo, input)
    true
  }
}