package pgdp;

public class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private Album[] albums;
    private Song[] singles;

    public Artist(String firstName, String lastName, int birthYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.albums = albums;
        this.singles = singles;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public Song[] getSingles() {
        return singles;
    }
    public Song mostLikedSong(){
        Song mostLiked = singles[0];
        for (int i = 0; i < singles.length; i++) {
            if (singles[i].getLikes() > mostLiked.getLikes()){
                mostLiked = singles[i];
            }
        }
        for (int i = 0; i < albums.length; i++) {
            for (int j = 0; j < albums[i].getSongs().length; j++) {
                if (albums[i].getSongs()[j].getLikes() > mostLiked.getLikes()){
                     mostLiked = albums[i].getSongs()[j];
                }
            }
        }
        return mostLiked;
    }
    public Song leastLikedSong(){
        Song leastLiked = singles[0];
        for (int i = 0; i < singles.length; i++) {
            if (singles[i].getLikes() < leastLiked.getLikes()){
                leastLiked = singles[i];
            }
        }
        for (int i = 0; i < albums.length; i++) {
            for (int j = 0; j < albums[i].getSongs().length; j++) {
                if (albums[i].getSongs()[j].getLikes() < leastLiked.getLikes()){
                    leastLiked = albums[i].getSongs()[j];
                }
            }
        }
        return leastLiked;
    }
    public int totalLikes(){
        int sumOfSingles = 0;
        int sumOfAlbumSongs = 0;
        for (int i = 0; i < singles.length; i++) {
            sumOfSingles += singles[i].getLikes();
        }
        for (int i = 0; i < albums.length; i++) {
            for (int j = 0; j < albums[i].getSongs().length; j++) {
                sumOfAlbumSongs += albums[i].getSongs()[j].getLikes();
            }
        }
        int totalLikes = sumOfAlbumSongs + sumOfSingles;
        return totalLikes;
    }
    public  boolean isEqual(Artist other){
        return this.firstName.equals(other.firstName) &&
                this.lastName.equals(other.lastName) && this.birthYear == other.birthYear;
    }
    @Override
    public String toString()
    {
        return "Name:" + firstName + " " + lastName + ",Birth year:"
                + birthYear + ",Total likes:" + totalLikes();
    }
}
