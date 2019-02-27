package interviewExposed;

import java.util.*;

public class Node<T>{
   private Node<T> next;
   private T data;

   Node(T data){
	this.data = data;
	next = null;
   } 

   public void setNext(Node<T> next){
   		this.next = next;
   }

   public void setData(T data){
   		this.data = data;
   }

   public T data(){
   	 return data;
   }

   public Node<T> next(){
   	return next;
   }

}