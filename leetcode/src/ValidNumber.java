public class ValidNumber {
    public static void main(String[] args) {
        ValidNumber instance = new ValidNumber();
        System.out.println(instance.isNumber("0"));
        String[] arr = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        for (String str : arr) {
            System.out.println(str + "->" + instance.isNumber(str));
        }
        arr = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        for (String str : arr) {
            System.out.println(str + "->" + instance.isNumber(str));
        }
    }
    public boolean isNumber(String s) {
        if (s.length() > 0) {
            int numberStart = 0;
            int numberEnd = s.length() - 1;
            int eStart = -1;
            int eEnd = -1;
            if (!((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '.')) {
                return false;
            }
            if (!((s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9') || s.charAt(s.length() - 1) == '.')) {
                return false;
            }
            if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                numberStart++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                    numberEnd = i - 1;
                    eStart = i + 1;
                    if (eStart <= s.length() - 1) {
                        if (s.charAt(eStart) == '+' || s.charAt(eStart) == '-') {
                            eStart++;
                        }
                    }
                    eEnd = s.length() - 1;
                    break;
                }
            }
            if (numberStart < 0 || numberEnd < 0 || numberStart > s.length() - 1 || numberEnd > s.length() - 1 || numberStart > numberEnd) {
//                System.out.println("bad number : " + numberStart + ", " + numberEnd);
                return false;
            } else if (eStart > s.length() - 1 || eEnd > s.length() - 1 || (eStart != -1 && eStart > eEnd)) {
//                System.out.println("bad e : " + eStart + ", " + eEnd);
                return false;
            } else {
                //check number
                boolean isDecimal = false;
                for (int i = numberStart; i <= numberEnd; i++) {
                    if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.') {
                        if (s.charAt(i) == '.') {
                            if (i == numberStart && i == numberEnd) {
                                return false;
                            }
                            else if (!isDecimal) {
                                isDecimal = true;
                            } else {
//                                System.out.println("bad decimal");
                                return false;
                            }
                        }
                    } else {
//                        System.out.println("bad number");
                        return false;
                    }
                }
                //check e
                if (eStart != -1) {
                    for (int i = eStart; i <= eEnd; i++) {
                        if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {

                        } else {
//                            System.out.println("bad e");
                            return false;
                        }
                    }
                }
            }
        } else {
//            System.out.println("empty");
            return false;
        }
        return true;
    }
}
