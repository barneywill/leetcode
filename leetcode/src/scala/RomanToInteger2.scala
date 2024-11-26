object RomanToInteger2 {
  def main(args : Array[String]): Unit = {
    val s = "MCMXCIV"
    println(romanToInt(s))
  }
  def romanToInt(s: String): Int = {
    var result = 0
    var isSkip = false
    for (i <- 0 until s.length) {
      if (isSkip) {
        isSkip = false
      } else {
        s.charAt(i) match {
          case 'I' =>
            if (i == s.length - 1) result += 1
            else {
              s.charAt(i + 1) match {
                case 'V' =>
                  result += 4
                  isSkip = true
                case 'X' =>
                  result += 9
                  isSkip = true
                case _ => result += 1
              }
            }
          case 'X' =>
            if (i == s.length - 1) result += 10
            else {
              s.charAt(i + 1) match {
                case 'L' =>
                  result += 40
                  isSkip = true
                case 'C' =>
                  result += 90
                  isSkip = true
                case _ => result += 10
              }
            }
          case 'C' =>
            if (i == s.length - 1) result += 100
            else {
              s.charAt(i + 1) match {
                case 'D' =>
                  result += 400
                  isSkip = true
                case 'M' =>
                  result += 900
                  isSkip = true
                case _ => result += 100
              }
            }

          case 'V' => result += 5
          case 'L' => result += 50
          case 'D' => result += 500
          case 'M' => result += 1000
        }
      }
    }
    result
  }
}
