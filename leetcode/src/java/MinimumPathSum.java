public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum instance = new MinimumPathSum();
        int[][] grid = new int[][]{
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1}
        };
        System.out.println(instance.minPathSum(grid));

        grid = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6}
        };
        System.out.println(instance.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int result = 0;
        if (grid.length == 1 || grid[0].length == 1) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    result += grid[i][j];
                }
            }
        } else {
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][0];
                grid[i][0] = sum;
            }
            sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[0][j];
                grid[0][j] = sum;
            }
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            result = grid[grid.length - 1][grid[0].length - 1];
        }
        return result;
    }
}
