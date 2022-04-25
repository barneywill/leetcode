import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {
    //TODO:
    public static void main(String[] args) {
        RegularExpressionMatching instance = new RegularExpressionMatching();
        System.out.println(instance.isMatch("aa", "aa*bb.*cc"));
    }
    public boolean isMatch(String s, String p) {
        int startIndex = -1;
        boolean isVerb = false;
        List<String> parts = new ArrayList<String>();
        for (int i = 0, n = p.length(); i < n; i++) {
            if (startIndex == -1) {
                startIndex = i;
                isVerb = 'a' <= p.charAt(i) && p.charAt(i) <= 'z';
            } else {
                if (!isVerb && 'a' <= p.charAt(i) && p.charAt(i) <= 'z') {

                }
            }
        }
        return false;
    }
    private boolean isMatchVariable(String s, String p) {

        return false;
    }
}
