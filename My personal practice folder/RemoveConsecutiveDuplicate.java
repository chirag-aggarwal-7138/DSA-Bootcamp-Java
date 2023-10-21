public class RemoveConsecutiveDuplicate {
    public static void main(String[] args) {
        System.out.println(removeDuplicate("", "aaabbbb"));
    }

    static String removeDuplicate(String p, String up) {
        if (up.isEmpty()) {
            return p;
        }

        if (up.length() == 1) {
            return removeDuplicate(p + up.charAt(0), up.substring(1));
        }
        
        if (up.charAt(0) == up.charAt(1)) {
            return removeDuplicate(p, up.substring(1));
        }

        return removeDuplicate(p + up.charAt(0), up.substring(1));
    }
}