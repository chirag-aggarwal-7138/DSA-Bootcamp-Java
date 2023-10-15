public class SubStringRecursion {
    public static void main(String[] args) {
        System.out.println(subStringRecursion2("abbabac"));
    }

    static String subStringRecursion(String up, String p) {
        if (up == "") {
            return p;
        }

        if (up.charAt(0) == 'a') {
            return subStringRecursion(up.substring(1), p);
        }

        return subStringRecursion(up.substring(1), p + up.charAt(0));
    }

    static String subStringRecursion2(String up) {
        String p = "";

        if (up == "") {
            return p;
        }

        if (up.charAt(0) == 'a') {
            return subStringRecursion2(up.substring(1));
        }

        String str = subStringRecursion2(up.substring(1));
        return (str + up.charAt(0));
    }
}
