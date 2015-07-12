package library;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;

public class LibraryTest {
    private Library library = new AmazonLibrary();

    @Test
    public void testCheckOutBook() {
        
        Book book = library.checkOutBook(Genre.NON_FICTION);

        assertThat(book.getGenre(), is(Genre.NON_FICTION));
        assertThat(book.getTitle(), is("Ali"));
    }

    
} 
