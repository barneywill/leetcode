import scala.util.control.Breaks._
object GreatestCommonDivisorOfStrings2 {
    def gcdOfStrings(str1: String, str2: String): String = {
        var result = ""
        val lenStr1 = str1.length
        val lenStr2 = str2.length
        if (lenStr1 == lenStr2) {
            if (str1.equals(str2)) result = str1
            else result = ""
        } else if ((lenStr1 > lenStr2 && !str1.startsWith(str2)) || (lenStr1 < lenStr2 && !str2.startsWith(str1))) {
            result = ""
        } else {
            val scd1 = getSCD(str1)
            if (!str2.startsWith(scd1)) result = ""
            else {
                val scd2 = getSCD(str2)
                if (!scd1.equals(scd2)) result = ""
                else {
                    val lenScd1 = scd1.length
                    val times1 = lenStr1 / lenScd1
                    val times2 = lenStr2 / lenScd1
                    val gcd = getGCD(times1, times2)
                    result = Array.range(0, gcd).foldLeft("")((result, item) => result + scd1)
                }
            }
        }
        result
    }
    def getGCD(num1: Int, num2: Int): Int = {
        var minNum = Math.min(num1, num2)
        var maxNum = Math.max(num1, num2)
        while (minNum != 0) {
            val tmp = maxNum % minNum
            maxNum = minNum
            minNum = tmp
        }
        maxNum
    }
    def getSCD(str: String): String = {
        var scd = ""
        var firstLetter : Char = 0
        val lenStr = str.length
        breakable {
            Array.range(0, lenStr).foreach(i => {
                if (scd.isEmpty) {
                    scd += str.charAt(i).toString
                    firstLetter = str.charAt(i)
                } else if (firstLetter == str.charAt(i) && lenStr % scd.length == 0){
                    val lenScd = scd.length
                    val times = lenStr / lenScd
                    var isMatch = true
                    breakable {
                        Array.range(0, lenScd).foreach(j => {
                            Array.range(1, times).foreach(k => {
                                if (scd.charAt(j) != str.charAt(j + k * lenScd)) {
                                    isMatch = false
                                    break
                                }
                            })
                        })
                    }
                    if (isMatch) break
                    else scd += str.charAt(i).toString
                } else scd += str.charAt(i).toString
            })
        }
        scd
    }
    def main(args: Array[String]): Unit = {
        val str1 = "ABCABC"
        val str2 = "ABC"
        println(gcdOfStrings(str1, str2))
    }
}