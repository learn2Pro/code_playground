package category.hashtable._700_800


/**
  * 710. Random Pick with Blacklist
  */
class _710_RandomPickWithBlackList(_N: Int, _blacklist: Array[Int]) {
  
  import java.util.Random
  
  val entity = new scala.collection.mutable.HashMap[Int, Int]
  val RAN    = new Random()
  val REMAIN = _N - _blacklist.length
  if (_blacklist.length != 1) {
    val black = _blacklist.toSet
    var real = 0
    for (i <- 0 until _N if !black.contains(i)) {
      entity.put(real, i)
      real += 1
    }
  }
  
  
  def pick(): Int = {
    if (_blacklist.length != 1) entity(RAN.nextInt(REMAIN))
    else {
      val where = RAN.nextInt(REMAIN)
      if (where < _blacklist(0)) where
      else where + 1
    }
  }
  
}