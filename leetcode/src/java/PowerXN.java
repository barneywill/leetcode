import java.util.ArrayList;
import java.util.List;

public class PowerXN {
    public static void main(String[] args) {
        PowerXN instance = new PowerXN();
        System.out.println(instance.myPow(2.00000, 10));
        System.out.println(instance.myPow(2.10000, 3));
        System.out.println(instance.myPow(2.00000, -2));
        System.out.println(instance.myPow(1.00000, -2));
        System.out.println(instance.myPow(2.00000, 0));
        System.out.println(instance.myPow(1.72777, 7));
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
            int currentN = positiveN;
            List<XNPair> values = new ArrayList<XNPair>();
            int i = 2;
            while (currentN > 0) {
                if (currentN == positiveN) {
                    result *= x;
                    values.add(new XNPair(1, result));
                    currentN = positiveN - 1;
                } else if (currentN > positiveN - currentN) {
                    result *= result;
                    values.add(0, new XNPair(i, result));
                    currentN = positiveN - i;
                    i *= 2;
                } else {
                    while (values.size() > 0) {
                        while (currentN >= values.get(0).n) {
                            result *= values.get(0).x;
                            currentN -= values.get(0).n;
                            if (!isPositive && result > 100000) {
                                return 0;
                            }
                        }
                        values.remove(0);
                    }
                }
                if (!isPositive && result > 100000) {
                    return 0;
                }
            }
            if (!isPositive) {
                result = 1 / result;
            }
        }
        return result;
    }
    class XNPair {
        public XNPair(int n, double x){
            this.n = n;
            this.x = x;
        }
        public int n = 0;
        public double x = 0;
    }
}
