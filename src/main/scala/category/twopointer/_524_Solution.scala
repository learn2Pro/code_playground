package category.twopointer

/**
  * 524. Longest Word in Dictionary through Deleting
  * test case:
  * "abpcplea"
  * ["ale","apple","monkey","plea"]
  * "abpcplea"
  * ["a","b","c"]
  * "abpcplea"
  * []
  * "abpcplea"
  * []
  * "abpcplea"
  * ["f","g"]
  * "abpcplea"
  * ["apple","appleg"]
  * ""
  * []
  * ""
  * ["f"]
  * "wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi"
  * ["jpthiudqzzeugzwwsngebdeai","nbmxgkduynigvzuyblwjepn"]
  */
object _524_Solution {
  
  def findLongestWord(s: String, d: List[String]): String = {
    if (d.isEmpty) return ""
    
    def search(candidate: String): Boolean = {
      var index = -1
      candidate.foreach { c =>
        index = s.indexOf(c, index + 1)
        if (index < 0) return false
      }
      true
    }
    
    val remains = d.filter(search)
    if (remains.isEmpty) "" else remains.min(new Ordering[String] {
      override def compare(x: String, y: String): Int = if (x.length != y.length) {
        y.length - x.length
      } else {
        x.compareTo(y)
      }
    })
  }
}