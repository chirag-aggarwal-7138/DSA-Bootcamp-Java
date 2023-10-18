import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        System.out.println(phonePad2("", "12"));
    }

    /**
     * This method takes in a phone number and a string of digits and prints all possible combinations of letters that can be formed using the phone pad digits corresponding to the input string of digits.
     * @param p the current combination of letters formed
     * @param up the remaining string of digits to be processed
     */
    static void phonePad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {

            char ch = (char)('a' + i);

            phonePad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> phonePad2(String p, String up) {
        ArrayList<String> lst = new ArrayList<>();

        if (up.isEmpty()) {
            lst.add(p);
            return lst;
        }

        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {

            char ch = (char)('a' + i);

            ArrayList<String> list = phonePad2(p + ch, up.substring(1));

            lst.addAll(list);
        }

        return lst;
    }
}
