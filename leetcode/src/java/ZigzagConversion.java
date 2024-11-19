public class ZigzagConversion {
    public static void main(String[] args) {
        ZigzagConversion instance = new ZigzagConversion();
        System.out.println(instance.convert("PAYPALISHIRING", 3));
        System.out.println(instance.convert("PAYPALISHIRING", 4));
        System.out.println(instance.convert("A", 1));
        System.out.println(instance.convert("ABCD", 3));
    }
    public String convert(String s, int numRows) {
        StringBuffer result = new StringBuffer();
        if (numRows == 1) {
            return s;
        } else {
            int gap = numRows * 2 - 2;
            for (int i = 0; i < numRows; i++) {
                for (int j = 0, n = s.length(); j < n + gap; j += gap) {
                    if (i == 0 || i == numRows - 1) {
                        if (j + i <= n - 1) {
                            result.append(s.charAt((j + i)));
                        }
                    } else {
                        if (j - i >= 0 && j - i <= n - 1) {
                            result.append(s.charAt(j - i));
                        }
                        if (j + i <= n - 1) {
                            result.append(s.charAt(j + i));
                        }
                    }
//                    System.out.println(result);
                    if (result.length() == s.length()) {
                        break;
                    }
                }
            }
        }
        return result.toString();
    }
}
