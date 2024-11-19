public class SurroundedRegions {
    public static void main(String[] args) {
        SurroundedRegions instance = new SurroundedRegions();
        char[][] board = new char[][]{new char[]{'X','X','X','X'},new char[]{'X','O','O','X'},new char[]{'X','X','O','X'},new char[]{'X','O','X','X'}};
        printMatrix(board);
        instance.solve(board);
        printMatrix(board);

        board = new char[][]{new char[]{'O','X','X','O','X'},new char[]{'X','O','O','X','O'},new char[]{'X','O','X','O','X'},new char[]{'O','X','O','O','O'},new char[]{'X','X','O','X','O'}};
        printMatrix(board);
        instance.solve(board);
        printMatrix(board);
    }
    public static void printMatrix(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '1';
                propagate(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                board[i][board[0].length - 1] = '1';
                propagate(board, i, board[0].length - 1);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '1';
                propagate(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                board[board.length - 1][j] = '1';
                propagate(board, board.length - 1, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void propagate(char[][] board, int x, int y) {
        if (x > 0 && board[x - 1][y] == 'O') {
            board[x - 1][y] = '1';
            propagate(board, x - 1, y);
        }
        if (x < board.length - 1 && board[x + 1][y] == 'O') {
            board[x + 1][y] = '1';
            propagate(board, x + 1, y);
        }
        if (y > 0 && board[x][y - 1] == 'O') {
            board[x][y - 1] = '1';
            propagate(board, x, y - 1);
        }
        if (y < board[0].length - 1 && board[x][y + 1] == 'O') {
            board[x][y + 1] = '1';
            propagate(board, x, y + 1);
        }
    }
}
