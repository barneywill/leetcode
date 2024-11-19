import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix instance = new SpiralMatrix();
        /**
         * (i,j)
         * (0,0) (0,1) (0,2)
         * (1,0) (1,1) (1,2)
         * (2,0) (2,1) (2,2)
         * iStart, iEnd, iCurrent, jStart, jEnd, jCurrent
         * 0, 2, 0, 0, 2, 0, false
         * 1, 2, 0, 0, 2, 2, true
         * 1, 2, 2, 0, 1, 2, false
         * 1, 1, 2, 0, 1, 0, true
         *
         */
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };
        System.out.println(instance.spiralOrder(matrix));
        matrix = new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12}
        };
        System.out.println(instance.spiralOrder(matrix));
        matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9},
                new int[]{10,11,12}
        };
        System.out.println(instance.spiralOrder(matrix));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
        } else if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
            }
        } else {
            int iStart = 0;
            int iEnd = matrix.length - 1;
            int iCurrent = 0;
            int jStart = 0;
            int jEnd = matrix[0].length - 1;
            int jCurrent = 0;
            boolean isI = false;
            while (true) {
//                System.out.println("loop : (" + iCurrent + "," + jCurrent + ")  " + iStart + ", " + iEnd + " | " + jStart + ", " + jEnd + " | " + isI);
                if (iStart > iEnd || jStart > jEnd) {
                    result.add(matrix[iCurrent][jCurrent]);
                    break;
                }
                if (isI) {
                    if (iCurrent <= iStart) {
                        while (iCurrent < iEnd) {
                            result.add(matrix[iCurrent++][jCurrent]);
                        }
                        if (jCurrent == jStart) {
                            jStart++;
                        } else {
                            jEnd--;
                        }
                    } else {
                        while (iCurrent > iStart) {
                            result.add(matrix[iCurrent--][jCurrent]);
                        }
                        if (jCurrent == jStart) {
                            jStart++;
                        } else {
                            jEnd--;
                        }
                    }
                    isI = false;
                } else {
                    if (jCurrent <= jStart) {
                        while (jCurrent < jEnd) {
                            result.add(matrix[iCurrent][jCurrent++]);
                        }
                        if (iCurrent == iStart) {
                            iStart++;
                        } else {
                            iEnd--;
                        }
                    } else {
                        while (jCurrent > jStart) {
                            result.add(matrix[iCurrent][jCurrent--]);
                        }
                        if (iCurrent == iStart) {
                            iStart++;
                        } else {
                            iEnd--;
                        }
                    }
                    isI = true;
                }
            }
        }
        return result;
    }
}
