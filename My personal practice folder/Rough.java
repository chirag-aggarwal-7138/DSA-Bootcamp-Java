import java.util.HashMap;

public class Rough {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Chirag", 27);
        map.put("Aarshi", 18);

        System.out.println(map);

        String name = "civo";
        int code = name.hashCode();
        System.out.println(code);
    }
}
