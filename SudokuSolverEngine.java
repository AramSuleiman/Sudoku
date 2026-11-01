// Aram Suleiman
// CS 143
// HW #3: Sudoku #3 (solve)
//
// This program is a tester file for the sudoku board solve

import java.io.FileNotFoundException;

public class SudokuSolverEngine {

   public static void main(String[] args) throws FileNotFoundException {
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      MySudokuBoard board = new MySudokuBoard("/Users/as0987893/IdeaProjects/Sudoku/src/boards/very-fast-solve.sdk");
      System.out.println("Initial board");
      System.out.println(board);
      System.out.println();


      if (!board.isValid()) {
         System.out.println("This board is invalid and cant be solved");
      } else if (board.isSolved()){
         System.out.println("This board is already solved");
      } else {
         System.out.print("Solving board...");
         long start = System.currentTimeMillis();
         board.solve();
         long stop = System.currentTimeMillis();
         System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
         System.out.println();
         System.out.println(board);
      }
   }
}

/*

/Users/as0987893/Library/Java/JavaVirtualMachines/openjdk-24.0.2/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=53777 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/as0987893/IdeaProjects/Sudoku/out/production/Sudoku SudokuSolverEngine
Initial board
0 | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 |
0 | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 |
1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 |
0 | 0 | 9 | 0 | 6 | 1 | 4 | 2 | 3 |
0 | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 |
0 | 1 | 3 | 9 | 2 | 4 | 0 | 5 | 6 |
0 | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 |
0 | 8 | 0 | 4 | 1 | 9 | 6 | 3 | 5 |
3 | 4 | 5 | 0 | 8 | 6 | 1 | 7 | 9 |


Solving board...SOLVED in 0.902 seconds.

5 | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 |
6 | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 |
1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 |
8 | 5 | 9 | 7 | 6 | 1 | 4 | 2 | 3 |
4 | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 |
7 | 1 | 3 | 9 | 2 | 4 | 8 | 5 | 6 |
9 | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 |
2 | 8 | 7 | 4 | 1 | 9 | 6 | 3 | 5 |
3 | 4 | 5 | 2 | 8 | 6 | 1 | 7 | 9 |


Process finished with exit code 0

 */