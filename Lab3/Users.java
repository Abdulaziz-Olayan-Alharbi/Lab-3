package Lab3;

import java.util.ArrayList;

public class Users {
    private String username;
    private String email;
    private ArrayList<Media> purchaseMediaList;
    private ArrayList<Media> shoppingCart;

    public Users(String username, String email) {
        this.username = username;
        this.email = email;
        purchaseMediaList = new ArrayList<Media>();
        shoppingCart = new ArrayList<Media>();

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Media> getPurchaseMediaList() {
        return purchaseMediaList;
    }

    public void setPurchaseMediaList(ArrayList<Media> purchaseMediaList) {
        this.purchaseMediaList = purchaseMediaList;
    }

    public ArrayList<Media> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Media> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addToShoppingCart(Media media) {
        shoppingCart.add(media);
    }

    public void addToPurchaseMediaList(Media media) {
        purchaseMediaList.add(media);
    }

    public void removeFromShoppingCart(Media media) {
        shoppingCart.remove(media);
    }

    public void checkout(){
        for (Media media : purchaseMediaList) {
            if (media.getMediaType().equals("Book")|| media.getMediaType().equals("Bestselling Book")){
                ((Book) media).setStock(((Book) media).getStock()-1);
            }
        }
        purchaseMediaList.addAll(shoppingCart);
        shoppingCart.clear();
    }


}
