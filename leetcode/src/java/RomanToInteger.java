public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger instance = new RomanToInteger();
        System.out.println(instance.romanToInt("III"));
        System.out.println(instance.romanToInt("LVIII"));
        System.out.println(instance.romanToInt("MCMXCIV"));
    }
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            if (s.charAt(i) == 'M') {
                result += 1000;
            } else if (s.charAt(i) == 'C') {
                if (i < n - 1) {
                    if (s.charAt(i + 1) == 'M') {
                        result += 900;
                        i++;
                    } else if (s.charAt(i + 1) == 'D') {
                        result += 400;
                        i++;
                    } else {
                        result += 100;
                    }
                } else {
                    result += 100;
                }
            } else if (s.charAt(i) == 'X') {
                if (i < n - 1) {
                    if (s.charAt(i + 1) == 'C') {
                        result += 90;
                        i++;
                    } else if (s.charAt(i + 1) == 'L') {
                        result += 40;
                        i++;
                    } else {
                        result += 10;
                    }
                } else {
                    result += 10;
                }
            } else if (s.charAt(i) == 'I') {
                if (i < n - 1) {
                    if (s.charAt(i + 1) == 'X') {
                        result += 9;
                        i++;
                    } else if (s.charAt(i + 1) == 'V') {
                        result += 4;
                        i++;
                    } else {
                        result += 1;
                    }
                } else {
                    result += 1;
                }
            } else if (s.charAt(i) == 'V') {
                result += 5;
            } else if (s.charAt(i) == 'L') {
                result += 50;
            } else if (s.charAt(i) == 'D') {
                result += 500;
            }
        }
        return result;
    }
}
