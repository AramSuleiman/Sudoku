// Aram Suleiman
// CS 143
// HW #2: Sudoku #2 (isValid, isSolved)
//
// This program will hold all the data of the board class for our Sudoku

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MySudokuBoard {

    private int[][] board = new int[9][9]; // Board data

    // constructor
    // pre: file exists and has 9 x 9 characters
    // post: the board is filled with values of the file
    public MySudokuBoard(String path) throws FileNotFoundException {

        File file = new File(path);
        Scanner sc = new Scanner(file);
        int counter = 0;

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            for (int i = 0; i < 9; i++){
                if (line.charAt(i) == '.'){
                    board[counter][i] = 0;
                }else{
                    board[counter][i] = line.charAt(i) - 48;
                }
            }

            counter++;
        }



    }

    // pre: the constructor has been run
    // post: returns a string which displays the board
    public String toString(){
        String result = "";

        for (int x = 0;x < 9;x++){
            for (int y = 0; y < 9; y++){
                result = result + board[x][y] + " | ";
            }
            result = result + "\n";

        }

        return result;
    }

    // pre: MySudokuBoard has been declared
    // post: returns true if all spots have 0-9 value otherwise false
    private boolean isValidData() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] < 0 || board[row][col] > 9) {
                    return false;
                }
            }
        }

        return true;
    }

    // pre: MySudokuBoard has been declared
    // post: returns true if no row has duplicate 1-9 value otherwise false
    private boolean checkRows() {

        for (int row = 0; row < 9; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                int value = board[row][col];
                if (value != 0 && !seen.add(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    // pre: MySudokuBoard has been declared
    // post: returns true if no column has duplicate 1-9 value otherwise false
    private boolean checkCols() {

        for (int col = 0; col < 9; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                int value = board[row][col];
                if (value != 0 && !seen.add(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    // pre: spot is 1-9 value left to right and top to bottom on board
    // post: returns the correlating 3x3 mini square
    private int[][] miniSquare(int spot) {

        int[][] mini = new int[3][3];
        int startRow = (spot - 1) / 3 * 3;
        int startCol = (spot - 1) % 3 * 3;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                mini[row][col] = board[startRow + row][startCol + col];
            }
        }

        return mini;
    }

    // pre: MySudokuBoard has been declared
    // post: returns true if none of the 3x3 squares have duplicating values
    private boolean checkMiniSquares() {

        for (int spot = 1; spot <= 9; spot++) {
            int[][] mini = miniSquare(spot);
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    int value = mini[row][col];
                    if (value != 0 && !seen.add(value)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // pre: MySudokuBoard has been declared
    // post: returns true if sudoku is solved by rules of sudoku
    public boolean isSolved() {

        Map<Integer, Integer> counts = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = board[row][col];
                if (counts.containsKey(value)) {
                    counts.put(value, counts.get(value) + 1);
                } else {
                    counts.put(value, 1);
                }
            }
        }

        for (int num = 1; num <= 9; num++) {
            if (!counts.containsKey(num) || counts.get(num) != 9) {
                return false;
            }
        }
        return isValid();
    }

    // pre: MySudokuBoard has been declared
    // post: returns true if board is valid board has only 0-9 values and no row column or mini square has duplicates otherwise false
    public boolean isValid() {
        return isValidData() && checkRows() && checkCols() && checkMiniSquares();
    }
}
