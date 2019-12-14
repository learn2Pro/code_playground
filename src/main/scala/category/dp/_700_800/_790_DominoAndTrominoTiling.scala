package category.dp._700_800


/**
  * 790. Domino and Tromino Tiling
  */
object _790_DominoAndTrominoTiling {
  
  import scala.annotation.tailrec
  
  val MOD = 1000000007
  
  @tailrec
  def numTilings(N: Int, a: Int = 0, b: Int = 1, c: Int = 1): Int = {
    if (N == 1) c else numTilings(N - 1, b, c, (c * 2 % MOD + a) % MOD)
  }
}