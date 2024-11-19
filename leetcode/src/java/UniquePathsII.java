public class UniquePathsII {
    public static void main(String[] args){
        UniquePathsII instance = new UniquePathsII();
        int[][] obstacleGrid = new int[][]{
                new int[]{0,0,0},
                new int[]{0,1,0},
                new int[]{0,0,0}
        };
        System.out.println(instance.uniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][]{
                new int[]{0,1},
                new int[]{0,0}
        };
        System.out.println(instance.uniquePathsWithObstacles(obstacleGrid));

        //[[0,1,0,0,0],[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
        obstacleGrid = new int[][]{
                new int[]{0,1,0,0,0},
                new int[]{1,0,0,0,0},
                new int[]{0,0,0,0,0},
                new int[]{0,0,0,0,0}
        };
        System.out.println(instance.uniquePathsWithObstacles(obstacleGrid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int result = 1;
        if (obstacleGrid[0][0] == 1) {
            result = 0;
        } else if (obstacleGrid.length > 1 && obstacleGrid[0].length > 1) {
            boolean isObstacle = false;
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (isObstacle || obstacleGrid[0][j] == 1) {
                    obstacleGrid[0][j] = 0;
                    isObstacle = true;
                } else {
                    obstacleGrid[0][j] = 1;
                }
            }
            for (int i = 1; i < obstacleGrid.length; i++) {
                int sum = 0;
                for (int j = 0; j < obstacleGrid[0].length; j++) {
                    sum += obstacleGrid[i - 1][j];
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                        sum = 0;
                    } else {
                        obstacleGrid[i][j] = sum;
                    }
                }
            }
            result = obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        } else {
            for (int i = 0; i < obstacleGrid.length; i++) {
                for (int j = 0; j < obstacleGrid[0].length; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        return 0;
                    }
                }
            }
        }
        return result;
    }
}
