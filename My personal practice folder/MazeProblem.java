import java.util.Arrays;

/**
 * The MazeProblem class contains methods to solve the maze problem using recursion and backtracking algorithm.
 * The maze is represented as a grid of cells, where each cell can be either blocked or unblocked.
 * The class contains methods to find the number of unique paths from the top-left corner to the bottom-right corner of the maze,
 * to print all possible paths from the starting point to the ending point of the maze, and to print the path taken to reach the destination.
 * The class also contains a main method that calls the mazeProblemPathRiverAllPathsPrint method to find all possible paths from the starting point to the ending point of the maze.
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Maze_problem">Maze problem (Wikipedia)</a>
 */
public class MazeProblem {
    /**
     * The main method that calls the mazeProblem function and prints the result.
     * 
     * @param args The command line arguments passed to the program.
     */
    /**
     * This program demonstrates the solution to the maze problem using backtracking algorithm.
     * It initializes a boolean 2D array representing the maze, and an integer 2D array representing the path.
     * It then calls the mazeProblemPathRiverAllPathsPrint method to find all possible paths from the starting point (0,0) to the ending point (n-1,n-1).
     * The method prints all the paths found in the maze.
     * @param args command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // System.out.println(mazeProblem(3, 3));
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true } };

        int[][] path = new int[3][3];
        mazeProblemPathRiverAllPathsPrint(new String(""), 0, 0, maze, path, 1);
    }

    /**
     * Calculates the number of unique paths from the top-left corner to the
     * bottom-right corner of a maze.
     * 
     * @param r The number of rows in the maze.
     * @param c The number of columns in the maze.
     * @return The number of unique paths from the top-left corner to the
     *         bottom-right corner of the maze.
     */
    static int mazeProblem(int r, int c) {
        // Check if either r or c is equal to 1, which is the base case that stops the recursion
        if (r == 1 || c == 1) {
            return 1;
        }
    
        // Recursively calculate the number of possible paths through the maze
        return mazeProblem(r - 1, c) + mazeProblem(r, c - 1);
    }
    
    /**
     * Calculates the number of possible paths through a maze of size r x c.
     * 
     * @param r The number of rows in the maze.
     * @param c The number of columns in the maze.
     * @return The number of possible paths through the maze.
     */
    static int mazeProblem2(int r, int c) {
        // Check if either r or c is equal to 0, which is the base case that stops the recursion
        if (r == 0 || c == 0) {
            return 0;
        }
    
        // Check if r and c are both equal to 1, which is the base case that stops the recursion
        if (r == 1 && c == 1) {
            return 1;
        }
    
        // Recursively calculate the number of possible paths through the maze
        return mazeProblem2(r - 1, c) + mazeProblem2(r, c - 1);
    }
    
    /**
     * Recursively finds a path from the top-left corner to the bottom-right corner of a maze.
     * 
     * @param p The path taken so far, represented as a string of "R->" and "D->" characters.
     * @param r The current row number (0-indexed).
     * @param c The current column number (0-indexed).
     */
    static void mazeProblemPath(String p, int r, int c) {
        // Check if either r or c is equal to 0, which is the base case that stops the recursion
        if (r == 0 || c == 0) {
            return;
        }
    
        // Check if r and c are both equal to 1, which is the base case that stops the recursion
        if (r == 1 && c == 1) {
            // Print the path that led to the bottom-right corner
            System.out.println(p);
            return;
        }
    
        // Recursively explore the path to the right of the current cell
        mazeProblemPath(p + "R->", r - 1, c);
        // Recursively explore the path below the current cell
        mazeProblemPath(p + "D->", r, c - 1);
    }
    
    /**
     * Recursively finds and prints the path from the top-left corner to the bottom-right corner of a maze.
     * 
     * @param p The path taken so far, represented as a string of "R->" and "D->" indicating right and down movements respectively.
     * @param r The current row of the maze.
     * @param c The current column of the maze.
     */
    static void mazeProblemPath2(String p, int r, int c) {
        // Check if r and c are both equal to 1, which is the base case that stops the recursion
        if (r == 1 && c == 1) {
            // Print the path that led to the bottom-right corner
            System.out.println(p);
            return;
        }
    
        // Recursively explore the path to the right of the current cell
        if (r > 1) {
            mazeProblemPath2(p + "R->", r - 1, c);
        }
    
        // Recursively explore the path below the current cell
        if (c > 1) {
            mazeProblemPath2(p + "D->", r, c - 1);
        }
    }

    /**
     * This method solves the maze problem using recursion and prints the path taken
     * to reach the destination.
     * The maze is represented as a grid of cells, where each cell can be either
     * blocked or unblocked.
     * The method takes in the path taken so far, the current row and column of the
     * cell being explored.
     * If the current cell is the destination, the method prints the path taken so
     * far and returns.
     * If not, the method explores the neighboring cells in the order of right,
     * down-right diagonal and down.
     * The method continues to explore the neighboring cells until it reaches the
     * destination or all possible paths have been explored.
     * 
     * @param p the path taken so far
     * @param r the current row of the cell being explored
     * @param c the current column of the cell being explored
     */
    static void mazeProblemPathDiagonal(String p, int r, int c) {
        // Check if the current cell is the top-left corner of the maze
        if (r == 1 && c == 1) {
            // Print the path that led to the top-left corner
            System.out.println(p);
            return;
        }
    
        // Recursively explore the path to the right of the current cell
        if (r > 1) {
            mazeProblemPathDiagonal(p + "R->", r - 1, c);
        }
    
        // Recursively explore the path to the bottom-left of the current cell
        if (r > 1 && c > 1) {
            mazeProblemPathDiagonal(p + "DL->", r - 1, c - 1);
        }
    
        // Recursively explore the path below the current cell
        if (c > 1) {
            mazeProblemPathDiagonal(p + "D->", r, c - 1);
        }
    }

