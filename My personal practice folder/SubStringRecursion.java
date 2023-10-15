public class SubStringRecursion {
    public static void main(String[] args) {
        // System.out.println(subStringRecursion2("abbabac"));
        System.out.println(skipApple3("chiapplerag"));
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

    static String subStringRecursion3(String up) {
        String p = "";

        if (up == "") {
            return p;
        }

        if (up.charAt(0) == 'a') {
            return subStringRecursion3(up.substring(1));
        }

        char ch = up.charAt(0);
        return ch + subStringRecursion3(up.substring(1));
    }

    static String skipApple(String up, String p) {
        if (up == "") {
            return p;
        }

        if (up.startsWith("apple")) {
            return skipApple(up.substring(5), p);
        }

        return skipApple(up.substring(1), p + up.charAt(0));
    }

    static String skipApple2(String up) {
        String p = "";

        if (up == "") {
            return p;
        }

        if (up.startsWith("apple")) {
            return skipApple2(up.substring(5));
        }

        return up.charAt(0) + skipApple2(up.substring(1));
    }

    static String skipApple3(String up) {
        String p = "";

        if (up == "") {
            return p;
        }

        if (up.startsWith("apple")) {
            return skipApple3(up.substring(5));
        }

        String str = skipApple3(up.substring(1));
        str += up.charAt(0);
        return str;
    }
}
