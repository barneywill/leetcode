import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        TextJustification instance = new TextJustification();
        System.out.println(instance.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(instance.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println(instance.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        List<String> line = new ArrayList<String>();
        int length = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (length + line.size() + word.length() > maxWidth) {
                result.add(generate(line, length, maxWidth, false));
                line.clear();
                length = 0;
            }
            line.add(word);
            length += word.length();
        }
        if (!line.isEmpty()) {
            result.add(generate(line, length, maxWidth, true));
        }
        return result;
    }
    private String generate(List<String> line, int length, int maxWidth, boolean isLast) {
        StringBuffer result = new StringBuffer();
        int empty = maxWidth - length - line.size() + 1;
        if (line.size() == 1 || isLast) {
            for (int i = 0; i < line.size(); i++) {
                result.append(line.get(i));
                if (i != line.size() - 1) {
                    result.append(" ");
                }
            }
            if (empty > 0) {
                for (int i = 0; i < empty; i++) {
                    result.append(" ");
                }
            }
        } else {
            int divide = empty / (line.size() - 1);
            int left = empty % (line.size() - 1);
            for (int i = 0; i < line.size(); i++) {
                result.append(line.get(i));
                if (i != line.size() - 1) {
                    result.append(" ");
                    if (divide > 0) {
                        for (int j = 0; j < divide; j++) {
                            result.append(" ");
                        }
                    }
                    if (left > 0) {
                        result.append(" ");
                        left--;
                    }
                }
            }
        }
        return result.toString();
    }
}
