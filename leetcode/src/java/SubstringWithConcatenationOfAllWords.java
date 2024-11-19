import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords instance = new SubstringWithConcatenationOfAllWords();
        System.out.println(instance.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(instance.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(instance.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
        System.out.println(instance.findSubstring("aaaaaaaaaaaabaaaaaaaaaaa", new String[]{"a","a","a", "b"}));
        System.out.println(instance.findSubstring("aaaaaaaaaaaabaaaaaaaaaaa", new String[]{"a","a","a", "a"}));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int wordLength = words[0].length();
        List<List<Integer>> pos = new ArrayList<List<Integer>>(s.length());
        boolean isPossible = true;
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<Integer>());
            }
            map.get(word).add(i);
            for (int j = 0; j < word.length(); j++) {
                set.add(word.charAt(j));
            }
        }
        byte[] impossiblePos = new byte[s.length()];
        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            pos.add(null);
            if (!set.contains(s.charAt(i))) {
                for (int j = Math.max(Math.max(0, lastIndex), i - wordLength * words.length + 1); j <= i; j++) {
                    impossiblePos[j] = 1;
                }
                lastIndex = i;
            }
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
                if (impossiblePos[i] == 1) {
                    continue;
                }
                double[] weights = new double[words.length];
                boolean isMatch = true;
                for (int j = 0; j < words.length; j++) {
                    List<Integer> groups = pos.get(i + j * wordLength);
                    if (groups != null) {
                        for (Integer w : groups) {
                            weights[w] += 1.0 / groups.size();
                        }
                    } else {
                        isMatch = false;
                        break;
                    }
                }
//                System.out.print(i + " : ");
//                for (double weight : weights) {
//                    System.out.print(weight + ", ");
//                }
//                System.out.println();
                if (isMatch) {
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
        }
        return result;
    }
}
