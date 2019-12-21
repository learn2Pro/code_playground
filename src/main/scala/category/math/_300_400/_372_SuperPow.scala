package category.math._300_400

/**
  * 372. Super Pow
  */
object _372_SuperPow {
  def superPow(a: Int, b: Array[Int]): Int = {
    val MOD = 1337
    
    def pow(x: Long, y: Long): Long = {
      if (y == 0) return 1
      if (y == 1) return x % MOD
      (pow(x % MOD, y / 2) % MOD * pow(x % MOD, y - y / 2) % MOD) % MOD
    }
    
    val ans = b.foldLeft(1L) { case (x, y) =>
      (pow(x, 10) * pow(a, y)) % MOD
    }
    (ans % MOD).toInt
  }
}