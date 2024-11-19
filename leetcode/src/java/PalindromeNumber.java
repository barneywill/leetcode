public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber instance = new PalindromeNumber();
        System.out.println(instance.isPalindrome(121));
        System.out.println(instance.isPalindrome(-121));
        System.out.println(instance.isPalindrome(10));
        System.out.println(instance.isPalindrome(1));
    }
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        if (str.length() == 1) {
            return true;
        } else {
            for (int i = 0, n = str.length(); i < n; i++) {
                if (str.charAt(i) != str.charAt(n - 1 - i)) {
                    break;
                }
                if ((i == n - 1 - i) || (i + 1 == n - 1 - i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
