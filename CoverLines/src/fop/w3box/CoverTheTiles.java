package fop.w3box;

public class CoverTheTiles extends MiniJava {

    // Output of open tiles. Don't modify this
    public static void outputTiles(boolean[] tiles) {
        StringBuilder sb = new StringBuilder("Open tiles: 1:");
        sb.append(tiles[0]);
        for (int i = 1; i < tiles.length; i++) {
            sb.append(" ").append(i + 1).append(":").append(tiles[i]);
        }
        write(sb.toString());
    }

    public static void main(String[] args) throws IllegalAccessException {
        boolean[] tiles = {true, true, true, true, true, true, true, true, true, true};
        int counter = 0;
        int sumOfFirstTiles = 0;
        int sumOfSecTiles = 0;
        while (counter != 10) {
            int firstRoll = dice();
            int secondRoll = dice();
            while (true) {
                int arrayCounter = 0;
                write("Player 1 numbers:");
                write(firstRoll);
                write(secondRoll);
                outputTiles(tiles);
                write("Which tiles to cover by player 1? (0 for no valid combination)");
                int tile1 = readInt("Tile 1:");
                int tile2 = readInt("Tile 2:");
                if (tile1 == 0 || tile2 == 0) {
                    for (int i = 0; i < tiles.length; i++) {
                        if (tiles[i]) {
                            sumOfFirstTiles += i + 1;
                        }
                    }
                    break;
                } else if (!tiles[tile1 - 1] || !tiles[tile2 - 1]) {
                } else if (tile1 + tile2 == firstRoll + secondRoll) {
                    tiles[tile1 - 1] = false;
                    tiles[tile2 - 1] = false;
                    for (boolean tile : tiles) {
                        if (!tile) {
                            arrayCounter++;
                        }
                        if (arrayCounter == 10) {
                            outputTiles(tiles);
                            write("Player 1 wins!");
                            return;
                        }
                    }
                    break;
                }
            }
            firstRoll = dice();
            secondRoll = dice();
            while (true) {
                int arrayCounter = 0;
                write("Player 2 numbers:");
                write(firstRoll);
                write(secondRoll);
                outputTiles(tiles);
                write("Which tiles to cover by player 2? (0 for no valid combination)");
                int tile1 = readInt("Tile 1:");
                int tile2 = readInt("Tile 2:");
                if (tile1 == 0 && tile2 == 0) {
                    for (int i = 0; i < tiles.length; i++) {
                        if (tiles[i]) {
                            sumOfFirstTiles += i + 1;
                        }
                    }
                    break;
                } else if (!tiles[tile1 - 1] || !tiles[tile2 - 1]) {
                    continue;
                } else if (tile1 + tile2 == firstRoll + secondRoll) {
                    tiles[tile1 - 1] = false;
                    tiles[tile2 - 1] = false;
                    for (boolean tile : tiles) {
                        if (!tile) {
                            arrayCounter++;
                        }
                        if (arrayCounter == 10) {
                            outputTiles(tiles);
                            write("Player 2 wins!");
                            return;
                        }
                    }
                    break;
                }
                break;
            }
            counter++;
            if (counter == 10) {
                if (sumOfFirstTiles < sumOfSecTiles) {
                    write("Player 1 wins!");
                } else if (sumOfSecTiles < sumOfFirstTiles) {
                    write("Player 2 wins!");
                }else {
                    write("draw!");
                }
            }
        }
    }
}
