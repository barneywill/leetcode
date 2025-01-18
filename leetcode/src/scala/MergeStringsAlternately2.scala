object MergeStringsAlternately2 {
  def mergeAlternately(word1: String, word2: String): String = {
    var result = ""
    val lenWord1 = word1.length
    val lenWord2 = word2.length
    val lenMin = Math.min(lenWord1, lenWord2)
    Array.range(0, lenMin).foreach(i => result += word1.charAt(i).toString + word2.charAt(i).toString)
    if (lenWord1 > lenMin) Array.range(lenMin, lenWord1).foreach(i => result += word1.charAt(i).toString)
    if (lenWord2 > lenMin) Array.range(lenMin, lenWord2).foreach(i => result += word2.charAt(i).toString)
    result
  }
}