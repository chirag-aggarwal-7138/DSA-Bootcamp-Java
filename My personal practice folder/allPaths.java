import java.util.Arrays;

public class allPaths {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        int[][] path = new int[board.length][board[0].length];
        // allPath("", board, 0, 0);
        allPathSteps("", board, 0, 0,path, 1);
    }

    static void allPath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPath(p + 'D', maze, r+1, c);
        }

        if (c < maze[0].length - 1) {
            allPath(p + 'R', maze, r, c+1);
        }

        if (r > 0) {
            allPath(p + 'U', maze, r-1, c);
        }

        if (c > 0) {
            allPath(p + 'L', maze, r, c-1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;  
    }

    static void allPathSteps(String p, boolean[][] maze, int r, int c, int[][] path, int steps) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c]= steps;
            // System.out.println(p);
            for (int[] nums : path) {
                System.out.println(Arrays.toString(nums));
            }
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = false;
        path[r][c] = steps;
        if (r < maze.length - 1) {
            allPathSteps(p + 'D', maze, r+1, c, path, ++steps);
        }

        if (c < maze[0].length - 1) {
            allPathSteps(p + 'R', maze, r, c+1, path, ++steps);
        }

        if (r > 0) {
            allPathSteps(p + 'U', maze, r-1, c, path, ++steps);
        }

        if (c > 0) {
            allPathSteps(p + 'L', maze, r, c-1, path, ++steps);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true; 
        path[r][c] = 0; 
    }
}