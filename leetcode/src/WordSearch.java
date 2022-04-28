import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch instance = new WordSearch();
        char[][] board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        };
        System.out.println(instance.exist(board, "ABCCED"));

        board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        };
        System.out.println(instance.exist(board, "SEE"));

        board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        };
        System.out.println(instance.exist(board, "ABCB"));

        //[["a","a","a","a"],["a","a","a","a"],["a","a","a","a"]]
        //"aaaaaaaaaaaaa"
        board = new char[][]{
                new char[]{'a','a','a','a'},
                new char[]{'a','a','a','a'},
                new char[]{'a','a','a','a'}
        };
        System.out.println(instance.exist(board, "aaaaaaaaaaaaa"));
    }
    public boolean exist(char[][] board, String word) {
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        Map<Character, List<int[]>> map = new HashMap<Character, List<int[]>>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.length() == 1 && board[i][j] == word.charAt(0)) {
                    return true;
                }
                if (!map.containsKey(board[i][j])) {
                    map.put(board[i][j], new ArrayList<int[]>());
                }
                map.get(board[i][j]).add(new int[]{i, j});
            }
        }
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (int i = 0; i < word.length(); i++) {
            if (!charCount.containsKey(word.charAt(i))) {
                charCount.put(word.charAt(i), 0);
            }
            charCount.put(word.charAt(i), charCount.get(word.charAt(i)) + 1);
        }
        for (Character c : charCount.keySet()) {
            if (!map.containsKey(c) || map.get(c).size() < charCount.get(c)) {
                return false;
            }
        }
        List<int[]> result = search(map, word, 0, new ArrayList<int[]>());
        return result != null;
    }
    private List<int[]> search(Map<Character, List<int[]>> map, String word, int currentIndex, List<int[]> prefixs) {
//        System.out.println("search : " + word + ", " + currentIndex +  ", " + prefixs);
        if (currentIndex > word.length() - 1) {
            return prefixs;
        } else {
            List<int[]> indexs = map.get(word.charAt(currentIndex));
            if (indexs != null && !indexs.isEmpty()) {
                for (int[] index : indexs) {
                    if (prefixs.isEmpty() || isAdjacent(prefixs.get(prefixs.size() - 1), index)) {
                        boolean isFound = false;
                        for (int[] prefix : prefixs) {
                            if (prefix[0] == index[0] && prefix[1] == index[1]) {
                                isFound = true;
                                break;
                            }
                        }
                        if (!isFound) {
                            List<int[]> nextPrefixs = new ArrayList<int[]>(prefixs);
                            nextPrefixs.add(index);
                            List<int[]> result =  search(map, word, currentIndex + 1, nextPrefixs);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
    private boolean isAdjacent(int[] index1, int[] index2) {
        return (index1[0] == index2[0] && Math.abs(index1[1] - index2[1]) == 1) || (index1[1] == index2[1] && Math.abs(index1[0] - index2[0]) == 1);
    }
}
