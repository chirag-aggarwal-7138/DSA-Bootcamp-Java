import java.util.ArrayList;

public class PhoneNumberLetter {
    public static void main(String[] args) {
        //  System.out.println((int)('1' - '0'));
        // System.out.println((char)(1 + 'a'));
        // phoneNumberLetter("", "23");
        System.out.println(phoneNumberLetter2("", "23"));
    }

    // without returning an arraylist.
    public static void phoneNumberLetter(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            phoneNumberLetter(p + (char)(i + 'a'), up.substring(1));
        }
    }

    // with returning an arraylist.
    public static ArrayList<String> phoneNumberLetter2(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';

        ArrayList<String> ans = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            ans.addAll(phoneNumberLetter2(p + (char)(i + 'a'), up.substring(1)));
        }
        return ans;
    }
}
