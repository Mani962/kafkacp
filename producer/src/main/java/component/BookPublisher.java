package component;

import entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookPublisher {

    private long nextBookId;

    public BookPublisher() {
        this.nextBookId = 1001L;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(createFantasyBook());
        books.add(createFantasyBook());
        books.add(createFantasyBook());
        books.add(createFantasyBook());
        books.add(createFantasyBook());
        books.add(createHorrorBook());
        books.add(createHorrorBook());
        books.add(createHorrorBook());
        books.add(createHorrorBook());
        books.add(createRomanceBook());
        books.add(createRomanceBook());
        books.add(createRomanceBook());
        books.add(createRomanceBook());
        books.add(createRomanceBook());
        books.add(createThrillerBook());
        books.add(createThrillerBook());
        books.add(createThrillerBook());
        books.add(createThrillerBook());
        books.add(createThrillerBook());

        return books;
    }

    private Book createThrillerBook() {
        return createBook("", Book.Genre.thriller);
    }

    private Book createRomanceBook() {
        return createBook("", Book.Genre.romance);
    }

    private Book createHorrorBook() {
        return createBook("", Book.Genre.horror);
    }

    private Book createFantasyBook() {
        return createBook("", Book.Genre.fantasy);
    }

    private Book createBook(String title, Book.Genre genre) {
        Book book = new Book();
        book.setBookId(nextBookId++);
        if (title.equals("")) {
            title = "#" + Long.toString(book.getBookId);
        }
        book.setTitle(title);
        book.setGenre(genre);
        return book;
    }
}
