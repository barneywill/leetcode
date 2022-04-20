public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers instance = new DivideTwoIntegers();
        System.out.println(instance.divide(10, 3));
        System.out.println(instance.divide(7, -3));
        System.out.println(instance.divide(Integer.MAX_VALUE, 2));
        System.out.println(instance.divide(Integer.MAX_VALUE, 3));
        System.out.println(instance.divide(1100540749, -1090366779));
        System.out.println(instance.divide(-2147483648, -1017100424));
        System.out.println(instance.divide(-2147483648, -2147483648));
        System.out.println(instance.divide(1026117192, -874002063));
    }
    public int divide(int dividend, int divisor) {
        int result = 0;
        if (dividend == divisor) {
            result = 1;
        } else if (divisor == 1) {
            result = dividend;
        } else if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                result = Integer.MAX_VALUE;
            } else {
                result = dividend * -1;
            }
        } else {
            int flag = (dividend < 0 ? -1 : 1) * (divisor < 0 ? -1 : 1);
            int plus = 0;
            if (dividend == Integer.MIN_VALUE) {
                dividend = Integer.MAX_VALUE;
                plus = 1;
            } else {
                dividend = Math.abs(dividend);
            }
            divisor = Math.abs(divisor);
            if (dividend == divisor) {
                result = 1;
            } else {
                int dividendLength = String.valueOf(dividend).length();
                int divisorLength = String.valueOf(divisor).length();
                if (dividendLength >= divisorLength) {
                    if (dividendLength - 1 > divisorLength) {
                        int value = 1;
                        for (int i = 0; i < dividendLength - divisorLength - 1; i++) {
                            value *= 10;
                        }
                        while (value > 1 && dividend > 0) {
                            int newDivisor = divisor * value;
                            while (newDivisor > 0 && newDivisor <= dividend) {
                                result += value;
                                dividend -= newDivisor;
                            }
                            value = value / 10;
                        }
                    }
                    while ((divisor <= dividend || divisor <= dividend + plus)) {
                        result++;
                        dividend -= divisor;
                    }
                }
            }
            result *= flag;
        }
        return result;
    }
}
