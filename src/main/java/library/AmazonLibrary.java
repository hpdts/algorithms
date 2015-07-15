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
    	if( (rating < 1) || (rating > 100)){
    		throw new IllegalRatingException();
    	}
    	checkedBooks.remove(returnedBook.getTitle());
    	for(Book book : books){
			if( book.getTitle().equals(returnedBook.getTitle() )){
				books.remove(book);
				break;
			}
		}
		books.add(new Book(returnedBook.getGenre(), returnedBook.getTitle(), returnedBook.getAuthor(), rating));
    }

    public Book peekHighestRatedBook(Genre genre) throws OutOfBooksException{
    	int highestRating = 0;
    	Book bookHighestRating = null;
    	for(Book book : books){
			if(book.getGenre().equals(genre) && !checkedBooks.contains(book.getTitle()) && book.getRating() > highestRating){
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

    public List<Book> getBooks(){
    	return books;
    }

    public Set<String> getCheckedBooks(){
    	return checkedBooks;
    }

}