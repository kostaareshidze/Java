package pgdp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Song rattlestarSong = new Song("Snake Jazz", 1989, 30, 120);
        Song majorSong = new Song("Space Oddity", 1939, 30, 1);
        Song queenSong = new Song("Teo Torriatte", 1977, 120, 78);
        Song darara = new Song("tarara", 1907, 120, 721);
        Song kokoko = new Song("kokoko", 1937, 100, 8);
        Album greenSide = new Album("Green side",1976);
        Album brownSide = new Album("Brown side",1906);
        greenSide.addSongs(new Song[]{rattlestarSong, majorSong});
        brownSide.addSongs(new Song[]{darara,kokoko});
        var justinBieber = new Artist("justin", "bieber", 1980,
                new Album[]{greenSide}, new Song[]{queenSong});
        var kostaAreshidze = new Artist("kosta", "areshidze", 2003, new Album[]{brownSide}
        , new Song[]{darara,kokoko});
        var spotijy = new SpotiJy();
        spotijy.addArtists(new Artist[]{kostaAreshidze, justinBieber});

        System.out.println(spotijy.getTopTrendingAlbum());

    }
}
