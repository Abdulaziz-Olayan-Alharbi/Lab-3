package Lab3;

import java.util.ArrayList;

public class Music extends Media {
    private String artist;

    public Music(String title, String auteur, String ISBN,double price , String artist) {
        super(title, auteur, ISBN, price);
        this.artist = artist;

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void listen (Users user){

        user.addToPurchaseMediaList(this);

    }

    public ArrayList<Music> generatePlaylist (ArrayList<Music> musicsCatalog){
        ArrayList<Music> playlist = new ArrayList<Music>();
        for (Music music : musicsCatalog) {
            if (music.getArtist().equals(this.getArtist())) {
                playlist.add(music);
            }
        }
        return playlist;
    }

    public String getMediaType(){
        if (this.getPrice() < 10){
            return "Music";
        } else {
            return "Premium Music";
        }
    }

    public String toString(){
        return super.toString() + " , Artist: " + artist;
    }
}
