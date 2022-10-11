public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString instance = new InterleavingString();
        System.out.println(instance.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(instance.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(instance.isInterleave("", "", ""));
        System.out.println(instance.isInterleave("a", "b", "a"));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean result = false;
        if (s3.length() == s1.length() + s2.length()) {
            if (("".equals(s1) && s2.equals(s3))
                    || ("".equals(s2) && s1.equals(s3))
                    || s3.equals(s1 + s2)
                    || s3.equals(s2 + s1)) {
                result = true;
            } else {
                result = tryNext(s1, s2, s3, 0, 0, 0);
            }
        }
        return result;
    }
    public boolean tryNext(String s1, String s2, String s3, int i1, int i2, int i3) {
        boolean result = false;
        if (i3 == s3.length()) {
            result = true;
        } else {
            if (i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1)) {
                result = tryNext(s1, s2, s3, i1 + 1, i2, i3 + 1);
            }
            if (!result && i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2)) {
                result = tryNext(s1, s2, s3, i1, i2 + 1, i3 + 1);
            }
        }
        return result;
    }
}
