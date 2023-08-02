public class Book {
    private String title;
    private String author;
    private double price;
    private long ISBN;
    private String genre;
    private int year;

    public Book(){

    }
    public Book(String title, String author, double price, long ISBN, String genre, int year){
        this.title = title;
        this.author = author;
        this.price = price;
        this.ISBN = ISBN;
        this.year = year;

    }
    public Book(Book book){
        this.title = book.title;
        this.author = book.author;
        this.price = book.price;
        this.ISBN = book.ISBN;
        this.year = book.year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
