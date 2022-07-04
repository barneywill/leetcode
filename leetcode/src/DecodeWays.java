import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays instance = new DecodeWays();
//        System.out.println(instance.numDecodings("2611055971756562"));
        System.out.println(instance.numDecodings("111111111111111111111111111111111111111111111"));
    }
    public int numDecodings(String s) {
        return numDecodings(s, 0, new ArrayList<String>()).size();
    }
    private List<String> newPreList(List<String> preList, String s, int index, int length) {
        List<String> newPreList = new ArrayList<String>(preList);
        newPreList.add(String.valueOf(s.substring(index, index + length)));
        return newPreList;
    }
    private void add(List<List<String>> result, List<List<String>> tmpResult) {
        if (tmpResult != null && !tmpResult.isEmpty()) {
            result.addAll(tmpResult);
        }
    }
    private List<List<String>> numDecodings(String s, int index, List<String> preList) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (index == s.length()) {
            result.add(preList);
        } else {
            if (s.charAt(index) == '0') {

            } else if (s.charAt(index) == '1' || s.charAt(index) == '2') {
                if (index < s.length() - 1) {
                    if (s.charAt(index + 1) == '0') {
                        add(result, numDecodings(s, index + 2, newPreList(preList, s, index, 2)));
                    } else {
                        add(result, numDecodings(s, index + 1, newPreList(preList, s, index, 1)));
                        if (s.charAt(index + 1) >= '1' && s.charAt(index + 1) <= '6') {
                            add(result, numDecodings(s, index + 2, newPreList(preList, s, index, 2)));
                        }
                    }
                } else {
                    add(result, numDecodings(s, index + 1, newPreList(preList, s, index, 1)));
                }
            } else {
                add(result, numDecodings(s, index + 1, newPreList(preList, s, index, 1)));
            }
        }
        return result;
    }
}
