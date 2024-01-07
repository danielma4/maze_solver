/*
Find Start
Push Position on Stack
Are you done? (You are on the finish spot) - if yes then the stack contains your solution

If you can Go Up without backtracking, go to #2
If you can Go Down without backtracking, go to #2
If you can Go Left without backtracking, go to #2
If you can Go Right without backtracking, go to #2

Pop Position off Stack, go to #2 (if stack is empty then maze is impossible)
*/

import java.util.Scanner;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        Stack stackR = new Stack();
        Stack stackC = new Stack();
        Stack solutionR = new Stack();
        Stack solutionC = new Stack();

     /*
    Read maze file into something...
    probably a 2D array of chars or Strings
    */

        char[][] maze;

        Scanner file = new Scanner(new File("maze.txt"));

        // to figure out the number of rows and columns...
        // because there should be no spaces, a single
        // file.next() should grab a whole line.
        // the width of the maze is the length of that string (for a single line)
        // the height of the maze is how many rows there are

        int rows = 0;
        int cols = 0;

        // this loop should count the height and width of the maze
        while(file.hasNext()){
            String line = file.next();
            rows++;
            cols = line.length();
        }

        maze = new char[rows][cols];

        // reset the scanner so we can actually read the characters into the array
        file = new Scanner(new File("maze.txt"));

        // this loop should read all the characters into the array
        for(int r = 0; r < rows; r++){
            String thisRow = file.next();
            System.out.print("\n");
            for(int c = 0; c < cols; c++){
                maze[r][c] = thisRow.charAt(c);
                System.out.print(maze[r][c]);
            }
        }

        int xPos = 0;
        int yPos = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (maze[r][c] == '@') {
                    xPos = r;
                    yPos = c;
                }
            }
        }

        System.out.println("\n" + xPos + ", " + yPos);


        while (maze[xPos][yPos] != '$') {

            if (xPos != 0 && (maze[xPos - 1][yPos] != '#')) {
                maze[xPos][yPos] = '#';
                xPos = xPos - 1;
                stackR.push(xPos);
                stackC.push(yPos);
            } else if (xPos < rows - 1 && maze[xPos + 1][yPos] != '#') {
                maze[xPos][yPos] = '#';
                xPos = xPos + 1;
                stackR.push(xPos);
                stackC.push(yPos);
            } else if (yPos != 0 && (maze[xPos][yPos - 1] != '#')) {
                maze[xPos][yPos] = '#';
                yPos = yPos - 1;
                stackR.push(xPos);
                stackC.push(yPos);
            } else if (yPos < cols - 1 && maze[xPos][yPos + 1] != '#') {
                maze[xPos][yPos] = '#';
                yPos = yPos + 1;
                stackR.push(xPos);
                stackC.push(yPos);
            } else {
                maze[xPos][yPos] = '#';
                stackR.pop();
                stackC.pop();
                xPos = stackR.peek();
                yPos = stackC.peek();
            }
        }

        while (stackR.peek() != null) {
            solutionR.push(stackR.pop());
            solutionC.push(stackC.pop());
        }

        while (solutionR.peek() != null) {
            System.out.println(solutionR.pop() + ", " + solutionC.pop());
        }
    }
}