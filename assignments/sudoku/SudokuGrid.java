package nl.tue.assignments.sudoku;

import java.awt.Point;
import java.util.Random;
/**
 * Write a solver for Sudoku. Sudoku is a variation on the Sudoku puzzle.
 * A Sudoku puzzle contains a grid of three by three boxes.
 * These boxes contain three by three squares. Thus, the puzzle consists of nine by nine squares.
 * Initially, some squares are filled with a number.
 * The challenge for the puzzler is to fill in all squares with the numbers one (1) to nine (9)
 * such that each row, each column, and each box contains each number one through nine exactly once.
 *
 * @author Shiyun Kong
 * @author Xiuqi Shi
 * @id 1920847
 * @id 1935526
 */

public class SudokuGrid {
    /**
     * The Random.
     */
    Random random = new Random();
    private static final int SIZE = 9;
    private static final int DIGIT_RANGE = 9;

    private int[][] grid;
    /**
     * Instantiates a new Sudoku grid.
     */

    public SudokuGrid() {
        // Initialize the grid and set rEmpty and cEmpty to -1
        final int[][] defaultGrid = new int[][] {
                {0, 9, 0, 7, 3, 0, 4, 0, 0},
                {0, 0, 0, 0, 1, 0, 5, 0, 0},
                {3, 0, 4, 0, 0, 6, 9, 0, 0},
                {0, 0, 0, 0, 0, 2, 6, 4, 0},
                {0, 3, 0, 6, 5, 1, 0, 8, 0},
                {0, 0, 6, 9, 0, 7, 0, 0, 0},
                {5, 8, 2, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 3, 0, 2, 5},
                {6, 0, 3, 0, 7, 0, 8, 0, 0},
        };
        grid = defaultGrid;

    }

