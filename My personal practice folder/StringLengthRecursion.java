public class StringLengthRecursion {
    public static void main(String[] args) {
        System.out.println(length("chirag",0));
    }

    static int length(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        return 1 + length(str.substring(1));
    }

    static int length(String str, int count) {
        if (str.isEmpty()) {
            return count;
        }

        return length(str.substring(1), count + 1);
    }
}
