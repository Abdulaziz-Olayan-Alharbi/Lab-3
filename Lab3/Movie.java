package Lab3;

import java.util.ArrayList;

public class Movie extends Media{
    private int duration;
    public Movie(String title, String auteur, String ISBN,double price , int duration) {
        super(title, auteur, ISBN, price);
        this.duration = duration;

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void watch (Users user){
        user.addToPurchaseMediaList(this);
    }

    public ArrayList<Movie> recommendSimilarMovies (ArrayList<Movie> moviesCatalog){
        ArrayList<Movie> similarMovies = new ArrayList<>();
        for (Movie movie : moviesCatalog) {
            if (movie.getAuteur().equals(this.getAuteur())){
                similarMovies.add(movie);
            }
        }
        return similarMovies;
    }

    public String getMediaType(){
        if (this.getDuration()<120){
            return "Movie";
        }else {
            return "Long Movie";
        }
    }

    public String toString(){
        return super.toString() + " , Duration: " + duration;
    }
}
