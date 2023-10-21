/**
 * This class solves a given Sudoku puzzle using backtracking algorithm.
 * The puzzle is represented as a 2D array of integers where 0 represents an empty cell.
 * The solution is displayed on the console.
 * 
 * @param board the Sudoku puzzle to be solved
 * @return true if the puzzle is solved, false otherwise
 */
/**
 * This class solves a given Sudoku puzzle using backtracking algorithm.
 */
/**
 * This class provides a Sudoku solver using backtracking algorithm.
 */
public class SudokuSolver {

    /**
     * The main method initializes the Sudoku board and calls the sudoku method to solve it.
     * If the puzzle is solved, it calls the display method to print the solved board.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Initialize the Sudoku board
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Solve the Sudoku puzzle
        if(sudoku(board)) {
            // Display the solved board
            display(board);
        }
    }

    /**
     * This method solves the Sudoku puzzle using backtracking algorithm.
     * @param board the Sudoku board to be solved
     * @return true if the puzzle is solved, false otherwise
     */
    static boolean sudoku(int[][] board) {
        // Get the size of the board
        int n = board.length;
        // Initialize the row and column indices to -1
        int r = -1;
        int c = -1;

        // Check if the board has any empty cells
        boolean empty = true;
        for (int i = 0; i < n; i++) {
            for (int j =  0; j < n; j++) {
                if (board[i][j] == 0) {
                    // If an empty cell is found, set the row and column indices and set empty to false
                    r = i;
                    c = j;
                    empty = false;
                    break;
                }
            }
            if (empty == false) {
                break;
            }
        }

        // If the board is completely filled, return true
        if (empty == true) {
            return true;
        }

        // Try placing numbers from 1 to 9 in the empty cell
        for (int num = 1; num < 10; num++) {
            if (isSafe(board, r, c, num)) {
                // If the number can be placed in the cell, set the cell to the number and recursively call the sudoku method
                board[r][c] = num;
                if(sudoku(board)) {
                    // If the puzzle is solved, display the solved board and return true
                    display(board);
                    return true;
                } else {
                    // If the puzzle is not solved, backtrack by setting the cell back to 0
                    board[r][c] = 0;
                }
            }
        }
        // If no number can be placed in the cell, return false
        return false;
    }

    /**
     * This method displays the solved Sudoku board.
     * @param board the solved Sudoku board to be displayed
     */
    static void display(int[][] board) {
        // Loop through each row and column of the board and print the number at each cell
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method checks if a given number can be placed in a given cell of the Sudoku board.
     * @param board the Sudoku board
     * @param r the row index of the cell
     * @param c the column index of the cell
     * @param n the number to be placed in the cell
     * @return true if the number can be placed in the cell, false otherwise
     */
    static boolean isSafe(int[][] board, int r, int c, int n) {
        // Check if the number is already present in the same row or column
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == n) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == n) {
                return false;
            }
        }

        // Check if the number is already present in the same 3x3 sub-grid
        int sqrt = (int)Math.sqrt(board.length);
        int colStart = r - r % sqrt;
        int rowStart = c - c % sqrt;

        for (int i = colStart; i < colStart + sqrt; i++) {
            for (int j = rowStart; j < rowStart + sqrt; j++) {
                if (board[i][j] == n) {
                    return false;
                }
            } 
        }
        // If the number can be placed in the cell, return true
        return true;
    }
}
