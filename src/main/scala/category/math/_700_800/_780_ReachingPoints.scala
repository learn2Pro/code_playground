package category.math._700_800



/**
  * 780. Reaching Points
  */
object _780_ReachingPoints {
  import scala.annotation.tailrec
  @tailrec
  def reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean = {
    if (sx > tx || sy > ty) return false
    if (sx == tx && (ty - sy) % sx == 0) return true
    if (sy == ty && (tx - sx) % sy == 0) return true
    reachingPoints(sx, sy, tx % ty, ty % tx)
  }
}