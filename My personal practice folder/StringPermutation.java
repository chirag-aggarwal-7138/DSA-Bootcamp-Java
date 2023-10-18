import java.util.ArrayList;

public class StringPermutation {
    public static void main(String[] args) {
        // stringPermutation("", "abc");
        System.out.println(stringPermutation3("", "abc"));
    }

    static void stringPermutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }



        for (int i = 0; i < p.length() + 1; i++) {
            String f = p.substring(0, i);
            char ch = up.charAt(0);
            String s = p.substring(i, p.length());

            stringPermutation(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> stringPermutation2(String p, String up, ArrayList<String> lst) {
        if (up.isEmpty()) {
            lst.add(p);
            return lst;
        }



        for (int i = 0; i < p.length() + 1; i++) {
            String f = p.substring(0, i);
            char ch = up.charAt(0);
            String s = p.substring(i, p.length());

            stringPermutation2(f + ch + s, up.substring(1), lst);
        }
        return lst;
    }

    static ArrayList<String> stringPermutation3(String p, String up) {
        ArrayList<String> lst = new ArrayList<>();

        if (up.isEmpty()) {
            lst.add(p);
            return lst;
        }


        for (int i = 0; i < p.length() + 1; i++) {
            String f = p.substring(0, i);
            char ch = up.charAt(0);
            String s = p.substring(i, p.length());

            ArrayList<String> list = stringPermutation3(f + ch + s, up.substring(1));
            lst.addAll(list);
        }
        return lst;
    }
}
