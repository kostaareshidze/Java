package pgdp;

import java.util.Arrays;

public class SpotiJy {
    private Artist[] artists = new Artist[100];
    public Artist[] getArtists() {
        return getArr();
    }

    public boolean isInArr(Artist artist) {
        for (int i = 0; i < this.artists.length; i++) {
            if (this.artists[i] != null) {
                if (this.artists[i].isEqual(artist)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addArtists(Artist[] artists) {
        if (this.artists[0] == null) {
            this.artists[0] = artists[0];
        }
        for (int i = 0; i < this.artists.length; i++) {
            for (int j = 0; j < artists.length; j++) {
                if (!isInArr(artists[j])) {
                    this.artists[i + 1] = artists[j];
                }
            }
        }
    }

    public Artist[] getArr() {
        int counter = 0;
        for (int i = 0; i < this.artists.length; i++) {
            if (this.artists[i] != null) {
                counter++;
            }
        }
        Artist[] artists = new Artist[counter];
        for (int i = 0; i < artists.length; i++) {
            artists[i] = this.artists[i];
        }
        return artists;
    }
    public String[] getTopTrendingArtist(){
        Artist mostFamous = getArtists()[0];
        for (int i = 0; i < getArtists().length; i++) {
            if (getArtists()[i].totalLikes() > mostFamous.totalLikes()){
                mostFamous = getArtists()[i];
            }
        }
        return new String[]{mostFamous.getFirstName(), mostFamous.getLastName()};
    }
    public Album getTopTrendingAlbum(){
        Album mostliked = artists[0].getAlbums()[0];
        int likes = 0;
        for (int i = 0; i <getArtists().length ; i++) {
            for (int j = 0; j < getArtists()[i].getAlbums().length; j++) {
                if (mostlikedalbum(getArtists()[i].getAlbums()[j]) > likes ){
                    likes = mostlikedalbum(getArtists()[i].getAlbums()[j]);
                    mostliked = getArtists()[i].getAlbums()[j];
                }
            }
        }
        return mostliked;
    }
    public int mostlikedalbum(Album album){
        int sum = 0;
        for (int i = 0; i < album.getSongs().length; i++) {
                sum += album.getSongs()[i].getLikes();
            }
        return sum;
    }
    public Song getTopTrendingSong(){
        Song topSong = getArtists()[0].mostLikedSong();
        for (int i = 0; i < getArtists().length; i++) {
            if (getArtists()[i].mostLikedSong().getLikes() > topSong.getLikes()){
                topSong = getArtists()[i].mostLikedSong();
            }
        }
        return topSong;
    }
}