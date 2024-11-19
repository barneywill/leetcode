public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger instance = new StringToInteger();
        System.out.println(instance.myAtoi("42"));
        System.out.println(instance.myAtoi("   -42"));
        System.out.println(instance.myAtoi("4193 with words"));
        System.out.println(instance.myAtoi("words and 987"));
        System.out.println(instance.myAtoi(Integer.MAX_VALUE + "111"));
        System.out.println(instance.myAtoi(Integer.MAX_VALUE + 1 + ""));
        System.out.println(instance.myAtoi("-91283472332"));
        System.out.println(instance.myAtoi("1"));
        System.out.println(instance.myAtoi("+1"));
        System.out.println(instance.myAtoi("21474836460"));
        System.out.println(instance.myAtoi("      -11919730356x"));
    }
    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        boolean isFirst = true;
        if (s.length() >= 1) {
            for (int i = 0, n = s.length(); i < n; i++) {
//                System.out.println(result);
                if (isFirst) {
                    if ('-' == s.charAt(i)) {
                        sign = -1;
                        isFirst = false;
                    } else if ('+' == s.charAt(i)) {
                        isFirst = false;
                    } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        result = s.charAt(i) - 48;
                        isFirst = false;
                    } else if (' ' != s.charAt(i)) {
                        break;
                    }
                } else {
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        if (result > 1000000000) {
                            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        }
                        if (sign == 1 && result > 100000000 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - 48 >= Integer.MAX_VALUE % 10))) {
                            return Integer.MAX_VALUE;
                        } else if (sign == -1 && result > 100000000 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - 48 - 1 >= Integer.MAX_VALUE % 10))) {
                            return Integer.MIN_VALUE;
                        } else {
                            result = result * 10 + s.charAt(i) - 48;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return result * sign;
    }
}
