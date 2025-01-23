import scala.util.control.Breaks._
object CanPlaceFlowers2 {
    def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
        var flowerCount = 0
        var lastFlowerIndex = -2
        breakable {
            Array.range(0, flowerbed.length).foreach(i => {
                if (flowerbed(i) == 1) {
                    if (i - lastFlowerIndex - 1 > 1) {
                        flowerCount += (i - lastFlowerIndex) / 2 - 1
                        if (flowerCount >= n) break
                    }
                    lastFlowerIndex = i
                }
            })
        }
        if (flowerbed.length - lastFlowerIndex > 1) {
            flowerCount += (flowerbed.length - lastFlowerIndex + 1) / 2 - 1
        }
        flowerCount >= n
    }
}