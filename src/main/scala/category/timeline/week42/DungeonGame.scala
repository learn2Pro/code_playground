package category.timeline.week42

/**
  * 174. Dungeon Game
  */
object DungeonGame {
  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
    if (dungeon == null || dungeon.isEmpty || dungeon(0).isEmpty) return 0
    val row = dungeon.length
    val col = dungeon(0).length
    val dp = Array.tabulate[Int](dungeon.length, dungeon(0).length)((_, _) => 0)
    
    dp(row - 1)(col - 1) = Math.max(1, 1 - dungeon(row - 1)(col - 1))
    /* last row initial */
    for (j <- Range(col - 2, -1, -1)) {
      dp(row - 1)(j) = Math.max(1, dp(row - 1)(j + 1) - dungeon(row - 1)(j))
    }
    /* last column initial */
    for (i <- Range(row - 2, -1, -1)) {
      dp(i)(col - 1) = Math.max(1, dp(i + 1)(col - 1) - dungeon(i)(col - 1))
    }
    for (i <- Range(row - 2, -1, -1))
      for (j <- Range(col - 2, -1, -1)) {
        dp(i)(j) = Math.max(1, Math.min(dp(i + 1)(j) - dungeon(i)(j), dp(i)(j + 1) - dungeon(i)(j)))
      }
    dp(0)(0)
  }
}