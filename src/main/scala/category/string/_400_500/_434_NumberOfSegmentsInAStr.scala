package category.string._400_500

/**
  * 434. Number of Segments in a String
  */
object _434_NumberOfSegmentsInAStr {
  def countSegments(s: String): Int = {
    val trimmed = s.trim
    if (trimmed == "") return 0
    trimmed.split("\\s+").length
  }
}