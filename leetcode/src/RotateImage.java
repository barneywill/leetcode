public class RotateImage {
    public static void main(String[] args) {
        RotateImage instance = new RotateImage();
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
        instance.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
        //[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]
        matrix = new int[][]{
                new int[]{5,1,9,11},
                new int[]{2,4,8,10},
                new int[]{13,3,6,7},
                new int[]{15,14,12,16}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
        instance.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void rotate(int[][] matrix) {
        int tmp = 0;
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length - 1 - i; j++) {
//                System.out.println("rotate : " + i + ", " + j);
                tmp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][i];
                matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
                matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = tmp;
            }
        }
    }
}
