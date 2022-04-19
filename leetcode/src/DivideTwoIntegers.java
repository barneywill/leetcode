public class DivideTwoIntegers {
    public static void main(String[] args) {

    }
    public int divide(int dividend, int divisor) {
        int result = 0;
        if (divisor == 1 || divisor == -1) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                result = Integer.MAX_VALUE;
            } else {
                result = dividend * divisor;
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
            int dividendLength = String.valueOf(dividend).length();
            int divisorLength = String.valueOf(divisor).length();
            if (dividendLength >= divisorLength) {
                if (dividendLength > divisorLength) {
                    String value = "1";
                    for (int i = 0; i < dividendLength - divisorLength; i++) {
                        value += "0";
                    }
                    while (value.length() > 1 && dividend > 0) {
                        int newDivisor = Integer.parseInt(divisor + value.substring(1));
                        while (newDivisor <= dividend) {
                            result += Integer.parseInt(value);
                            dividend -= newDivisor;
                        }
                        value = value.substring(0, value.length() - 1);
                    }
                }
                int start = divisor;
                while (start <= dividend + plus) {
                    result++;
                    start += divisor;
                }
            }
            result *= flag;
        }
        return result;
    }
}
