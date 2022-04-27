public class SqrtX {
    public static void main(String[] args) {
        SqrtX instance = new SqrtX();
        System.out.println(instance.mySqrt(4));
        System.out.println(instance.mySqrt(8));
        System.out.println(instance.mySqrt(200));
        System.out.println(instance.mySqrt(2000));
        System.out.println(instance.mySqrt(20000));
        System.out.println(instance.mySqrt(Integer.MAX_VALUE));
    }
    public int mySqrt(int x) {
        int result = 0;
        if (x == 1 || x == 0) {
            result = x;
        } else if (x < 100) {
            for (int i = 1; i < 10; i++) {
                if (i * i == x) {
                    result = i;
                    break;
                } else if (i * i > x) {
                    result = i - 1;
                    break;
                } else {
                    result = i;
                }
            }
        } else if (x == 100) {
            result = 10;
        } else {
            int length = String.valueOf(x).length();
            int startBase = (length - 1) / 2;
            int start = (length - 1) % 2 == 1 ? 3 : 1;
            for (int i = 0; i < startBase; i++) {
                start *= 10;
            }
            int end = start * 10;
            for (int i = start; i < end; i++) {
                if (i * i < 0) {
                    break;
                } else if (i * i == x) {
                    result = i;
                    break;
                } else if (i * i > x) {
                    result = i - 1;
                    break;
                } else {
                    result = i;
                }
            }
        }
        return result;
    }
}
