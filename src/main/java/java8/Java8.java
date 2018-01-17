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

	 	public String toString(){
	 		return "id: " + id + ", name: " + name + ", description: " + description;
	 	}
	}

	static class Point{
		double x;
		double y;
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}

		public boolean equals(Object p) {
		    System.out.println("Testing equality.");
		    if(p instanceof Point){
		    	Point point = (Point) p;
		    	return this.x == point.x && this.y == point.y;
		    }else{
		    	return false;
		    }
		}

		public int hashCode(){
			System.out.println("hashing");
			return super.hashCode();
		}
	}

	public List<String> getBookNames(List<Book> books){
		List<String> names = books.stream().map(book -> book.name).collect(Collectors.toList());
		return names;
	}
}