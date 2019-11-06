/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._600_700

/**
  * 605. Can Place Flowers
  */
object _605_PlaceFlowers {
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    def canPlace(idx: Int) = {
      if (idx == 0) {
        if (flowerbed.length == 1) flowerbed(idx) != 1
        else flowerbed(idx + 1) != 1 && flowerbed(idx) != 1
      }
      else if (idx == flowerbed.length - 1) flowerbed(idx - 1) != 1 && flowerbed(idx) != 1
      else {
        flowerbed(idx - 1) != 1 && flowerbed(idx + 1) != 1 && flowerbed(idx) != 1
      }
    }
    
    var remain = n
    for (i <- flowerbed.indices if canPlace(i)) {
      remain -= 1
      if (remain <= 0) return true
      flowerbed(i) = 1
    }
    remain <= 0
  }
}