    /**
     * Create a copy of the SudokuGrid and return it.
     *
     * @return a copy of the SudokuGrid
     */
    public int[][] copy() {
        // Create a copy of the SudokuGrid and return it
        int[][] gridCopy = new int[SIZE][SIZE];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gridCopy[i][j] = grid[i][j];
            }
        }
        return gridCopy;
    }

    /**
     * Finds the next empty cell in reading order and returns its coordinates as a Point.
     *
     * @return the coordinates of the empty cell as a Point, or null if no empty cell is found
     */
    public Point findEmptyCell() {
        // Find the next empty cell in reading order and return its coordinates as a Point
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 0) {
                    return new Point(row, col);
                }
            }
        }
        return null;
    }

    /**
     * Print the Sudoku grid.
     */
    public void print() {
        // Print the Sudoku grid
        for (int[] ints : grid) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * Fill cell.
     *
     * @param r the r
     * @param c the c
     */
    public void fillCell(int r, int c) {
        // Fill the cell at row r and column c
        // Try to fill the empty cell with numbers from 1 to 9
        for (int num = 1; num <= DIGIT_RANGE; num++) {
            if (givesConflict(r, c, num)) {
                grid[r][c] = num;
                if (findEmptyCell() == null) {
                    break;
                }
                grid[r][c] = 0; // Backtrack
            }
        }
    }

    /**
     * Check if filling the number d in the cell at row r and column c causes a conflict.
     *
     * @param r The row number of the cell
     * @param c The column number of the cell
     * @param d The value to be filled in the cell
     * @return true if filling the number d causes a conflict, false otherwise
     */
    public boolean givesConflict(int r, int c, int d) {
        // Check if filling the number d in the cell at row r and column c causes a conflict
        // true if filling the number d causes a conflict, false otherwise
        return rowConflict(r, d) || colConflict(c, d) || boxConflict(r, c, d);
    }

    /**
     * Check if there is a conflict in the row r when filling the number d.
     *
     * @param  r  the row index
     * @param  d  the number to fill
     * @return    true if there is a conflict, false otherwise
     */
    private boolean rowConflict(int r, int d) {
        // Check if there is a conflict in the row r when filling the number d
        for (int i = 0; i < grid[r].length; i++) {
            boolean check = grid[r][i] == d;
            if (check) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there is a conflict in the column c when filling the number d.
     *
     * @param  c  the column index
     * @param  d  the number to fill
     * @return    true if there is a conflict, false otherwise
     */
    private boolean colConflict(int c, int d) {
        // Check if there is a conflict in the column c when filling the number d
        for (int i = 0; i < c; i++) {
            boolean check = grid[i][c] == d;
            if (check) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there is a conflict in the 3x3 box containing the cell at row r and column c,
     * when filling the number d.
     *
     * @param  r  The row of the cell
     * @param  c  The column of the cell
     * @param  d  The number to fill in the cell
     * @return    True if there is a conflict, False otherwise
     */

    private boolean boxConflict(int r, int c, int d) {
        // Check if there is a conflict in the 3x3 box containing the cell at row r and column c
        // when filling the number d
        int rBox = (int) Math.floor(r / 3); //向下取整
        int cBox = (int) Math.floor(c / 3); //向下取整

        int[] rBoxRange = new int[3];
        for (int i = 0; i < 3; i++) {
            rBoxRange[i] = rBox * 3 + i;
        }
        int[] cBoxRange = new int[3];
        for (int i = 0; i < 3; i++) {
            cBoxRange[i] = cBox * 3 + i;
        }
        for (int rNum : rBoxRange) {
            for (int cNum : cBoxRange) {
                boolean check = grid[rNum][cNum] == d;
                if (check) {
                    return true;
                }
            }

        }
        return false;
    }


    /**
     * Solve sudoku boolean.
     *
     * @param board the board
     * @return the boolean
     */

    public boolean solveSudoku(int[][] board) {
        int emptyCell = -1;
        int row = -1;
        int col = -1;

        // Find the first empty cell
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    emptyCell = 1;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (emptyCell == 1) {
                break;
            }
        }

        // If there are no empty cells, the Sudoku puzzle is solved
        if (emptyCell == -1) {
            return true;
        }

        // Try to fill the empty cell with numbers from 1 to 9
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                // try {
                //    Thread.sleep(750); // Sleep for 500 milliseconds (0.5 seconds)
                // } catch (InterruptedException e) {
                //    e.printStackTrace();
                //    }
                // printSudoku(board);
                if (solveSudoku(board)) {
                    return true;
                }
                board[row][col] = 0; // Backtrack
            }
        }

        return false; // No solution found
    }

    /**
     * Is safe boolean.
     *
     * @param board the board
     * @param row   the row
     * @param col   the col
     * @param num   the num
     * @return the boolean
     */
    public boolean isSafe(int[][] board, int row, int col, int num) {
        // Check if the number num is safe to place at board[row][col]
        return !usedInRow(board, row, num) && !usedInCol(board, col, num)
             && !usedInBox(board, row - row % 3, col - col % 3, num);
    }

    /**
     * Used in row boolean.
     *
     * @param board the board
     * @param row   the row
     * @param num   the num
     * @return the boolean
     */
    public boolean usedInRow(int[][] board, int row, int num) {
        // Check if the number num is used in the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Used in col boolean.
     *
     * @param board the board
     * @param col   the col
     * @param num   the num
     * @return the boolean
     */
    public boolean usedInCol(int[][] board, int col, int num) {
        // Check if the number num is used in the column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Used in box boolean.
     *
     * @param board       the board
     * @param boxStartRow the box start row
     * @param boxStartCol the box start col
     * @param num         the num
     * @return the boolean
     */
    public boolean usedInBox(int[][] board, int boxStartRow, int boxStartCol, int num) {
        // Check if the number num is used in the 3x3 box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + boxStartRow][j + boxStartCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Print sudoku.
     *
     * @param board the board
     */
    public void printSudoku(int[][] board) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (i % 3 == 0) {
                System.out.println("+-----------------+");
            }
            for (int j = 0; j < len; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
                if (!((j == 2) || (j == 5) || (j == 8))) {
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+-----------------+");
    }
}