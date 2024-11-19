public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord instance = new LengthOfLastWord();
        System.out.println(instance.lengthOfLastWord("Hello World"));
        System.out.println(instance.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(instance.lengthOfLastWord("luffy is still joyboy"));
    }
    public int lengthOfLastWord(String s) {
        int result = 0;
        if (s.length() > 0) {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    if (result == 0) {
                        continue;
                    } else {
                        break;
                    }
                } else {
                    result++;
                }
            }
        }
        return result;
    }
}
