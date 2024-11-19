public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix instance = new LongestCommonPrefix();
        System.out.println(instance.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(instance.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(instance.longestCommonPrefix(new String[]{"dog"}));
        System.out.println(instance.longestCommonPrefix(new String[]{"ab", "a"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = -1;
        int lastIndex = -1;
        for (String str : strs) {
            if (minLength == -1 || minLength > str.length()) {
                minLength = str.length();
            }
        }
        boolean isContinue = true;
        for (int i = 0; i < minLength; i++) {
            char currentChar = 0;
            for (String str : strs) {
                if (currentChar == 0) {
                    currentChar = str.charAt(i);
                } else if (currentChar != str.charAt(i)) {
                    isContinue = false;
                    break;
                }
            }
            if (!isContinue) {
                break;
            } else {
                lastIndex = i;
            }
        }
        return lastIndex == -1 ? "" : strs[0].substring(0, lastIndex + 1);
    }
}
