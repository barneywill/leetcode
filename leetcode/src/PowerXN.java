public class PowerXN {
    public static void main(String[] args) {
        PowerXN instance = new PowerXN();
        System.out.println(instance.myPow(2.00000, 10));
        System.out.println(instance.myPow(2.10000, 3));
        System.out.println(instance.myPow(2.00000, -2));
        System.out.println(instance.myPow(1.00000, -2));
        System.out.println(instance.myPow(2.00000, 0));
    }
    public double myPow(double x, int n) {
        double result = 1;
        if (x == -1) {
            if (n % 2 == 1) {
                result = -1;
            }
        } else if (x != 1 && n != 0) {
            boolean isPositive = n > 0;
            int positiveN = n == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(n);
            while (positiveN-- > 0) {
                result *= x;
                if (!isPositive && result > 1000000) {
                    return 0;
                }
            }
            if (!isPositive) {
                result = 1 / result;
            }
        }
        return result;
    }
}
