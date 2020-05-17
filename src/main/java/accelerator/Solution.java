package accelerator;

import java.util.*;

/*




You are a developer for a university. Your current project is to 
develop a system for students to find courses they share with friends. 
The university has a system for querying courses students are enrolled 
, returned as a list of (ID, course) pairs.

Write a function that takes in a list of 
(student ID number, course name) 
pairs and returns, for every pair of students, 
a list of all courses they share.

Sample Input:

student_course_pairs_1 = [
  ["58", "Linear Algebra"],
  ["94", "Art History"],
  ["94", "Operating Systems"],
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
  ["58", "Software Design"],
]

//58 LA M E SD
//17 SD LA PS

//sets containsALL
Sample Output (pseudocode, in any order):

find_pairs(student_course_pairs_1) =>
{
  [58, 17]: ["Software Design", "Linear Algebra"]
  [58, 94]: ["Economics"]
  [58, 25]: ["Economics"]
  [94, 25]: ["Economics"]
  [17, 94]: []
  [17, 25]: []
}

Additional test cases:

Sample Input:

student_course_pairs_2 = [
  ["42", "Software Design"],
  ["0", "Advanced Mechanics"],
  ["9", "Art History"],
]

Sample output:

find_pairs(student_course_pairs_2) =>
{
  [0, 42]: []
  [0, 9]: []
  [9, 42]: []
}

n: number of pairs in the input
s: number of students
c: number of courses being offered



*/

import java.io.*;
import java.util.*;

public class Solution {
  public HashMap<String, List<String>> sol(String[][] studentCoursePairs1) {
    //every pair
//courses of each 
    
    //42,0 SD,AM
    //42,9, SD AH 
    //0,9, AD AH
    
    HashMap<String, List<String>> student_course = find_assignments(studentCoursePairs1);
    
    List<List<String>> pairs  = findPairs(student_course.keySet());
   // List<List<String>> pairs2  = findPairsRecursive(student_course.keySet());
    System.out.println("pairs1: " + pairs);
    //System.out.println("pairs2: " + pairs2);
    HashMap<String, List<String>> pairsCourses = new HashMap<>();
    for(List<String> pair : pairs){
      System.out.println(pair.toString());
      String student1 = pair.get(0);
      String student2 = pair.get(1);
      List<String> courses1 = new ArrayList<>(student_course.get(student1));
      List<String> courses2 = new ArrayList<>(student_course.get(student2));
      System.out.println("courses1: " + courses1.toString());
      System.out.println("courses2: " + courses2.toString());

      courses2.retainAll(courses1);
      System.out.println("courses retain: " + courses2.toString());
      pairsCourses.put(student1 + ", " + student2, courses2);
    }
    System.out.println("pairsCourses: " + pairsCourses.toString());
    return pairsCourses;
  }
  
  public HashMap<String, List<String>> find_assignments( String[][] student_course_pairs_1){
      HashMap<String, List<String>> student_course = new HashMap<>();
      
      for(String[] assignment : student_course_pairs_1){
        String studentId = assignment[0];
        String course = assignment[1];
        if(student_course.containsKey(studentId)){
          List<String> courses = student_course.get(studentId);
          courses.add(course);
          student_course.put(studentId, courses);
        }else{
          student_course.put(studentId, new ArrayList<>(Arrays.asList(course)));
        }
      }
      
     System.out.println("student_course: " + student_course.toString());

      return student_course;      
    }
  
  public List<List<String>> findPairs(Set<String> students){
    //System.out.println("students: " + students.toString());
    String studentsIds = students.toString();
    String nobrackStu = studentsIds.substring(1,studentsIds.length()-1);
    List<List<String>> out = new ArrayList<>();
    String[] studentsId = nobrackStu.split(",");
      for(int i =0; i< studentsId.length;i++){
          String stu = studentsId[i];
         for(int j = i+1; j<studentsId.length;j++){
           String stu2 = studentsId[j];
           List<String> pair = new ArrayList<>();
           pair.add(stu.trim());
           pair.add(stu2.trim());
           out.add(pair);
         }
      }  
    return out;
  }
   

   public List<List<String>> findPairsRecursive(Set<String> students){
    //System.out.println("students: " + students.toString());
    String studentsIds = students.toString();
    String nobrackStu = studentsIds.substring(1,studentsIds.length()-1);
    List<List<String>> out = new ArrayList<>();
    helper(nobrackStu, out, new ArrayList<String>(), "");
    return out;
  }

  public static void helper(String studentsIds, List<List<String>> out, List<String> pairs, String studentID){
    System.out.println("studentsIds: " + studentsIds);
    System.out.println("studentID: " + studentID);
    System.out.println("pairs: " + pairs);
    if(pairs.size() == 2){
      out.add(new ArrayList<>(pairs));
      pairs.clear();
      return;
    }
   /* if(!studentID.equals("")){
      pairs.add(studentID);
    }*/
   for(String studentIDOne : studentsIds.split(",")){
      int indexComma = studentsIds.indexOf(",");
      String studentsId = studentsIds.substring(indexComma+1);
      pairs.add(studentID);
      helper(studentsId.trim(), out, pairs, studentIDOne);
    }
  
  } 

 /* public int read(char[] buf, int n) {
    char[] buffer = new char[4];
    int offset = 0;
    int charactersInBuffer = 0; 
    int totalCharactersRead = 0;
    boolean eof = false;
    while (!eof && totalCharactersRead < n) {
      if (charactersInBuffer == 0) {
        charactersInBuffer = read4(buffer);
        eof = charactersInBuffer < 4;
      }
      int numCharactersUsed = Math.min(charactersInBuffer, n - totalCharactersRead);
      for (int i = 0; i < numCharactersUsed; i++) {
        buf[totalCharactersRead + i] = buffer[offset + i];
      }
      totalCharactersRead += numCharactersUsed;
      charactersInBuffer -= numCharactersUsed;
      offset = (offset + numCharactersUsed) % 4;
    }
    return totalCharactersRead;
  }*/
  
}
