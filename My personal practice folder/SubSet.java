import java.util.ArrayList;

public class SubSet {
    public static void main(String[] args) {
        // System.out.println(subSet3("", "abc"));
        // System.out.println(subSet4("", "abc"));
        // System.out.println(subSet2("", "abc", new ArrayList<>()));
        System.out.println(palindromicPartition("geeks"));
    }

    /**
     * This method generates all possible subsets of a given string.
     * @param p the prefix string
     * @param up the remaining string
     */
    static void subSet(String p, String up) {
        if (up == "") {
            System.out.println(p);
            return;
        }

        subSet(p, up.substring(1));
        subSet(p + up.charAt(0), up.substring(1));
        return;
    }

    static ArrayList<String> subSet2(String p, String up, ArrayList<String> lst) {
        if (up == "") {
            lst.add(p);
            lst.sort(null);
            return lst;
        }

        subSet2(p + up.charAt(0), up.substring(1), lst);
        subSet2(p, up.substring(1), lst);

        return lst;
    }

    static ArrayList<String> subSet3(String p, String up) {
        ArrayList<String> lst = new ArrayList<>();

        if (up == "") {
            lst.add(p);
            return lst;
        }

        ArrayList<String> right = subSet3(p + up.charAt(0), up.substring(1));
        ArrayList<String> left = subSet3(p, up.substring(1));
        
        lst.addAll(left);
        lst.addAll(right);
        return lst;
    }

     static ArrayList<String> subSet4(String p, String up) {
        ArrayList<String> lst = new ArrayList<>();

        if (up == "") {
            lst.add(p);
            return lst;
        }

        ArrayList<String> right = subSet4(p + up.charAt(0), up.substring(1));
        ArrayList<String> left = subSet4(p, up.substring(1));
        
        right.addAll(left);
        return right;
    }

    static void subSetAscii(String p, String up) {
        if (up == "") {
            System.out.println(p);
            return;
        }

        subSetAscii(p, up.substring(1));
        subSetAscii(p + up.charAt(0), up.substring(1));
        subSetAscii(p + (up.charAt(0) + 0), up.substring(1));
        return;
    }

    static boolean isPalindrome(String str) {
        int s = 0;
        int e = str.length() - 1;

        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            } else {
                s++;
                e--;
            }
        }
        return true;
    }

    static ArrayList<String> palindromicPartition(String str) {
        ArrayList<String> ans = new ArrayList<>();

        ArrayList<String> subset = subSet2("", str, new ArrayList<>());
        String[] subSet = new String[subset.size()];
        subSet = subset.toArray(subSet);
        for (String i : subSet) {
            if (isPalindrome(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}