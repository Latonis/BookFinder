public class Book {
    double rating;
    String imgUrl;
    String title;
    String author;
    public Book(double rating, String title, String author, String url) {
        this.rating = rating;
        this.title = title;
        this.author = author;
        this.imgUrl = url;
    }

    public double getRating() {
        return rating;
    }

    public String getAuthor() {
        return author;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }
}
