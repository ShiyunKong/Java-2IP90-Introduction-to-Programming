package nl.tue.assignments.sudoku;

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
public class SudokuSolver {
    private SudokuGrid grid;

    /**
     * Instantiates a new Sudoku solver.
     *
     * @param grid the grid
     */
    public SudokuSolver(SudokuGrid grid) {
        // Initialize the SudokuSolver with the provided SudokuGrid
        this.grid = grid;
    }

    /**
     * Solve boolean.
     *
     * @return the boolean
     */
    public boolean solve() {
        // Use a recursive strategy to solve the Sudoku puzzle.
        int[][] solvingGrid = grid.copy();
        if (grid.solveSudoku(solvingGrid)) {
            grid.printSudoku(solvingGrid);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Create a SudokuGrid and a SudokuSolver.
     * Call solve() to solve the puzzle and print the solution or a message if no solution is found.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a SudokuGrid and a SudokuSolver
        // Call solve() to solve the puzzle 
        // and print the solution or a message if no solution is found
        SudokuGrid grid = new SudokuGrid();
        SudokuSolver solver = new SudokuSolver(grid);
        if (!solver.solve()) {
            System.out.println("a message indicating that no solution was found.");
        }
    }
}