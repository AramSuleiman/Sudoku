// Aram Suleiman
// CS 143
// HW #1: Sudoku #1 (Board Setup)
//
// This program will hold all the data of the board class for our Sudoku

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuBoard {

    private int[][] board = new int[9][9]; // Board data

    // constructor
    // pre: file exists and has 9 x 9 characters
    // post: the board is filled with values of the file
    public SudokuBoard(String path) throws FileNotFoundException {

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


}
