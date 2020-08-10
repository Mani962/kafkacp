package entity;

public class Book {

    public long getBookId;

    public Book() {

    }

    public enum Genre{
        fantasy,horror,romance,thriller
    }

    private long bookId;
    private String title;
    private Genre genre;

    public Book(long getBookId, long bookId, String title, Genre genre) {
        this.getBookId = getBookId;
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
    }

    public long getGetBookId() {
        return getBookId;
    }

    public Book setGetBookId(long getBookId) {
        this.getBookId = getBookId;
        return this;
    }

    public long getBookId() {
        return bookId;
    }

    public Book setBookId(long bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }
}