package library;

import java.util.*;

public class AmazonLibrary implements Library {

	private List<Book> books = new ArrayList<Book>();
	private Set<String> checkedBooks = new HashSet<String>();

	public AmazonLibrary(List<Book> books) {
        this.books = books;
    }

	public Book checkOutBook(Genre genre) throws OutOfBooksException{
		for(Book book : books){
			System.out.println("book.getGenre(): " + book.getGenre() + " = " + genre);
			if(book.getGenre().equals(genre) && !checkedBooks.contains(book.getTitle())){
				checkedBooks.add(book.getTitle());
				return book;
			}

		}
		throw new OutOfBooksException();
	}
    
    public void checkInBook(Book returnedBook, int rating) throws IllegalRatingException{

    }

    public Book peekHighestRatedBook(Genre genre) throws OutOfBooksException{
    	return null;
    }

}