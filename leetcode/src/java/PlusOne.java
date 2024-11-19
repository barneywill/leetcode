import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne instance = new PlusOne();
        int[] result = instance.plusOne(new int[]{1,2,3});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.println();
        result = instance.plusOne(new int[]{4,3,2,1});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.println();
        result = instance.plusOne(new int[]{9});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.println();
    }
    public int[] plusOne(int[] digits) {
        int[] result = digits;
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + plus;
            if (num >= 10) {
                plus = num / 10;
                digits[i] = num % 10;
            } else {
                plus = 0;
                digits[i] = num;
            }
        }
        if (plus > 0) {
            result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
        }
        return result;
    }
}