    /**
     * This method solves the maze problem by finding the path from the starting
     * point to the end point.
     * It takes in the starting point as a string, row and column indices of the
     * starting point, and a boolean 2D array representing the maze.
     * It recursively checks if the current cell is valid and not already visited,
     * and if it is the end point, prints the path.
     * It then recursively checks the cells to the right and below the current cell,
     * and appends the direction to the path string.
     * 
     * @param p    the path string representing the current path from the starting
     *             point to the current cell
     * @param r    the row index of the current cell
     * @param c    the column index of the current cell
     * @param maze the boolean 2D array representing the maze
     */
    static void mazeProblemPathRiver(String p, int r, int c, boolean[][] maze) {
        // Check if the current cell is not a valid path
        if (!maze[r][c]) {
            return;
        }
    
        // Check if the current cell is the bottom-right corner of the maze
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            // Print the path that led to the bottom-right corner
            System.out.println(p);
            return;
        }
    
        // Recursively explore the path to the right of the current cell
        if (r < maze.length - 1) {
            mazeProblemPathRiver(p + "R->", r + 1, c, maze);
        }
    
        // Recursively explore the path below the current cell
        if (c < maze[0].length - 1) {
            mazeProblemPathRiver(p + "D->", r, c + 1, maze);
        }
    }

    /**
     * Recursively finds all possible paths from the top-left corner to the
     * bottom-right corner of a given maze.
     * The maze is represented as a boolean 2D array, where true represents a path
     * and false represents a wall.
     * The method prints each path found in the format of a string of directions,
     * where R represents moving right, D represents moving down, L represents
     * moving left, and U represents moving up.
     * 
     * @param p    the current path taken to reach the current cell, represented as
     *             a string of directions
     * @param r    the current row index in the maze
     * @param c    the current column index in the maze
     * @param maze the boolean 2D array representing the maze
     */
    static void mazeProblemPathRiverAllPaths(String p, int r, int c, boolean[][] maze) {
        // Check if the current cell is not a valid path
        if (!maze[r][c]) {
            return;
        }

        // Check if the current cell is the bottom-right corner of the maze
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            // Print the path that led to the bottom-right corner
            System.out.println(p);
            return;
        }

        // Mark the current cell as visited
        maze[r][c] = false;

        // Recursively explore the path to the right of the current cell
        if (r < maze.length - 1) {
            mazeProblemPathRiverAllPaths(p + "D->", r + 1, c, maze);
        }

        // Recursively explore the path below the current cell
        if (c < maze[0].length - 1) {
            mazeProblemPathRiverAllPaths(p + "R->", r, c + 1, maze);
        }

        // Recursively explore the path above the current cell
        if (r > 0) {
            mazeProblemPathRiverAllPaths(p + "U->", r - 1, c, maze);
        }

        // Recursively explore the path to the left of the current cell
        if (c > 0) {
            mazeProblemPathRiverAllPaths(p + "L->", r, c - 1, maze);
        }

        // Mark the current cell as unvisited
        maze[r][c] = true;
    }

    /**
     * This method takes in a string p, integers r and c, a boolean 2D array maze, a
     * 2D integer array path, and an integer step.
     * It recursively explores all possible paths in the given maze starting from
     * the top-left corner and prints all the paths that lead to the bottom-right
     * corner.
     * It marks the visited cells in the maze and stores the path taken in the path
     * array.
     * If the current cell is not a valid path, it returns.
     * If the current cell is the bottom-right corner of the maze, it prints the
     * path that led to it and returns.
     * If the current cell is a valid path, it marks it as visited and recursively
     * explores the paths to the right, below, above, and to the left of the current
     * cell.
     * After exploring all possible paths from the current cell, it marks the
     * current cell as unvisited and removes the path taken from the path array.
     *
     * @param p    the string representing the path taken to reach the current cell
     * @param r    the row index of the current cell
     * @param c    the column index of the current cell
     * @param maze the boolean 2D array representing the maze
     * @param path the 2D integer array representing the path taken in the maze
     * @param step the integer representing the number of steps taken to reach the
     *             current cell
     */
    static void mazeProblemPathRiverAllPathsPrint(String p, int r, int c, boolean[][] maze, int[][] path, int step) {
        // Check if the current cell is not a valid path
        if (!maze[r][c]) {
            return;
        }

        // Check if the current cell is the bottom-right corner of the maze
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            // Set the current cell's step value in the path array
            path[r][c] = step;
            // Print the path array and the path that led to the bottom-right corner
            for (int[] i : path) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        // Mark the current cell as visited
        maze[r][c] = false;
        // Set the current cell's step value in the path array
        path[r][c] = step;

        // Recursively explore the path to the right of the current cell
        if (r < maze.length - 1) {
            mazeProblemPathRiverAllPathsPrint(p + "D->", r + 1, c, maze, path, step + 1);
        }

        // Recursively explore the path below the current cell
        if (c < maze[0].length - 1) {
            mazeProblemPathRiverAllPathsPrint(p + "R->", r, c + 1, maze, path, step + 1);
        }

        // Recursively explore the path above the current cell
        if (r > 0) {
            mazeProblemPathRiverAllPathsPrint(p + "U->", r - 1, c, maze, path, step + 1);
        }

        // Recursively explore the path to the left of the current cell
        if (c > 0) {
            mazeProblemPathRiverAllPathsPrint(p + "L->", r, c - 1, maze, path, step + 1);
        }

        // Mark the current cell as unvisited
        maze[r][c] = true;
        // Reset the current cell's step value in the path array
        path[r][c] = 0;
        return;
    }
}
