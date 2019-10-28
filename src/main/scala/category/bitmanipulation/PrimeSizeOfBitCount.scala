package category.bitmanipulation

/**
  * 762. Prime Number of Set Bits in Binary Representation
  */
object PrimeSizeOfBitCount {
  def countPrimeSetBits(L: Int, R: Int): Int = {
    
    def isPrime(input: Int): Boolean = {
      input == 2 || input == 3 || input == 5 || input == 7 ||
              input == 11 || input == 13 || input == 17 || input == 19
    }
    
    var ans = 0
    for (i <- Range(L, R + 1, 1) if isPrime(Integer.bitCount(i))) {
      ans += 1
    }
    ans
    
  }
}