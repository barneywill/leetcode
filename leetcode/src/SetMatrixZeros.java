import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeros {
    public static void main(String[] args) {
        SetMatrixZeros instance = new SetMatrixZeros();
        int[][] matrix = new int[][]{
                new int[]{1,1,1},
                new int[]{1,0,1},
                new int[]{1,1,1}
        };
        instance.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }

        matrix = new int[][]{
                new int[]{0,1,2,0},
                new int[]{3,4,5,2},
                new int[]{1,3,1,5}
        };
        instance.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }
    public void setZeroes(int[][] matrix) {
        if (matrix.length > 1 || matrix[0].length > 1) {
            Set<Integer> rowSet = new HashSet<Integer>();
            Set<Integer> columnSet = new HashSet<Integer>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        rowSet.add(i);
                        columnSet.add(j);
                    }
                }
            }
            for (Integer i : rowSet) {
                if (matrix[0].length > 1) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (Integer j : columnSet) {
                if (matrix.length > 1){
                    for (int i = 0; i < matrix.length; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
