package java8;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;
import org.junit.*;
import static java8.Java8.*;


public class Java8Test {
    private Java8 java8 = new Java8();

    @Test
	public void filteringNames(){
		Book book = new Book(1, "Lord of the rings", "tolkien");
		Book book2 = new Book(2, "The Shinning", "Redrum");
		Book book3 = new Book(3, "Michael Jackson", "Biography");
		List<Book> books = new ArrayList<>();
		books.add(book);
		books.add(book2);
		books.add(book3);

		List<String> names = java8.getBookNames(books);
		System.out.println("names: " + names);
		assertThat(names.size(), is(3));
	}
}