import java.util.Arrays;

public class Main {
    static final int N = 9;

    public static void main(String[] args) {

//        String sudo = "100026039008700601000000200400900516000000000796004008009000000301002900640180003";

//        int[][] testgrid =   {{3,0,6,5,0,8,4,0,0},
//                {5,2,0,0,0,0,0,0,0},
//                {0,8,7,0,0,0,0,3,1},
//                {0,0,3,0,1,0,0,8,0},
//                {9,0,0,8,6,3,0,0,5},
//                {0,5,0,0,9,0,6,0,0},
//                {1,3,0,0,0,0,2,5,0},
//                {0,0,0,0,0,0,0,7,4},
//                {0,0,5,2,0,6,3,0,0}};

        int[][] newgrid = {{1,0,0,0,2,6,0,3,9},
                {0,0,8,7,0,0,6,0,1},
                {0,0,0,0,0,0,2,0,0},
                {4,0,0,9,0,0,5,1,6},
                {0,0,0,0,0,0,0,0,0},
                {7,9,6,0,0,4,0,0,8},
                {0,0,9,0,0,0,0,0,0},
                {3,0,1,0,0,2,9,0,0},
                {6,4,0,1,8,0,0,0,3}};

        System.out.println();
        System.out.println("Before");
        printGame(newgrid);

        solvePuzzle(newgrid);

        System.out.println();
        System.out.println("After");
        printGame(newgrid);
    }

    public static boolean solvePuzzle (int[][] grid)
    {
        int row = 0;
        int column = 0;
        boolean puzzleSolved = false;

        findLocation:
        if (!puzzleSolved){
            for(row = 0; row < N; row++){
                for (column = 0; column < N; column ++){
                    if (grid[row][column] == 0) {
                        puzzleSolved = false;
                        break findLocation;
                    }
                }
            }
            puzzleSolved = true;
        }

        if (puzzleSolved){
            return true;
        }

        for (int number=1; number <=N; number ++)
        {
            if (isSafe (grid, number, row, column))
            {
                grid[row][column] = number;

                if(solvePuzzle(grid)){
                    return true;
                }
            }
        }
        grid[row][column] = 0;
        return false;
    }

    public static boolean isSafe (int[][] grid, int number, int row, int column)
    {
        return !usedInRow(grid,number,row) &&
                !usedInColumn(grid,number,column) &&
                !usedInBox(grid,row - row%3,column - column%3,number);
    }

    public static boolean usedInRow (int[][] grid, int number, int row)
    {
        for (int column = 0; column < N; column++){
            if(grid[row][column] == number){
                return true;
            }
        }
        return false;
    }

    public static boolean usedInColumn (int[][] grid, int number,int column)
    {
        for (int row = 0; row < N; row++){
            if (grid[row][column] == number){
                return true;
            }
        }
        return false;
    }

    public static boolean usedInBox (int[][] grid,int boxStartRow, int boxStartColumn, int number)
    {
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                if (grid[row+boxStartRow][column+boxStartColumn] == number){
                    return true;
                }
            }
        }
        return false;
    }

    static void printGame (int[][] grid)
    {
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column ++){
                System.out.print(grid[row][column]);
            }

            for (int column = 3; column < 6; column ++){
                System.out.print(grid[row][column]);
            }

            for (int column = 6; column < 9; column ++){
                System.out.print(grid[row][column]);
            }
            System.out.println();
        }

        for (int row = 3; row < 6; row++)
        {
            for (int column = 0; column < 3; column ++){
                System.out.print(grid[row][column]);
            }

            for (int column = 3; column < 6; column ++){
                System.out.print(grid[row][column]);
            }

            for (int column = 6; column < 9; column ++){
                System.out.print(grid[row][column]);
            }
            System.out.println();
        }

        for (int row = 6; row < 9; row++)
        {
            for (int column = 0; column < 3; column ++){
                System.out.print(grid[row][column]);
            }

            for (int column = 3; column < 6; column ++){
                System.out.print(grid[row][column]);
            }

            for (int column = 6; column < 9; column ++){
                System.out.print(grid[row][column]);
            }
            System.out.println();
        }
    }
}
