package courses;

import java.util.*;
import static java.lang.Math.*;

/* 
   Author: Francisco Hernandez
   Complexity is n log n becuase of the mergesort
	space complexity 3N one more array for the merge sort
	you can use hashmap to get better performance
	I have used 3 pommodoros 75 minutes. 1 hour and 15 minutes.
	1 for trying to implement a hastable
	2 for merge and intersect	

	Solution: https://github.com/hpdts/algorithms/blob/master/src/main/java/courses/Courses.java
*/
public class Courses {

	// sort and binary search approach

	public static class Student implements Comparable<Student>{

		String firstName;
		String lastName;
	 	int age;
	 	String ID;
	 	Student(String firstName, String lastName, int age){
	 		this.firstName = firstName;
	 		this.lastName = lastName;
	 		this.age = age;
	 		this.ID = firstName+lastName+age;
	 	}

	 	public int compareTo(Student student2){
	 		return this.ID.compareTo(student2.ID);
	 	}

	 	public String toString(){
	 		return "ID: " + ID;
	 	} 

	 	public boolean equals(Student student2){
	 		return this.ID.equals(student2.ID);
	 	}
	}

	public int getStudentsInCommon(Student[] courseA, Student[] courseB){

		//n log n
		mergesort(courseA);
		mergesort(courseB);

		
		System.out.println("CourseA:  " + Arrays.toString(courseA));
		System.out.println("CourseB:  " + Arrays.toString(courseB));

		return intersection(courseA, courseB);
	}

	public int intersection(Student[] courseA, Student[] courseB){
		int i = 0;
		int j = 0;
		int found = 0;
		while (i < courseA.length && j < courseB.length){ 
			if (courseA[i].equals(courseB[j])){
				found++;
				i++;
				j++;
			} else if (courseA[i].compareTo(courseB[j]) < 0){
				i++;
			}else{
				j++;
			}
		}

		return found;
	}

	public void mergesort(Student[] array) {
		Student[] helper = new Student[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}
	
	public void mergesort(Student[] array, Student[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle); 
			mergesort(array, helper, middle + 1, high); 
			merge(array, helper, low, middle, high); 
		}
	}
	
	public void merge(Student[] array, Student[] helper, int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft].compareTo(helper[helperRight]) < 0) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { 
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
	
	 	int remaining = middle - helperLeft;
	 	for (int i = 0; i <= remaining; i++) {
	 		array [current + i] = helper[helperLeft + i];
	 	}
	 }





}