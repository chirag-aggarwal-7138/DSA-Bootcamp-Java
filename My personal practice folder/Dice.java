import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        // System.out.println("" + 1);
        // diceCombination("", 4);
        System.out.println(diceCombination2("", 4));
    }

    public static void diceCombination(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i < 7 && i <= target; i++) {
            diceCombination(p + i, target - i);
        }
    }

    public static ArrayList<String> diceCombination2(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i < 7 && i <= target; i++) {
            ArrayList<String> lst = diceCombination2(p + i, target - i);
            ans.addAll(lst);
        }
        return ans;
    }
}
