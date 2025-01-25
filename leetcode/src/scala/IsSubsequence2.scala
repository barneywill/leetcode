import scala.util.control.Breaks._
object isSubsequence2 {
    def isSubsequence(s: String, t: String): Boolean = {
        var result = true
        var currentIndex = 0
        Array.range(0, s.length).foreach(i => {
            if (result) {
                var isFound = false
                if (currentIndex < t.length) {
                    breakable {
                        Array.range(currentIndex, t.length).foreach(j => {
                            if (t.charAt(j) == s.charAt(i)) {
                                currentIndex = j + 1
                                isFound = true
                                break
                            }
                        })
                    }
                }
                if (!isFound) result = false
            }
        })
        result
    }
}