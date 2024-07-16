package Lab3;

import java.util.ArrayList;

public class Store {
    private ArrayList<Users> users;
    private ArrayList<Media> medias;
    public Store() {
        users = new ArrayList<Users>();
        medias = new ArrayList<Media>();
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    public ArrayList<Media> getMedias() {
        return medias;
    }

    public void setMedias(ArrayList<Media> medias) {
        this.medias = medias;
    }

    public void addUser(Users user) {
        users.add(user);
    }

    public ArrayList<Users> displayUsers() {
        return this.users;
    }

    public void addMedia(Media media) {
        medias.add(media);
    }

    public ArrayList<Media> displayMedia() {
        return this.medias;
    }

   public Book searchBook(String title){
        for(Media media : this.displayMedia()){
            if (media.getTitle().equals(title)){
                return (Book) media;
            }
        }
        return null;
   }

}
