package Lab3;

import java.util.ArrayList;

public class Book extends Media{
    private ArrayList<Review> reviews;
    private int stock;

    public Book (String title, String auteur, String ISBN, double price, int stock) {
        super(title, auteur, ISBN, price);
        this.reviews = new ArrayList<Review>();
        this.stock = stock;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public double getAverageRating(){
        double sumRating = 0;
        for (Review review : reviews) {
            sumRating += review.getRating();
        }
        return sumRating / reviews.size();
    }

    public void purchase (Users user){
        if (this.getStock()>0){
            user.addToPurchaseMediaList(this);
            stock--;
        }
    }

    public boolean isBestSeller(){
        if (this.getAverageRating() >= 4.5){
            return true;
        }else {
            return false;
        }
    }

    public void restock (int quantity){
        stock += quantity;
        System.out.println("Stock restocked: " + stock);
    }

    public String getMediaType(){
        if (this.getAverageRating() >= 4.5){
            return "Bestselling Book";
        }else {
            return "Book";
        }
    }

    public String toString(){
        return super.toString() + " , Stock: " + stock;
    }

}
