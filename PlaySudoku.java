// Aram Suleiman
// CS 143
// HW #2: Sudoku #2 (isValid, isSolved)
//
// This program holds our main method, which runs Sudoku

import java.io.FileNotFoundException;

public class PlaySudoku {
    public static void main(String[] args) throws FileNotFoundException {
        MySudokuBoard game = new MySudokuBoard("/Users/as0987893/IdeaProjects/Sudoku/src/data1-1-1.sdk");
        System.out.println(game.toString());
    }
}

/*
/Users/as0987893/Library/Java/JavaVirtualMachines/openjdk-24.0.2/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=55944 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/as0987893/IdeaProjects/Sudoku/out/production/Sudoku PlaySudoku
2 | 0 | 0 | 1 | 0 | 5 | 0 | 0 | 3 |
0 | 5 | 4 | 0 | 0 | 0 | 7 | 1 | 0 |
0 | 1 | 0 | 2 | 0 | 3 | 0 | 8 | 0 |
6 | 0 | 2 | 8 | 0 | 7 | 3 | 0 | 4 |
0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
1 | 0 | 5 | 3 | 0 | 9 | 8 | 0 | 6 |
0 | 2 | 0 | 7 | 0 | 1 | 0 | 6 | 0 |
0 | 8 | 1 | 0 | 0 | 0 | 2 | 4 | 0 |
7 | 0 | 0 | 4 | 0 | 2 | 0 | 0 | 1 |


Process finished with exit code 0

 */