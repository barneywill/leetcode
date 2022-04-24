import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams instance = new GroupAnagrams();
        System.out.println(instance.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(instance.groupAnagrams(new String[]{""}));
        System.out.println(instance.groupAnagrams(new String[]{"a"}));
        System.out.println(instance.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs.length == 1){
            result.add(Arrays.asList(strs[0]));
        } else if (strs.length > 1) {
            Map<String, List<String>> keyMap = new HashMap<String, List<String>>();
            for (String str : strs) {
                String key = getKey(str);
                System.out.println(str + "->" + key);
                if (!keyMap.containsKey(key)) {
                    keyMap.put(key, new ArrayList<String>());
                }
                keyMap.get(key).add(str);
            }
            result.addAll(keyMap.values());
        }
        return result;
    }
    byte[] sig = new byte[26];
    private String getKey(String str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < sig.length; i++) {
            sig[i] = 0;
        }
        for (int i = 0; i < str.length(); i++) {
            sig[str.charAt(i) - 97]++;
        }
        for (int i = 0; i < sig.length; i++) {
            result.append(sig[i]);
            if (sig[i] >= 10) {
                result.append(",");
            }
        }
        return result.toString();
    }
    private String getKey2(String str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < sig.length; i++) {
            sig[i] = 0;
        }
        for (int i = 0; i < str.length(); i++) {
            sig[str.charAt(i) - 97]++;
        }
        int zeroCount = 0;
        for (int i = 0; i < sig.length; i++) {
            if (sig[i] == 0) {
                zeroCount++;
            } else if (zeroCount > 1) {
                result.append(zeroCount).append(",");
                zeroCount = 0;
            }
            if (zeroCount <= 1) {
                result.append(sig[i]);
            }
            if (sig[i] >= 10) {
                result.append(",");
            }
        }
        return result.toString();
    }
}
