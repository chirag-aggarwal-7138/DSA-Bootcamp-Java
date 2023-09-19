import java.util.ArrayList;

public class MazeProblem {
    public static void main(String[] args) {
        // System.out.println(maze(3, 3));
        // pathDiagonal("", 3, 3);
        // System.out.println(path2("", 3, 3));
        // System.out.println(pathDiagonal2("", 3, 3));
        // river("", 0, 0);
        // System.out.println(river2("", 0, 0));

        boolean[][] board = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
        };

        pathRestrictions("", board, 0, 0);
    }

    // Just for number of paths
    public static int maze(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;   
        }

        int left = maze(r - 1, c);
        int right = maze(r, c - 1);

        return left + right;
    }

    // For complete path
    // Just printing the path
    public static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 0 && c > 0) {
            path(p.concat("D -> "), r - 1, c);
            path(p.concat("R -> "), r, c - 1);
        }
    }

    // using diagonal path
    public static void pathDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 0 && c > 0) {
            pathDiagonal(p.concat("D -> "), r - 1, c);
            pathDiagonal(p.concat("R -> "), r, c - 1);
            pathDiagonal(p.concat("DN -> "), r - 1, c - 1);
        }
    }

    // For complete path
    // Returning the path using a String ArrayList
    public static ArrayList<String> path2(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList ans = new ArrayList<>();

        if (r > 0 && c > 0) {
            ans.addAll(path2(p.concat("D -> "), r - 1, c));
            ans.addAll(path2(p.concat("R -> "), r, c - 1));
        }

        return ans;
    }

    public static ArrayList<String> pathDiagonal2(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        
        if (r > 0 && c > 0) {
            ans.addAll(pathDiagonal2(p.concat("D -> "), r - 1, c));
            ans.addAll(pathDiagonal2(p.concat("R -> "), r, c - 1));
            ans.addAll(pathDiagonal2(p.concat("DN -> "), r - 1, c - 1));
        }
        return ans;
    }

    public static void river(String p, int r, int c) {
        if (r == 2 && c == 2) {
            System.out.println(p);
            return;
        }

        if (r == 1 && c == 1) {
            return;
        }

        if (r < 3 && c < 3) {
            river(p.concat("D -> "), r + 1, c);
            river(p.concat("R -> "), r, c + 1);
        }
    }

    public static ArrayList<String> river2(String p, int r, int c) {
        if (r == 2 && c == 2) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        if (r == 1 && c == 1) {
            return ans;
        }

        if (r < 3 && c < 3) {
            ans.addAll(river2(p.concat("D -> "), r + 1, c));
            ans.addAll(river2(p.concat("R -> "), r, c + 1));
        }
        return ans;
    }

    // For a general matrix
    static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length - 1) {
            pathRestrictions(p + 'D', maze, r+1, c);
        }

        if (c < maze[0].length - 1) {
            pathRestrictions(p + 'R', maze, r, c+1);
        }
    }
}