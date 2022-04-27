public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths instance = new UniquePaths();
        System.out.println(instance.uniquePaths(3, 7));
        System.out.println(instance.uniquePaths(3, 2));
    }
    public int uniquePaths(int m, int n) {
        int result = 1;
        if (m > 1 && n > 1) {
            int[][] matrix = new int[m][n];
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 1;
            }
            for (int i = 1; i < m; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += matrix[i - 1][j];
                    matrix[i][j] = sum;
                }
            }
            result = matrix[m - 1][n - 1];
        }
        return result;
    }
}
