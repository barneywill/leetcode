import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber instance = new LetterCombinationsOfAPhoneNumber();
        System.out.println(instance.letterCombinations("23"));
        System.out.println(instance.letterCombinations(""));
        System.out.println(instance.letterCombinations("2"));
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() > 0) {
            Map<Integer, String> map = new HashMap<Integer, String>();
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
            for (int i = 0, n = digits.length(); i < n; i++) {
                String abs = map.get(digits.charAt(i) - 48);
                if (result.isEmpty()) {
                    for (int j = 0, m = abs.length(); j < m; j++) {
                        result.add(String.valueOf(abs.charAt(j)));
                    }
                } else {
                    List<String> tmp = new ArrayList<String>();
                    for (int k = 0, l = result.size(); k < l; k++) {
                        for (int j = 0, m = abs.length(); j < m; j++) {
                            tmp.add(result.get(k) + abs.charAt(j));
                        }
                    }
                    result.clear();
                    result = tmp;
                }
            }
        }
        return result;
    }
}
