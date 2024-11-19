public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr instance = new ImplementStrStr();
        System.out.println(instance.strStr("hello", "ll"));
        System.out.println(instance.strStr("aaaaa", "bba"));
    }
    public int strStr(String haystack, String needle) {
        int result = -1;
        int length = haystack.length();
        int subLength = needle.length();
        if (length >= subLength) {
            for (int i = 0; i < length - subLength + 1; i++) {
                if (haystack.charAt(i) == needle.charAt(0) && haystack.charAt(i + subLength - 1) == needle.charAt(subLength - 1)) {
                    boolean isMatch = true;
                    for (int j = 0; j < subLength; j++) {
                        if (haystack.charAt(i + j) != needle.charAt(j)) {
                            isMatch = false;
                            break;
                        }
                    }
                    if (isMatch) {
                        result = i;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
