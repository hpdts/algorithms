package java8;

import java.util.*;
import static java.lang.Math.*;
import java.util.stream.*;

public class Java8 {

	static class Book{
	    String name;
	    int id;
	 	String description;
	 	public Book(int id, String name, String description){
	 		this.id = id;
	 		this.name = name;
	 		this.description = description;
	 	}
	}

	public List<String> getBookNames(List<Book> books){
		List<String> names = books.stream().map(book -> book.name).collect(Collectors.toList());
		return names;
	}
}