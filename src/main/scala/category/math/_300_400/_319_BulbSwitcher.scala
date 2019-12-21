package category.math._300_400

/**
  * 319. Bulb Switcher
  */
object _319_BulbSwitcher {
  def bulbSwitch(n: Int): Int = {
    
    def divisorNum(num: Int): Int = {
      var i = 2
      var ans = 0
      while (i * i <= num) {
        if (num % i == 0) {
          ans += (if (i * i == num) 1 else 2)
        }
        i += 1
      }
      ans
    }
    
    Math.sqrt(n).toInt
  }
}