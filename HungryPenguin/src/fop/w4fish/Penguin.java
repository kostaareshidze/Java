package fop.w4fish;

import java.util.Arrays;

public class Penguin extends MiniJava {

    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
        String[][] sre = new String[world.length][world[0].length];
        for (int i = 0; i < sre.length; i++) {
            for (int j = 0; j < sre[0].length; j++) {
                if (world[i][j] == 0)
                    sre[i][j] = "L";
                if (world[i][j] == 1)
                    sre[i][j] = "I";
                if (world[i][j] == 2)
                    sre[i][j] = "W";
                if (world[i][j] == 3)
                    sre[i][j] = "S";
                if (world[i][j] == 4)
                    sre[i][j] = "F";
                if (i==pinguRow && j==pinguColumn){
                    sre[i][j] +="(P)\t";
                    if (sre[i].length-1 == j){
                        System.out.print(sre[i][j]);
                    }else {
                        System.out.print(sre[i][j] + "");
                    }
                }else if (sre[i].length-1 == j){
                    System.out.print(sre[i][j]);
                }else {
                    System.out.print(sre[i][j] + "\t");
                }
            }
            System.out.println("");
            }

        }




    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn) {
        int oldPath = 5;
        boolean escape;
        if (pinguRow < 0 || pinguColumn < 0 || pinguRow >= world.length || pinguColumn >= world[0].length)
            return false;
        if (world[pinguRow][pinguColumn] == 3 || world[pinguRow][pinguColumn] == oldPath)
            return false;
        if (world[pinguRow][pinguColumn] == 4)
            return true;
        if (world[pinguRow][pinguColumn] == 0) {
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow + 1, pinguColumn);
            if (escape) return true;
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow, pinguColumn + 1);
            if (escape) return true;
            world[pinguRow][pinguColumn] = oldPath;
            escape =isFishReachable(world, pinguRow - 1, pinguColumn);
            if (escape) return true;
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow, pinguColumn - 1);
            if (escape) return true;
        }if (world[pinguRow][pinguColumn] == 1) {
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow + 1, pinguColumn + 1);
            if (escape) return true;
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow - 1, pinguColumn - 1);
            if (escape) return true;
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow + 1, pinguColumn - 1);
            if (escape) return true;
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow - 1, pinguColumn + 1);
            if (escape) return true;
        }if (world[pinguRow][pinguColumn] == 2) {
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow + 3, pinguColumn + 3);
            if (escape) return true;
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow - 3, pinguColumn - 3);
            if (escape) return true;
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow + 3, pinguColumn - 3);
            if (escape) return true;
            world[pinguRow][pinguColumn] = oldPath;
            escape = isFishReachable(world, pinguRow + 3, pinguColumn - 3);
            return escape;
        }
        return false;
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     *
     * @return An example world
     */
    public static int[][] generateExampleWorldOne() {
        return new int[][]{{2, 3, 3, 1, 3, 3},
                            {3, 0, 1, 3, 3, 3},
                            {3, 3, 3, 3, 3, 1},
                            {3, 3, 3, 0, 1, 3},
                            {3, 3, 3, 3, 3, 3}};
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     *
     * @return An example world
     */
    public static int[][] generateExampleWorldTwo() {
        return new int[][]{{4, 0, 0, 2},
                            {4, 0, 0, 1},
                            {3, 4, 3, 4},
                            {3, 4, 3, 3}};
    }

    /**
     * You may use the main method for testing your program.
     */
    public static void main(String[] args) {
        int pinguRow = 0;
        int pinguColumn = 3;
        int[][] world = generateExampleWorldOne();
        printWorld(world, pinguRow, pinguColumn);
        write("" + isFishReachable(world, pinguRow, pinguColumn));
    }
}
