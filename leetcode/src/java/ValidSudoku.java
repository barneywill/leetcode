public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku instance = new ValidSudoku();
        char[][] board = new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(instance.isValidSudoku(board));
        board = new char[][]{
                new char[]{'8','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(instance.isValidSudoku(board));
        /**
         * [[".",".","4",".",".",".","6","3","."],
         * [".",".",".",".",".",".",".",".","."],
         * ["5",".",".",".",".",".",".","9","."],
         * [".",".",".","5","6",".",".",".","."],
         * ["4",".","3",".",".",".",".",".","1"],
         * [".",".",".","7",".",".",".",".","."],
         * [".",".",".","5",".",".",".",".","."],
         * [".",".",".",".",".",".",".",".","."],
         * [".",".",".",".",".",".",".",".","."]]
         */
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] existenceRow = new int[board.length];
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (++existenceRow[board[i][j] - 49] > 1) {
                        return false;
                    }
                }
            }
        }
        for (int j = 0; j < board.length; j++) {
            int[] existenceRow = new int[board.length];
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    if (++existenceRow[board[i][j] - 49] > 1) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < board.length - 2; i+=3) {
            for (int j = 0; j < board.length - 2; j+=3) {
                int[] existenceGrid = new int[board.length];
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i + m][j + n] != '.') {
                            existenceGrid[board[i + m][j + n] - 49]++;
                        }
                    }
                }
                for (int m = 0; m < board.length; m++) {
                    if (existenceGrid[m] > 1) {
//                        System.out.println("more than once : " + (m + 1) + ", " + existenceGrid[m] + ", " + i + ", " + j);
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku2(char[][] board) {
        int[] existence = new int[board.length];
        int previousI = 0;
        int previousJ = 0;
        for (int i = 0; i < board.length - 2; i++) {
            for (int j = 0; j < board.length - 2; j++) {
                if (i == 0 && j == 0) {
                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            if (board[i + m][j + n] != '.') {
                                existence[board[i + m][j + n] - 49]++;
                            }
                        }
                    }
                } else {
                    if (i != previousI) {
                        for (int m = 0; m < 3; m++) {
                            if (board[previousI][j + m] != '.') {
                                existence[board[previousI][j + m] - 49]--;
                            }
                            if (board[i + 2][j + m] != '.') {
                                existence[board[i + 2][j + m] - 49]++;
                            }
                        }
                    } else if (j != previousJ) {
                        for (int m = 0; m < 3; m++) {
                            if (board[i + m][previousJ] != '.') {
                                existence[board[i + m][previousJ] - 49]--;
                            }
                            if (board[i + m][j + 2] != '.') {
                                existence[board[i + m][j + 2] - 49]++;
                            }
                        }
                    }
                }
                boolean isEmpty = true;
                for (int m = 0; m < board.length; m++) {
                    if (existence[m] > 1) {
                        System.out.println("more than once : " + (m + 1) + ", " + existence[m] + ", " + i + ", " + j);
                        return false;
                    } else if (existence[m] > 0) {
                        isEmpty = false;
                    }
                }
                if (isEmpty) {
                    System.out.println("empty : " + i + ", " + j);
                    return false;
                }
                previousJ = j;
            }
            previousI = i;
        }
        return true;
    }
}
