public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII instance = new SpiralMatrixII();
        int[][] result = instance.generateMatrix(3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();

        result = instance.generateMatrix(5);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = 1;
        } else {
            int iStart = 0;
            int iEnd = n - 1;
            int iCurrent = 0;
            int jStart = 0;
            int jEnd = n - 1;
            int jCurrent = 0;
            boolean isI = false;
            int index = 1;
            while (true) {
                System.out.println("loop : (" + iCurrent + "," + jCurrent + ")  " + iStart + ", " + iEnd + " | " + jStart + ", " + jEnd + " | " + isI);
                if (iStart > iEnd || jStart > jEnd) {
                    result[iCurrent][jCurrent] = index;
                    break;
                }
                if (isI) {
                    if (iCurrent <= iStart) {
                        while (iCurrent < iEnd) {
                            result[iCurrent++][jCurrent] = index++;
                        }
                    } else {
                        while (iCurrent > iStart) {
                            result[iCurrent--][jCurrent] = index++;
                        }
                    }
                    if (jCurrent == jStart) {
                        jStart++;
                    } else {
                        jEnd--;
                    }
                    isI = false;
                } else {
                    if (jCurrent <= jStart) {
                        while (jCurrent < jEnd) {
                            result[iCurrent][jCurrent++] = index++;
                        }
                    } else {
                        while (jCurrent > jStart) {
                            result[iCurrent][jCurrent--] = index++;
                        }
                    }
                    if (iCurrent == iStart) {
                        iStart++;
                    } else {
                        iEnd--;
                    }
                    isI = true;
                }
            }
        }
        return result;
    }
}
