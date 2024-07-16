package Lab3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create objects

        Store store = new Store();
        Users user_01 = new Users("AZ", "az@gmail.com");
        Users user_02 = new Users("Sam", "sam@gmail.com");
        Users user_03 = new Users("Ali", "Ali@gmail.com");
        Novel novel_01 = new Novel("The fire", "Abdulaziz", "01", 30, 5, "thriller");
        Novel novel_02 = new Novel("The blood", "Abdulaziz", "02", 10, 3, "thriller");
        Novel novel_03 = new Novel("The dragons", "Muhammed", "03", 35, 10, "fantasy");
        AcademicBook academicBook_01 = new AcademicBook("Java", "Majd", "04", 40, 3, "CS");
        AcademicBook academicBook_02 = new AcademicBook("Physics", "Tesla", "05", 55, 18, "Science");
        AcademicBook academicBook_03 = new AcademicBook("Chemistry", "Tesla", "06", 33, 1, "Science");
        Movie movie_01 = new Movie("Inception", "Nolan", "07", 100, 160);
        Movie movie_02 = new Movie("Oppenheimer", "Nolan", "08", 150, 210);
        Movie movie_03 = new Movie("A quite place", "Sam", "09", 85, 100);
        Music music_01 = new Music("Houdini", "Eminem", "10", 25, "Eminem");
        Music music_02 = new Music("Mockingbird", "Eminem", "11", 5, "Eminem");
        Music music_03 = new Music("Alamaken", "Muhammed", "12", 33, "Muhammed");


        //add medias to store
        ArrayList<Media> store_list = new ArrayList<Media>();
        store_list.add(novel_01);
        store_list.add(novel_02);
        store_list.add(novel_03);
        store_list.add(academicBook_01);
        store_list.add(academicBook_02);
        store_list.add(academicBook_03);
        store_list.add(movie_01);
        store_list.add(movie_02);
        store_list.add(movie_03);
        store_list.add(music_01);
        store_list.add(music_02);
        store_list.add(music_03);

        store.setMedias(store_list);

        for (Media media : store.displayMedia()) {
            System.out.println(media.toString());
        }


        //add users to store
        ArrayList<Users> store_users = new ArrayList<Users>();
        store_users.add(user_01);
        store_users.add(user_02);
        store_users.add(user_03);

        store.setUsers(store_users);

        for (Users user : store.displayUsers()) {
            System.out.println(user.getUsername());
        }

        //add items to shopping cart
        user_01.addToShoppingCart(novel_01);
        user_02.addToShoppingCart(novel_02);
        user_03.addToShoppingCart(novel_03);
        user_01.addToShoppingCart(academicBook_01);
        user_02.addToShoppingCart(academicBook_02);
        user_03.addToShoppingCart(academicBook_03);
        user_01.addToShoppingCart(movie_01);
        user_02.addToShoppingCart(movie_02);
        user_03.addToShoppingCart(movie_03);
        user_01.addToShoppingCart(music_01);
        user_02.addToShoppingCart(music_02);
        user_03.addToShoppingCart(music_03);
        for (Media media : user_01.getShoppingCart()) {
            System.out.println(media.toString() +" , "+ media.getMediaType());
        }
        System.out.println("*********************************");

        //remove items from shopping cart
        user_01.removeFromShoppingCart(novel_01);
        for (Media media : user_01.getShoppingCart()) {
            System.out.println(media.toString() +" , "+ media.getMediaType());
        }
        System.out.println("*********************************");

        //complete purchases
        for (Media media : user_01.getPurchaseMediaList()) {
            System.out.println(media.toString() +" , "+ media.getMediaType());
        }
        user_01.checkout();
        for (Media media : user_01.getPurchaseMediaList()) {
            System.out.println(media.toString() +" , "+ media.getMediaType());
        }

        System.out.println("********************************");

        // reviews
        novel_01.addReview(new Review("AZ",4.5,"good novel"));
        novel_01.addReview(new Review("AZ",5,"great novel"));
        academicBook_02.addReview(new Review("sam",5,"great book"));
        System.out.println(novel_01.getAverageRating());
        System.out.println(novel_01.getMediaType());
        System.out.println("********************************");

        //different scenarios

        // 1 recommend movies
        ArrayList<Movie> moviesCatalog= new ArrayList<Movie>();
        moviesCatalog.add(movie_01);
        moviesCatalog.add(movie_02);
        moviesCatalog.add(movie_03);
        for (Movie movie : movie_01.recommendSimilarMovies(moviesCatalog)){
            System.out.println(movie.toString());
        }
        System.out.println("********************************");

        //2 similar music
        ArrayList<Music> musics = new ArrayList<Music>();
        musics.add(music_01);
        musics.add(music_02);
        musics.add(music_03);
        for (Music music : music_01.generatePlaylist(musics)){
            System.out.println(music.toString());
        }
        System.out.println("********************************");

        //3 search book
        System.out.println(store.searchBook("Java"));
        System.out.println("********************************");

        //4 is bestseller?
        System.out.println(novel_01.isBestSeller());
        System.out.println(novel_02.isBestSeller());
        System.out.println("********************************");

        //5 restock
        System.out.println("before restock: "+ novel_01.getStock());
        novel_01.restock(15);
        System.out.println("********************************");

        //6 override get media type
        for (Media media : store.displayMedia()){
            System.out.println(media.getMediaType());
        }











    }






}
