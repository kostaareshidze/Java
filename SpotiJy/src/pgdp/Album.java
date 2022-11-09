package pgdp;

import java.util.Arrays;

public class Album {
    private String title;
    private int releaseYear;
    private Song[] songs = new Song[100];

    public Album(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Song[] getSongs() {
        return getArr();
    }

    public boolean isInArr(Song song) {
        for (int i = 0; i < this.songs.length; i++) {
            if (this.songs[i] != null) {
                if (this.songs[i].isEqual(song)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int addSongs(Song[] songs) {
        int counter = getSongs().length;
        if (this.songs[0] == null) {
            this.songs[0] = songs[0];
            counter++;
        }
        for (int i = 0; i < this.songs.length; i++) {
            for (int j = 0; j < songs.length; j++) {
                if (!isInArr(songs[j])) {
                    this.songs[i + 1] = songs[j];
                    counter++;
                }
            }
        }
        return counter;
    }

    public Song[] getArr() {
        int counter = 0;
        for (int i = 0; i < this.songs.length; i++) {
            if (this.songs[i] != null) {
                counter++;
            }
        }
        Song[] song = new Song[counter];
        for (int i = 0; i < song.length; i++) {
            song[i] = this.songs[i];
        }
        return song;

    }

    public Song[] shuffle() {
        Song[] songs = getSongs();
        for (int i = songs.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * i);
            Song song = songs[i];
            songs[i] = songs[j];
            songs[j] = song;
        }
        return songs;
    }

    public Song[] sortByTitle(boolean isAscending) {
        int counter = 0;
        Song[] songs = getSongs();
        for (int i = 0; i < songs.length; i++) {
            for (int j = i + 1; j < songs.length; j++) {
                if (songs[i].getTitle().compareToIgnoreCase(songs[j].getTitle()) > 0) {
                    Song temp = songs[i];
                    songs[i] = songs[j];
                    songs[j] = temp;
                }
            }
        }
        if (!isAscending)
            counter++;
        if (counter == 1) {
            int n = songs.length;
            for (int i = 0; i < n / 2; i++) {
                Song temp = songs[i];
                songs[i] = songs[n - i - 1];
                songs[n - i - 1] = temp;
            }
        }
        return songs;
    }

    public Song[] sortByDuration(boolean isAscending) {
        int counter = 0;
        Song[] songs = getSongs();
        for (int i = 0; i < songs.length; i++) {
            for (int j = i + 1; j < songs.length; j++) {
                if (songs[i].getDuration() > songs[j].getDuration()) {
                    Song tmp = songs[i];
                    songs[i] = songs[j];
                    songs[j] = tmp;
                }
            }
        }
        if (!isAscending)
            counter++;
        if (counter == 1) {
            int n = songs.length;
            for (int i = 0; i < n / 2; i++) {
                Song temp = songs[i];
                songs[i] = songs[n - i - 1];
                songs[n - i - 1] = temp;
            }
        }
        return songs;
    }

    public Song[] sortByReleaseYear(boolean isAscending) {
        int counter = 0;
        Song[] songs = getSongs();
        for (int i = 0; i < songs.length; i++) {
            for (int j = i + 1; j < songs.length; j++) {
                if (songs[i].getReleaseYear() > songs[j].getReleaseYear()) {
                    Song tmp = songs[i];
                    songs[i] = songs[j];
                    songs[j] = tmp;
                }
            }
        }
        if (!isAscending)
            counter++;
        if (counter == 1) {
            int n = songs.length;
            for (int i = 0; i < n / 2; i++) {
                Song temp = songs[i];
                songs[i] = songs[n - i - 1];
                songs[n - i - 1] = temp;
            }
        }
        return songs;
    }

    public Song[] sortByPopularity(boolean isAscending) {
        int counter = 0;
        Song[] songs = getSongs();
        for (int i = 0; i < songs.length; i++) {
            for (int j = i + 1; j < songs.length; j++) {
                if (songs[i].getLikes() > songs[j].getLikes()) {
                    Song tmp = songs[i];
                    songs[i] = songs[j];
                    songs[j] = tmp;
                }
            }
        }
        if (!isAscending)
            counter++;
        if (counter == 1) {
            int n = songs.length;
            for (int i = 0; i < n / 2; i++) {
                Song temp = songs[i];
                songs[i] = songs[n - i - 1];
                songs[n - i - 1] = temp;
            }
        }
        return songs;
    }

    public static String reverse(Song[] songs) {
        int n = songs.length;
        for (int i = 0; i < n / 2; i++) {
            Song temp = songs[i];
            songs[i] = songs[n - i - 1];
            songs[n - i - 1] = temp;
        }
        return Arrays.toString(songs);
    }

    @Override
    public String toString() {
        return "Title:" + title + ",Release Year:"
                + releaseYear + ",songs:{" + Arrays.toString(getArr()) + "}";
    }

}