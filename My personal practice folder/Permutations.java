public class Permutations {
    public static void main(String[] args) {
        // permutations("", "abc");
        System.out.println(permutationsCount("", "abcd"));
    }

    public static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + up.charAt(0) + s, up.substring(1));
        }
    }

    public static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + up.charAt(0) + s, up.substring(1));
        }
        return count;
    }
}

