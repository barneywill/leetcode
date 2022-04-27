public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs instance = new ClimbStairs();
        System.out.println(instance.climbStairs(2));
        System.out.println(instance.climbStairs(3));
        System.out.println(instance.climbStairs(45));
    }
    public int climbStairs(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            int pre = 2;
            int prePre = 1;
            for (int i = 2; i < n; i++) {
                result = pre + prePre;
                prePre = pre;
                pre = result;
            }
        }
        return result;
    }
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
