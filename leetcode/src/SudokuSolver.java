import java.util.*;

public class SudokuSolver {
    //TODO:
    public static void main(String[] args) {
        SudokuSolver instance = new SudokuSolver();
        char[][] board = new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        instance.solveSudoku(board);
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                System.out.print(board[i][j] + ",");
//            }
//            System.out.println();
//        }
    }
    public void solveSudoku(char[][] board) {
        Item[][] itemBoard = new Item[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            Set<Byte> potentialValues = new HashSet<Byte>();
            for (byte b = 1; b <= 9; b++) {
                potentialValues.add(b);
            }
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    itemBoard[i][j] = new Item((byte)(board[i][j] - 48));
                    potentialValues.remove((byte)(board[i][j] - 48));
                }
            }
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    itemBoard[i][j] = new Item(potentialValues);
                }
            }
        }
        for (int j = 0; j < board.length; j++) {
            Set<Byte> set = new HashSet<Byte>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    set.add((byte)(board[i][j] - 48));
                }
            }
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    itemBoard[i][j].remove(set);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (itemBoard[i][j].potentiallValues.size() == 1) {
                    Byte value = itemBoard[i][j].potentiallValues.toArray(new Byte[0])[0];
                    itemBoard[i][j].value = value;
                    itemBoard[i][j].potentiallValues.clear();
                    check(itemBoard, i, j, value);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
//                System.out.print(itemBoard[i][j].value + "  ");
                System.out.print(itemBoard[i][j].value + "[" + itemBoard[i][j].potentiallValues + "]" + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void check(Item[][] itemBoard, int i, int j, Byte value) {
        for (int m = 0; m < itemBoard.length; m++) {
            if (m != i && !itemBoard[m][j].potentiallValues.isEmpty()) {
                itemBoard[m][j].remove(value);
                if (itemBoard[m][j].potentiallValues.size() == 1) {
                    Byte currentValue = itemBoard[m][j].potentiallValues.toArray(new Byte[0])[0];
                    itemBoard[i][j].value = currentValue;
                    itemBoard[i][j].potentiallValues.clear();
                    check(itemBoard, m, j, currentValue);
                }
            }
        }
        for (int m = 0; m < itemBoard.length; m++) {
            if (m != j && !itemBoard[i][m].potentiallValues.isEmpty()) {
                itemBoard[i][m].remove(value);
                if (itemBoard[i][m].potentiallValues.size() == 1) {
                    Byte currentValue = itemBoard[i][m].potentiallValues.toArray(new Byte[0])[0];
                    itemBoard[i][j].value = currentValue;
                    itemBoard[i][j].potentiallValues.clear();
                    check(itemBoard, i, m, currentValue);
                }
            }
        }
    }
    class Item {
        public Item(Byte value) {
            this.value = value;
        }
        public Item(Set<Byte> potentiallValues) {
            this.potentiallValues = new HashSet<Byte>(potentiallValues);
        }
        public void remove(Set<Byte> set) {
            potentiallValues.removeAll(set);
        }
        public void remove(Byte value) {
            potentiallValues.remove(value);
        }
        public Byte value = 0;
        public Set<Byte> potentiallValues = new HashSet<Byte>();
    }
}
