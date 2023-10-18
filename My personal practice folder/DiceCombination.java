import java.util.ArrayList;

public class DiceCombination {
    public static void main(String[] args) {
        diceCombination("", 4);
        System.out.println(diceCombination2("", 4));
    }

    /**
     * This method generates all possible combinations of dice rolls that add up to a given number.
     * @param p a string representing the current combination of dice rolls
     * @param up an integer representing the remaining sum of the dice rolls
     */
    static void diceCombination(String p, int up) {
        if (up == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= up; i++) {
            diceCombination(p + i, up - i);
        }
    }

    static ArrayList<String> diceCombination2(String p, int up) {
        ArrayList<String> lst = new ArrayList<>();

        if (up == 0) {
            lst.add(p);
            return lst;
        }

        for (int i = 1; i <= up; i++) {
            ArrayList<String> list = diceCombination2(p + i, up - i);

            lst.addAll(list);
        }
        return lst;
    }
}
