import scala.util.control.Breaks.{break, breakable}

object FindTheIndexOfTheFirstOccurrenceInAString2 {
  def main(args: Array[String]) : Unit = {
    val str = "hello"
    val s = "ll"
    println(strStr(str, s))
  }
  def strStr(haystack: String, needle: String): Int = {
    var result = -1
    if (haystack.length >= needle.length) {
      breakable {
        for (i <- 0 to haystack.length - needle.length) {
          var isMatch = true
          breakable {
            for (j <- needle.indices) {
              if (haystack.charAt(i + j) != needle.charAt(j)) {
                isMatch = false
                break
              }
            }
          }
          if (isMatch) {
            result = i
            break
          }
        }
      }
    }
    result
  }
}
