object AddBinary2 {
  def main(args: Array[String]): Unit = {
    val a = "11"
    val b = "1"
    println(addBinary(a, b))
  }
  def addBinary(a: String, b: String): String = {
    var result = ""
    val len = Math.max(a.length, b.length)
    var isPlus = false
    for (i <- 0 until len) {
      val charA = (if (i <= a.length - 1) a.charAt(a.length - 1 - i) else '0') - 48
      val charB = (if (i <= b.length - 1) b.charAt(b.length - 1 - i) else '0') - 48
      val sum = charA + charB + (if (isPlus) 1 else 0)
      isPlus = sum >= 2
      val left = sum % 2
      result = s"$left$result"
    }
    if (isPlus) result = "1" + result
    result
  }
}
