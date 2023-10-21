/**
 * The NQueens class solves the N-Queens problem using backtracking.
 * The problem is to place N chess queens on an N×N chessboard so that no two queens threaten each other.
 * Thus, a solution requires that no two queens share the same row, column, or diagonal.
 */
public class NQueens {
    /**
     * The main method initializes the board and calls the nQueens method to solve the problem.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Initialize the board with size n
        int n = 4;
        boolean[][] board = new boolean[n][n];
        // Call the nQueens method to solve the problem
        // nQueens(board, 0, 0);
        System.out.println(nQueens(board, 0, 0, 0, 4));
    }

    /**
     * The nQueens method solves the N-Queens problem using backtracking.
     * @param board The chessboard.
     * @param r The current row.
     */
    static int nQueens2(boolean[][] board, int r) {
        int count = 0;
        // If all queens have been placed, increment the counter and return
        if (r == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        // Try placing a queen in each column of the current row
        for (int c = 0; c < board.length; c++) {
            // Check if it is safe to place a queen at the current position
            if (isSafe(board, r, c)) {
                // Place the queen at the current position
                board[r][c] = true;
                // Recursively try placing queens in the remaining rows and increment the counter
                count += nQueens2(board, r + 1);
                // Remove the queen from the current position
                board[r][c] = false;
            }
        }
        return count;
    }

    /**
     * The display method prints the chessboard to the console.
     * @param board The chessboard.
     */
    static void display(boolean[][] board) {
        // Loop through each cell of the board and print either "Q" or "X"
        for(boolean[] i : board) {
            for (boolean j : i) {
                if (j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * The isSafe method checks if it is safe to place a queen at the given position.
     * @param board The chessboard.
     * @param r The row.
     * @param c The column.
     * @return True if it is safe to place a queen at the given position, false otherwise.
     */
    static boolean isSafe(boolean[][] board, int r, int c) {
        // Check if there is a queen in the same column
        for (int i = 0; i < r; i++) {
            if (board[i][c]) {
                return false;
            }
        }

        // Check if there is a queen in the same diagonal (top-left to bottom-right)
        int maxLeft = Math.min(r, c);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[r - i][c - i]) {
                return false;
            }
        }

        // Check if there is a queen in the same diagonal (top-right to bottom-left)
        int maxRight = Math.min(r, board.length - c - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[r - i][c + i]) {
                return false;
            }
        }
        // If there is no queen in the same row, column, or diagonal, it is safe to place a queen at the given position
        return true;
    }
    
    static void nQueens(boolean[][] board, int r, int c) {
        // If all queens have been placed, increment the counter and return
        if (r == board.length) {
            display(board);
            System.out.println();
            return;
        }
    
        // Try placing a queen in the current column
        if (isSafe(board, r, c)) {
            // Place the queen at the current position
            board[r][c] = true;
            // Recursively try placing queens in the remaining rows and increment the counter
            nQueens(board, r + 1, 0);
            // Remove the queen from the current position
            board[r][c] = false;
        }
    
        // Try placing a queen in the next column
        if (c < board.length - 1) {
            nQueens(board, r, c + 1);
        }
    
        return;
    }

    /**
     * This method recursively places queens on a chess board of size n x n such that no two queens threaten each other.
     * It returns the number of possible solutions for the given board.
     * 
     * @param board a 2D boolean array representing the chess board
     * @param r the current row being checked
     * @param c the current column being checked
     * @param count the number of solutions found so far
     * @return the number of possible solutions for the given board
     */
    static int nQueens(boolean[][] board, int r, int c, int count) {
        // If all queens have been placed, increment the counter and return
        if (r == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        
        int rowCheck = 0;
        // Try placing a queen in the current column
        if (isSafe(board, r, c)) {
            // Place the queen at the current position
            board[r][c] = true;
            // Recursively try placing queens in the remaining rows and increment the counter
            rowCheck = nQueens(board, r + 1, 0, count);
            // Remove the queen from the current position
            board[r][c] = false;
        }
        
        int colCheck = 0;
        // Try placing a queen in the next column
        if (c < board.length - 1) {
            colCheck = nQueens(board, r, c + 1, count);
        }
    
        // return rowCheck + colCheck;
        return rowCheck + colCheck;
    }

    /**
     * This method recursively places queens on a chessboard of size n x n such that no two queens threaten each other.
     * It returns the number of possible solutions for placing n queens on the board.
     * 
     * @param board a 2D boolean array representing the chessboard
     * @param r the current row being checked
     * @param c the current column being checked
     * @param count the number of solutions found so far
     * @param n the number of queens left to place on the board
     * @return the number of possible solutions for placing n queens on the board
     */
    static int nQueens(boolean[][] board, int r, int c, int count, int n) {
        // If all queens have been placed, increment the counter and return
        if (n == 0) {
            // Display the board
            display(board);
            // Print a new line
            System.out.println();
            // Return 1
            return 1;
        }
        
        int rowCheck = 0;
        // Try placing a queen in the current column
        if (isSafe(board, r, c)) {
            // Place the queen at the current position
            board[r][c] = true;
            // Recursively try placing queens in the remaining rows and increment the counter
            rowCheck = nQueens(board, r + 1, 0, count, n - 1);
            // Remove the queen from the current position
            board[r][c] = false;
        }
        
        int colCheck = 0;
        // Try placing a queen in the next column
        if (c < board.length - 1) {
            colCheck = nQueens(board, r, c + 1, count, n);
        }
    
        // return the sum of the number of valid solutions found by placing a queen in the current row and the number of valid solutions found by placing a queen in the next column
        return rowCheck + colCheck;
    }
}