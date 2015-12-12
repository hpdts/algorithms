package library;

import java.util.*;

public class AmazonLibrary implements Library {

	private LinkedList<Book> availableBooks = new LinkedList<Book>();
	private LinkedList<Book> takenBooks = new LinkedList<Book>();

	public AmazonLibrary(LinkedList<Book> books) {
        this.availableBooks = books;
    }

	public Book checkOutBook(Genre genre) throws OutOfBooksException{
		Book bookCheckedOut = null;   
		for(Book book : availableBooks){
			if(book.getGenre().equals(genre)){
				takenBooks.push(book);
				bookCheckedOut = book;
				break;
			}
		}
		if(bookCheckedOut == null){
			throw new OutOfBooksException();
		}else{
			availableBooks.remove(bookCheckedOut);
			return bookCheckedOut;
		}
	}
    
    public void checkInBook(Book returnedBook, int rating) throws IllegalRatingException{
    	if( (rating < 1) || (rating > 100)){
    		throw new IllegalRatingException();
    	}
    	
    	for(Book book : takenBooks){
			if(book.getTitle().equals(returnedBook.getTitle())){
				Book newBook = new Book(returnedBook.getGenre(), returnedBook.getTitle(), returnedBook.getAuthor(), rating);
				availableBooks.push(newBook);
				break;
			}
		}
		takenBooks.remove(returnedBook);
    }

    public Book peekHighestRatedBook(Genre genre) throws OutOfBooksException{
    	int highestRating = 0;
    	Book bookHighestRating = null;
    	for(Book book : availableBooks){
			if(!takenBooks.contains(book.getTitle()) && book.getGenre().equals(genre) && book.getRating() > highestRating){
				highestRating = book.getRating();
				bookHighestRating = book;
			}
		}

		if(bookHighestRating == null){
			throw new OutOfBooksException();
		}else{
    		return bookHighestRating;
		}
    }

    public LinkedList<Book> getBooks(){
    	return availableBooks;
    }

    public LinkedList<Book> getCheckedBooks(){
    	return takenBooks;
    }

}