package category.string._500_600

/**
  * 551. Student Attendance Record I
  */
object _551_StudentAttendanceRecordI {
  def checkRecord(s: String): Boolean = {
    var absentCount = 0
    var continuousLate = 0
    for (i <- s.indices) {
      if (s(i) == 'A') {
        continuousLate = 0
        absentCount += 1
        if (absentCount >= 2) return false
      } else if (s(i) == 'L') {
        continuousLate += 1
        if (continuousLate >= 3) return false
      } else {
        continuousLate = 0
      }
    }
    true
  }
}