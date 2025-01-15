object NimGame2 {
    def canWinNim(n: Int): Boolean = {
        return n % 4 <= 3 && n % 4 >= 1
    }
}