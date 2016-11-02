package cracking.stackqueue;

import java.util.*;
 
 /* Class TowerOfHanoiUsingStacks */
 public class TowerOfHanoiUsingStacks
 {
     public static int N;
     /* Creating Stack array  */
     public static Stack<Integer>[] tower = new Stack[4]; 

     /* Function to push disks into stack */
     public static void toh(int n)
     {
         for (int d = n; d > 0; d--)
             tower[1].push(d);
         display();
         move(n, 1, 2, 3);         
     }
     /* Recursive Function to move disks */
     public static void move(int n, int a, int b, int c)
     {
         if (n > 0)
         {
            System.out.println("n-1: " + (n-1) + "a: " + a + "c: " + c + "b: " + b);
             move(n-1, a, c, b);     
             int d = tower[a].pop();                                             
             tower[c].push(d);
              System.out.println("pop d: " + d + "push tower index" + c);
           
             display(); 
             System.out.println("Second n-1: " + (n-1) + "b: " + b + "a: " + a + "c: " + c);                  
             move(n-1, b, a, c);     
         }         
     }
     /*  Function to display */
     public static void display()
     {
         System.out.println("  A  |  B  |  C");
         System.out.println("---------------");
         for(int i = N - 1; i >= 0; i--)
         {
             String d1 = " ", d2 = " ", d3 = " ";
             try
             {
                 d1 = String.valueOf(tower[1].get(i));
             }
             catch (Exception e){
             }    
             try
             {
                 d2 = String.valueOf(tower[2].get(i));
             }
             catch(Exception e){
             }
             try
             {
                 d3 = String.valueOf(tower[3].get(i));
             }
             catch (Exception e){
             }
             System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
         }
         System.out.println("\n");         
     }
 }