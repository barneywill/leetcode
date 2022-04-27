import java.util.Arrays;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        SearchA2DMatrix instance = new SearchA2DMatrix();
        int[][] matrix = new int[][]{
                new int[]{1,3,5,7},
                new int[]{10,11,16,20},
                new int[]{23,30,34,60}
        };
        System.out.println(instance.searchMatrix(matrix, 3));
        System.out.println(instance.searchMatrix(matrix, 13));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target == matrix[0][0] || target == matrix[matrix.length - 1][matrix[0].length - 1]) {
            return true;
        } else if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        } else {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == target || matrix[i][matrix[0].length - 1] == target) {
                    return true;
                } else if (matrix[i][0] < target && matrix[i][matrix[0].length - 1] > target) {
                    return Arrays.binarySearch(matrix[i], target) >= 0;
                }
            }
        }
        return false;
    }
}
