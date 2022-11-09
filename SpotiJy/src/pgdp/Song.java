package pgdp;

import java.util.Objects;

public class Song {
    private String title;
    private int releaseYear;
    private int duration = 60;
    private int likes = 0;

    public Song(String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }

    public Song(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Song(String title, int releaseYear, int duration) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public int getDuration() {
        return duration;
    }
    public int getLikes() {
        return likes;
    }
    public boolean changeDuration(int duration){
        if (duration < 0 || duration > 720) {
            return false;
        }
        this.duration = duration;
        return true;
    }
    public void like(){
        this.likes++;
    }
    public void unlike(){
        this.likes--;
    }
    @Override
    public String toString(){
        return "Title:" + title + ",Duration:"
                + (double)duration / 60 + " minutes,Release Year:"
                + releaseYear + ",likes:" + likes;
    }
    public boolean isEqual(Song other) {
        return this.title.equals(other.title) && this.releaseYear == other.releaseYear &&
                this.duration == other.duration;
    }

}
