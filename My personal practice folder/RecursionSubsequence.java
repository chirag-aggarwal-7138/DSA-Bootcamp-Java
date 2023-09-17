public class RecursionSubsequence {
    public static void main(String[] args) {
        // System.out.println('a' + "");
        // skipCharacter("chirag", "");
        // System.out.println(skipCharacter2("chirag", ""));
        System.out.println(skipCharacter3("chirag"));
    }

    // Using without return function
    public static void skipCharacter(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
            
        }

        if (str.charAt(0) == 'a') {
            skipCharacter(str.substring(1), ans);
        } else {
            skipCharacter(str.substring(1), ans + str.charAt(0));
        }
    }

    // Using return function
    public static String skipCharacter2(String str, String ans) {
        if (str.isEmpty()) {
            return ans;
            
        }

        if (str.charAt(0) == 'a') {
            return skipCharacter2(str.substring(1), ans);
        }

        return skipCharacter2(str.substring(1), ans + str.charAt(0));
    }

    // Using return function without passing ans into parameter
    public static String skipCharacter3(String str) {
        if (str.isEmpty()) {
            return "";
            
        }

        if (str.charAt(0) == 'a') {
            return skipCharacter3(str.substring(1));
        }

        return str.charAt(0) + skipCharacter3(str.substring(1));
    }
}
