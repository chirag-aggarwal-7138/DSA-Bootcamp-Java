public class HCF_LCM {
    public static void main(String[] args) {
        System.out.println(hcf(2, 4));
    }

    static int hcf(int a, int b) {
        if (a == 0) {
            return b;
        }

        return hcf(b % a, a);
    }
}