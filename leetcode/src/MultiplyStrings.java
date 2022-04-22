public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings instance = new MultiplyStrings();
        System.out.println(instance.multiply("2", "3"));
        System.out.println(instance.multiply("123", "456"));
        System.out.println(instance.multiply("1230", "456000"));
        System.out.println(instance.multiply("123", "406"));
    }
    public String multiply(String num1, String num2) {
        StringBuffer result = new StringBuffer();
        StringBuffer zeros = new StringBuffer();
        if (num1.equals("0") || num2.equals("0")) {
            result.append("0");
        } else {
            for (int i = num1.length() - 1; i >= 0; i--) {
                if (num1.charAt(i) == '0') {
                    zeros.append("0");
                } else {
                    num1 = num1.substring(0, i + 1);
                    break;
                }
            }
            for (int i = num2.length() - 1; i >= 0; i--) {
                if (num2.charAt(i) == '0') {
                    zeros.append("0");
                } else {
                    num2 = num2.substring(0, i + 1);
                    break;
                }
            }
            String shortNum = num1.length() <= num2.length() ? num1 : num2;
            String longNum = num1.length() <= num2.length() ? num2 : num1;
            StringBuffer[] multiplyResult = new StringBuffer[shortNum.length()];
            int maxLength = 0;
            StringBuffer suffix = new StringBuffer();
            for (int i = shortNum.length() - 1; i >= 0; i--) {
                int single = shortNum.charAt(i) - 48;
                multiplyResult[i] = single == 0 ? new StringBuffer("0") : multiplyAndReverse(longNum, single, suffix);
                if (multiplyResult[i].length() > maxLength) {
                    maxLength = multiplyResult[i].length();
                }
                suffix.append("0");
//            System.out.println("" + i + ", " + multiplyResult[i]);
            }
            int add = 0;
            for (int i = 0; i < maxLength; i++) {
                int tmp = add;
                for (int j = 0; j < multiplyResult.length; j++) {
                    if (multiplyResult[j].length() > i) {
                        tmp += multiplyResult[j].charAt(i) - 48;
                    }
                }
                add = tmp / 10;
                result.append(tmp % 10);
            }
            if (add > 0) {
                result.append(add);
            }
        }
        return result.reverse().append(zeros).toString();
    }
    private StringBuffer multiplyAndReverse(String num, int single, StringBuffer suffix) {
        StringBuffer result = new StringBuffer(suffix);
        int add = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int tmp = (num.charAt(i) - 48) * single + add;
            add = tmp / 10;
            result.append(tmp % 10);
        }
        if (add > 0) {
            result.append(add);
        }
        return result;
    }
}
