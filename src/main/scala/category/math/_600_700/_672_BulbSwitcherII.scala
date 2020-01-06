/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.math._600_700




/**
  * 672. Bulb Switcher II
  *
  * @author derong.tdr
  * @version _235_LcaOfBst.scala, v 0.1 2019年12月22日 17:40 tang Exp $
  */
object _672_BulbSwitcherII {
  
  import java.util
  import scala.collection.mutable
  def flipLights(n: Int, m: Int): Int = {
    val seen = new mutable.HashSet[Int]()
    val tmpN = Math.min(n, 6)
    val shift = Math.max(0, 6 - tmpN)
    var cand = 0
    while ( {cand < 16}) {
      val bcount = Integer.bitCount(cand)
      if (bcount % 2 == m % 2 && bcount <= m) {
        var lights = 0
        if (((cand >> 0) & 1) > 0) lights ^= 0x3f >> shift
        if (((cand >> 1) & 1) > 0) lights ^= 0x15 >> shift
        if (((cand >> 2) & 1) > 0) lights ^= 0x2a >> shift
        if (((cand >> 3) & 1) > 0) lights ^= 0x24 >> shift
        seen.add(lights)
      }
      
      {cand += 1; cand}
    }
    seen.size
  }
  
  def flipLightsV1(n: Int, m: Int): Int = {
    if (n == 0 || m == 0) return 1
    val bs0 = new util.BitSet(n)
    val bs1 = new util.BitSet(n)
    val bs2 = new util.BitSet(n)
    val bs3 = new util.BitSet(n)
    for (i <- 1 to n) {
      bs0.set(i - 1)
      if (i % 2 == 0) bs1.set(i - 1)
      if (i % 2 == 1) bs2.set(i - 1)
      if (i % 3 == 1) bs3.set(i - 1)
    }
    var set = Set(
      bs0.clone().asInstanceOf[util.BitSet], bs1.clone().asInstanceOf[util.BitSet],
      bs2.clone().asInstanceOf[util.BitSet], bs3.clone().asInstanceOf[util.BitSet]
    )
    for (_ <- 1 until m) {
      set = set.flatMap { inner =>
        val p0 = inner.clone().asInstanceOf[util.BitSet]
        val p1 = inner.clone().asInstanceOf[util.BitSet]
        val p2 = inner.clone().asInstanceOf[util.BitSet]
        val p3 = inner.clone().asInstanceOf[util.BitSet]
        p0.xor(bs0)
        p1.xor(bs1)
        p2.xor(bs2)
        p3.xor(bs3)
        Iterator(p0, p1, p2, p3)
      }
    }
    set.size
  }
}
