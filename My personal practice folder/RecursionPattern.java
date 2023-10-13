public class RecursionPattern {
    public static void main(String[] args) {
        triangle2(4, 0);
    }

    static void triangle1(int i, int j) {
        if (i == 0) {
            return;
        }
        
        if (j == i) {
            System.out.println();
            triangle1(i - 1, 0);
            return;
        }   

        System.out.print("* ");
        triangle1(i, j + 1);
        return;
    }

    static void triangle2(int i, int j) {
        if (i == 0) {
            return;
        }
        
        if (j == i) {

            triangle2(i - 1, 0);
            System.out.println();
            return;
        }

        triangle2(i, j + 1);
        System.out.print("* ");
        return;
    }
}
