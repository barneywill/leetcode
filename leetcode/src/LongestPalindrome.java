public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome instance = new LongestPalindrome();
        System.out.println(instance.longestPalindrome("babad"));
        System.out.println(instance.longestPalindrome("cbbd"));
        System.out.println(instance.longestPalindrome("ccc"));
    }
    public String longestPalindrome(String s) {
        String result = "";
        result = String.valueOf(s.charAt(0));
        if (s.length() > 1) {
            int resultStartIndex = -1;
            int resultEndIndex = -1;
            for (int i = 0, n = s.length(); i < n - 1; i++) {
                int startIndex = -1;
                int endIndex = -1;
                if (s.charAt(i) == s.charAt(i + 1)) {
                    startIndex = i;
                    endIndex = i + 1;
                    int[] indexArray = search(s, startIndex, endIndex, resultStartIndex == -1 ? 0 : (resultEndIndex - resultStartIndex + 1));
                    if (indexArray != null) {
                        resultStartIndex = indexArray[0];
                        resultEndIndex = indexArray[1];
                    }
                }
                if (i > 0 && s.charAt(i - 1) == s.charAt(i + 1)) {
                    startIndex = i - 1;
                    endIndex = i + 1;
                    int[] indexArray = search(s, startIndex, endIndex, resultStartIndex == -1 ? 0 : (resultEndIndex - resultStartIndex + 1));
                    if (indexArray != null) {
                        resultStartIndex = indexArray[0];
                        resultEndIndex = indexArray[1];
                    }
                }
            }
            if (resultStartIndex != -1) {
                result = s.substring(resultStartIndex, resultEndIndex + 1);
            }
        }
        return result;
    }
    private int[] search(String s, int startIndex, int endIndex, int resultLength) {
        System.out.println(startIndex + ", " + endIndex);
        if (startIndex != -1) {
            while (startIndex >=1 && endIndex <= s.length() - 2) {
                if (s.charAt(startIndex - 1) == s.charAt(endIndex + 1)) {
                    startIndex--;
                    endIndex++;
                } else {
                    break;
                }
            }
            if (endIndex - startIndex + 1 > resultLength) {
                return new int[]{startIndex, endIndex};
            }
        }
        return null;
    }
}
