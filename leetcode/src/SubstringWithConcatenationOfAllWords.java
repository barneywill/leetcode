import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords instance = new SubstringWithConcatenationOfAllWords();
        System.out.println(instance.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(instance.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(instance.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int wordLength = words[0].length();
        List<List<Integer>> pos = new ArrayList<List<Integer>>(s.length());
        for (int i = 0; i < s.length(); i++) {
            pos.add(null);
        }
        boolean isPossible = true;
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<Integer>());
            }
            map.get(word).add(i);
        }
        for (String word : map.keySet()) {
            int index = -1;
            boolean isFound = false;
            while (true) {
                index = s.indexOf(word, index + 1);
                if (index == -1) {
                    break;
                } else {
                    isFound = true;
                    pos.set(index, map.get(word));
                }
            }
            if (!isFound) {
                isPossible = false;
                break;
            }
        }
//        for (List<Integer> p : pos) {
//            System.out.print(p + ", ");
//        }
//        System.out.println();

        if (isPossible) {
            for (int i = 0; i <= pos.size() - wordLength * words.length; i++) {
                double[] weights = new double[words.length];
                for (int j = 0; j < words.length; j++) {
                    List<Integer> groups = pos.get(i + j * wordLength);
                    if (groups != null) {
                        for (Integer w : groups) {
                            weights[w] += 1.0 / groups.size();
                        }
                    } else {
                        break;
                    }
                }
//                System.out.print(i + " : ");
//                for (double weight : weights) {
//                    System.out.print(weight + ", ");
//                }
//                System.out.println();

                boolean isOk = true;
                for (double weight : weights) {
                    if (weight < 0.99) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
