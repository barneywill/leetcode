import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters instance = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(instance.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(instance.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(instance.lengthOfLongestSubstring2("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        StringBuffer currentString = new StringBuffer();
        if (s.length() > 0) {
            for (int i = 0, n = s.length(); i < n; i++) {
                String currentChar = String.valueOf(s.charAt(i));
                if (currentString.length() == 0 || currentString.indexOf(currentChar) < 0) {
                    currentString.append(currentChar);
                } else {
                    currentString.delete(0, currentString.indexOf(currentChar) + 1).append(currentChar);
                }
                if (currentString.length() > longestLength) {
                    longestLength = currentString.length();
                }
//                System.out.println(currentString);
            }
        }
        return longestLength;
    }
    public int lengthOfLongestSubstring2(String s) {
        int longestLength = 0;
        Set<Character> set = new HashSet<Character>();
        if (s.length() > 0) {
            for (int i = 0, n = s.length(); i < n; i++) {
                if (set.isEmpty() || !set.contains(s.charAt(i))) {
                    set.add(s.charAt(i));
                } else {
                    for (int j = i - set.size(); j < i; j++) {
                        if (s.charAt(i) == s.charAt(j)) {
                            break;
                        } else {
                            set.remove(s.charAt(j));
                        }
                    }
                }
                if (set.size() > longestLength) {
                    longestLength = set.size();
                }
//                System.out.println(currentString);
            }
        }
        return longestLength;
    }
}
