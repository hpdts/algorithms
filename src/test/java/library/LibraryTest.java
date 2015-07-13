package library;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;
import org.junit.*;

public class LibraryTest {
    private Library library;

	@Before
    public void setUp() {
        Book bookNonFiction = new Book(Genre.NON_FICTION, "Ghettoside: A True Story of Murder in America", "Jill Leovy", 0);
        Book bookNonFiction2 = new Book(Genre.NON_FICTION, "Girl in a Band", "Kim Gordon", 0);
        Book bookNonFiction3 = new Book(Genre.NON_FICTION, "Irritable Hearts: A PTSD Love Story", "Mac McClelland", 0);

        Book bookGeneralFiction = new Book(Genre.GENERAL_FICTION, "I Was Here", "Gayle Forman", 0);
        Book bookGeneralFiction2 = new Book(Genre.GENERAL_FICTION, "Stargirl", "Jerry Spinelli", 0);

        Book bookScienceFiction = new Book(Genre.SCIENCE_FICTION, "Dune", "Frank Herbert", 0);
        Book bookScienceFiction2 = new Book(Genre.SCIENCE_FICTION, "Ender's Game", "Orson Scott Card", 0);

        Book bookWestern = new Book(Genre.WESTERN, "True Grit", "Charles Portis", 0);
        Book bookWestern2 = new Book(Genre.WESTERN, "Lonesome Dove", "Larry McMurtry", 0);
        Book bookWestern3 = new Book(Genre.WESTERN, "All the Pretty Horses", "Cormac McCarthy", 0);
        Book bookWestern4 = new Book(Genre.WESTERN, "Hondo", "Louis L'Amour", 0);


        List<Book> books = new ArrayList<Book>();
        books.add(bookNonFiction);
        books.add(bookNonFiction2);
        books.add(bookNonFiction3);

        books.add(bookGeneralFiction);
        books.add(bookGeneralFiction2);

        books.add(bookScienceFiction);
        books.add(bookScienceFiction2);

        books.add(bookWestern);
        books.add(bookWestern2);
        books.add(bookWestern3);
        books.add(bookWestern4);

        library = new AmazonLibrary(books);
    }

    @Test
    public void testCheckOutBook() throws Library.OutOfBooksException{
        
        Book book = library.checkOutBook(Genre.NON_FICTION);

        assertThat(book.getGenre(), is(Genre.NON_FICTION));
        assertThat(book.getTitle(), is("Ghettoside: A True Story of Murder in America"));
    }

    @Test(expected = Library.OutOfBooksException.class)
    public void shouldGetOutOfBooksException() throws Library.OutOfBooksException{
        
        Book book = library.checkOutBook(Genre.GENERAL_FICTION);

        assertThat(book.getGenre(), is(Genre.GENERAL_FICTION));
        assertThat(book.getTitle(), is("I Was Here"));

        book = library.checkOutBook(Genre.GENERAL_FICTION);

        assertThat(book.getGenre(), is(Genre.GENERAL_FICTION));
        assertThat(book.getTitle(), is("Stargirl"));

        book = library.checkOutBook(Genre.GENERAL_FICTION);
    }

    
} 
