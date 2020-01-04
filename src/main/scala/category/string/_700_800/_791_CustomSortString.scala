package category.string._700_800

/**
  * 791. Custom Sort String
  */
object _791_CustomSortString {
  def customSortString(S: String, T: String): String = {
    val mapping = S.zipWithIndex.toMap
    T.sortBy(identity)(new Ordering[Char] {
      override def compare(x: Char, y: Char): Int = {
        mapping.getOrElse(x, 27) - mapping.getOrElse(y, 27)
      }
    })
  }
}