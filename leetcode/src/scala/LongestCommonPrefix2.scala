import scala.util.control.Breaks._

object LongestCommonPrefix2 {
  def main(args : Array[String]) : Unit = {
    val strs = Array("flower","flow","flight")
    print(longestCommonPrefix(strs))
  }
  def longestCommonPrefix(strs: Array[String]): String = {
    var result = ""
    var isTerminated = false
    for (str <- strs) {
      if (!isTerminated) {
        if (str.isEmpty) {
          result = ""
          isTerminated = true
        } else if (result.isEmpty) result = str
        else {
          val len = if (result.length < str.length) result.length else str.length
          var prefix = ""
          breakable {
            for (i <- 0 until len) {
              if (result.charAt(i) == str.charAt(i)) prefix += result.charAt(i)
              else break
            }
          }
          if (prefix.isEmpty) {
            result = ""
            isTerminated = true
          } else result = prefix
        }
      }
    }
    result
  }
}
