package category.math._700_800

/**
  * 789. Escape The Ghosts
  */
object _789_EscapeTheGhosts {
  def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean = {
    def dis(current: Array[Int]): Int = {
      Math.abs(current(0) - target(0)) + Math.abs(current(1) - target(1))
    }
    
    val myRound = dis(Array(0, 0))
    ghosts.foreach { location =>
      if (dis(location) <= myRound) return false
    }
    true
  }
}