package library;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;
import org.junit.*;

public class AmazonLibraryTest {
    private AmazonLibrary library;

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

    @Test
    public void testCheckInBook() throws Library.OutOfBooksException, Library.IllegalRatingException{
        
        Book book = library.checkOutBook(Genre.NON_FICTION);

        assertThat(book.getGenre(), is(Genre.NON_FICTION));
        assertThat(book.getTitle(), is("Ghettoside: A True Story of Murder in America"));

        library.checkInBook(book, 10);

        assertThat(library.getCheckedBooks().contains(book.getTitle()), is(false));

        boolean isBook = false;
        for(Book bookLibrary : library.getBooks()){
            if(bookLibrary.getTitle().equals(book.getTitle()) && 10 == bookLibrary.getRating()){
                isBook = true;
            }
        }
        assertThat(isBook, is(true));

    }

    @Test(expected = Library.IllegalRatingException.class)
    public void testIllegalRatingExceptionNegativeRating() throws Library.OutOfBooksException, Library.IllegalRatingException{
        
        Book book = library.checkOutBook(Genre.NON_FICTION);

        assertThat(book.getGenre(), is(Genre.NON_FICTION));
        assertThat(book.getTitle(), is("Ghettoside: A True Story of Murder in America"));

        library.checkInBook(book, -2);
    }

    @Test(expected = Library.IllegalRatingException.class)
    public void testIllegalRatingExceptionGreaterThan100Rating() throws Library.OutOfBooksException, Library.IllegalRatingException{
        
        Book book = library.checkOutBook(Genre.NON_FICTION);

        assertThat(book.getGenre(), is(Genre.NON_FICTION));
        assertThat(book.getTitle(), is("Ghettoside: A True Story of Murder in America"));

        library.checkInBook(book, 245);
    }

    @Test(expected = Library.IllegalRatingException.class)
    public void testIllegalRatingException0Rating() throws Library.OutOfBooksException, Library.IllegalRatingException{
        
        Book book = library.checkOutBook(Genre.NON_FICTION);

        assertThat(book.getGenre(), is(Genre.NON_FICTION));
        assertThat(book.getTitle(), is("Ghettoside: A True Story of Murder in America"));

        library.checkInBook(book, 0);
    }

    @Test
    public void testPeekHighestRatedBook() throws Library.OutOfBooksException, Library.IllegalRatingException{
        
        Book book = library.checkOutBook(Genre.NON_FICTION);

        assertThat(book.getGenre(), is(Genre.NON_FICTION));
        assertThat(book.getTitle(), is("Ghettoside: A True Story of Murder in America"));

        Book book2 = library.checkOutBook(Genre.NON_FICTION);

        assertThat(book2.getGenre(), is(Genre.NON_FICTION));
        assertThat(book2.getTitle(), is("Girl in a Band"));

        library.checkInBook(book, 10);
        library.checkInBook(book2, 40);

        Book bookPeeek = library.peekHighestRatedBook(Genre.NON_FICTION);

        assertThat(bookPeeek.getRating(), is(40));

        book = library.checkOutBook(Genre.WESTERN);

        assertThat(book.getGenre(), is(Genre.WESTERN));
        assertThat(book.getTitle(), is("True Grit"));

        book2 = library.checkOutBook(Genre.WESTERN);

        assertThat(book2.getGenre(), is(Genre.WESTERN));
        assertThat(book2.getTitle(), is("Lonesome Dove"));

        library.checkInBook(book, 100);
        library.checkInBook(book2, 20);

        bookPeeek = library.peekHighestRatedBook(Genre.WESTERN);

        assertThat(bookPeeek.getRating(), is(100));

    }

    @Test(expected = Library.OutOfBooksException.class)
    public void testOutOfBooksExceptionFromPeek() throws Library.OutOfBooksException, Library.IllegalRatingException{
        
        Book book = library.checkOutBook(Genre.SCIENCE_FICTION);

        assertThat(book.getGenre(), is(Genre.SCIENCE_FICTION));
        assertThat(book.getTitle(), is("Dune"));

        Book book2 = library.checkOutBook(Genre.SCIENCE_FICTION);

        assertThat(book2.getGenre(), is(Genre.SCIENCE_FICTION));
        assertThat(book2.getTitle(), is("Ender's Game"));

        Book bookPeeek = library.peekHighestRatedBook(Genre.SCIENCE_FICTION);

    }
    
} 
