public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome instance = new ValidPalindrome();
        System.out.println(instance.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(instance.isPalindrome("race a car"));
        System.out.println(instance.isPalindrome(" "));
        System.out.println(instance.isPalindrome(",:"));
        System.out.println(instance.isPalindrome("0P"));
    }
    public boolean isPalindrome(String s) {
        boolean result = true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start <= end && !(isChar(s.charAt(start)) || isNum(s.charAt(start)))) {
                start++;
            }
            while (start <= end && !(isChar(s.charAt(end)) || isNum(s.charAt(end)))) {
                end--;
            }
            if (start > end) {
                break;
            } else {
                if (s.charAt(start) == s.charAt(end) || (isChar(s.charAt(start)) && isChar(s.charAt(end)) && Math.abs(s.charAt(start) - s.charAt(end)) == 32)) {
                    start++;
                    end--;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
    private boolean isChar(char c) {
        return ((65 <= c && c <= 90) || (97 <= c && c <= 122));
    }
    private boolean isNum(char c) {
        return 48 <= c && c <= 57;
    }
}
