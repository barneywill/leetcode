public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay instance = new CountAndSay();
        System.out.println(instance.countAndSay(1));
        System.out.println(instance.countAndSay(2));
        System.out.println(instance.countAndSay(3));
        System.out.println(instance.countAndSay(4));
    }
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String previous = countAndSay(n - 1);
//            System.out.println("previous : " + (n - 1) + ", " + previous);
            String result = "";
            char c = previous.charAt(0);
            int count = 1;
            for (int i = 1; i < previous.length(); i++) {
                if (previous.charAt(i) == previous.charAt(i - 1)) {
                    count++;
                } else {
                    result += count + "" + c;
                    c = previous.charAt(i);
                    count = 1;
                }
            }
            result += count + "" + c;
            return result;
        }
    }
}
