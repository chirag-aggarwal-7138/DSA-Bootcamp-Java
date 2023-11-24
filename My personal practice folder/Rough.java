import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rough {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Map

        map.put("Chirag", 27);
        map.put("Aarshi", 18);

        System.out.println(map);

        String name = "civo";
        int code = name.hashCode();
        System.out.println(code);

        int[] nums = {1, 1, 2, 2, 2, 3, 3};

        Arrays.sort(nums);

        int i = 0;
        int j = 1;
        int count = 0;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                count++;
                i++;
                nums[i] = nums[j];
            }
        }

        System.out.println(count + 1);
        System.out.println(Arrays.toString(nums));
    }
}
