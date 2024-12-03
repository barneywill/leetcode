object LengthOfLastWord2 {
  def main(args: Array[String]): Unit = {
    val s = "Hello World "
    println(lengthOfLastWord(s))
  }
  def lengthOfLastWord(s: String): Int = {
    var arr = s.split("\\s+")
    arr.apply(arr.length - 1).length
  }
}
