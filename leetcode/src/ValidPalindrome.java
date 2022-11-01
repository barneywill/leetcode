public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome instance = new ValidPalindrome();
        System.out.println(instance.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(instance.isPalindrome("race a car"));
        System.out.println(instance.isPalindrome(" "));
    }
    public boolean isPalindrome(String s) {
        boolean result = true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (!isChar(s.charAt(start)) && start <= end) {
                start++;
            }
            while (!isChar(s.charAt(end)) && start <= end) {
                end--;
            }
            if (start > end) {
                break;
            } else {
                if (s.charAt(start) == s.charAt(end) || Math.abs(s.charAt(start) - s.charAt(end)) == 32) {
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
}
