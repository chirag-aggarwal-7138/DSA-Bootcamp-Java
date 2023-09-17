import java.util.*;

public class SubString {
    public static void main(String[] args) {
        // subString("", "chirag");
        // ArrayList<String> list = new ArrayList<>();
        // System.out.println(subString2("", "abc", list));
        // System.out.println(subString3("", "abc"));
        SubStringAscii("", "abc");
    }

    // With printing without returning
    public static void subString(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        subString(p, up.substring(1));
        subString(p + up.charAt(0), up.substring(1));

    }

    // with arraylist return
    public static ArrayList<String> subString2(String p, String up, ArrayList<String> list) {
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }
        subString2(p, up.substring(1), list);
        subString2(p + up.charAt(0), up.substring(1), list);

        return list;
    }

    // With arraylist inside the body of the func.
    public static ArrayList<String> subString3(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = subString3(p, up.substring(1));
        ArrayList<String> right = subString3(p + up.charAt(0), up.substring(1));

        left.addAll(right);

        return left;
    }

    public static void subStringAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        subStringAscii(p, up.substring(1));
        subStringAscii(p + up.charAt(0), up.substring(1));
        subStringAscii(p + (up.charAt(0) + 0), up.substring(1));
    }
}
