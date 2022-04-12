public class InverseInteger {
    public static void main(String[] args) {
        InverseInteger instance = new InverseInteger();
        System.out.println(instance.reverse(123));
        System.out.println(instance.reverse(-123));
        System.out.println(instance.reverse(120));
        System.out.println(instance.reverse(-120));
        System.out.println(instance.reverse(1534236469));
        System.out.println(instance.reverse(-2147483648));
    }
    public int reverse(int x) {
        int result = 0;
        int sign = x < 0 ? -1 : 1;
        int unsignedX = Math.abs(x);
        int multiply = 1;
        int length = String.valueOf(unsignedX).length();
        if ((length == 10 && unsignedX % 10 > 2) || x == Integer.MIN_VALUE) {
            return 0;
        } else {
            for (int i = length - 1; i >= 0; i--) {
                int base = new Double(Math.pow(10, i)).intValue();
                if (base == 1 && length == 10) {
                    if (unsignedX > (Integer.MAX_VALUE - result) / 1000000000) {
                        return 0;
                    }
                }
                result += (unsignedX / base) * multiply;
                unsignedX %= base;
//            System.out.println(base + ", " + result + ", " + unsignedX + ", " + multiply);
                multiply *= 10;
            }
        }
        return result * sign;
    }
}
