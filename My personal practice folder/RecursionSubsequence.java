/**
 * This class contains three methods to skip the character 'a' from a given string using recursion.
 * The first method skips the character 'a' from the given string and prints the resulting string.
 * The second method skips the character 'a' from the given string and returns the resulting string.
 * The third method skips the character 'a' from the given string and returns the resulting string without passing ans into parameter.
 */
public class RecursionSubsequence {
    public static void main(String[] args) {
        // System.out.println('a' + "");
        // skipCharacter("chirag", "");
        // System.out.println(skipCharacter2("chirag", ""));
        System.out.println(skipCharacter3("chirag"));
    }

    // Using without return function
    /**
     * This method skips the character 'a' from the given string and returns the resulting string.
     * If the given string is empty, it prints the resulting string.
     * @param str the input string to skip 'a' character from
     * @param ans the resulting string after skipping 'a' character
     */
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
