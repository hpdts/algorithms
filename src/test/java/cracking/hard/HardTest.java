package cracking.hard;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.awt.Point;


public class HardTest {

	 Hard hard = new Hard();

	@Test
    public void addition(){
    	assertThat(hard.add(2,3), is(5));
    }

    @Test
    public void shuffleCards(){
    	int[] cards = new int[]{ 4, 5, 11 ,12};
    	hard.shuffleArrayInteratively(cards);
    	System.out.println("shuffle: " +  Arrays.toString(cards));
    }


    @Test
    public void date(){
        
        assertThat(compareTo("2016/10/12", "2010/01/01"), is("2016/10/12"));
        assertThat(compareTo("2016/10/12", "2016/11/01"), is("2016/11/01"));
        assertThat(compareTo("2016/10/12", "2016/10/12"), is("2016/10/12"));
        assertThat(compareTo("2016/10/12", "2016/10/16"), is("2016/10/16"));
        assertThat(compareTo("2016/10/12", "2018/10/16"), is("2018/10/16"));
        
    }
     //retirn most recent date
    public String compareTo(String date1, String date2){
         String[] date1Segmented = date1.split("/"); 
         String[] date2Segmented = date2.split("/"); 
      
         int yearDate1 = Integer.parseInt(date1Segmented[0]);
         int monthDate1 = Integer.parseInt(date1Segmented[1]);
         int dayDate1 = Integer.parseInt(date1Segmented[2]);
      
         int yearDate2 = Integer.parseInt(date2Segmented[0]);
         int monthDate2 = Integer.parseInt(date2Segmented[1]);
         int dayDate2 = Integer.parseInt(date2Segmented[2]);
                                           
         if(yearDate1 > yearDate2){
            return date1;
         }
         else if(yearDate2 > yearDate1){ 
               return date2;  
         }
             
        if(monthDate1 > monthDate2){
           return date1;
         }else if(monthDate2 > monthDate1){
               return date2;
         }
             
             
         if(dayDate1 > dayDate2){
           return date1;
         }else if(dayDate2 > dayDate1){
              return date2;
         }
         //equal date                                   
         return date2;                                  
      }

      @Test
      public void sumtwoNumbers(){
        int sum = 9;
        int[] numbers = new int[] { 1, 2, 4 , 6, 7, 5, 3};
        Map<Integer, Integer> numbersLookup = new HashMap<>();

        for(int number : numbers){
            if(numbersLookup.containsKey(sum - number)){
                int sum1 = numbersLookup.get(sum - number);
                System.out.println("sum1: " + sum1 + ", sum2: " + number);
                break;
            }else{
                numbersLookup.put(number, number);
            }
    
        }

      }

      @Test
      public void moveIntInArray(){
        int[] numbers = new int[] {2 ,3 ,5 ,6 ,7 ,9, 10 ,23, 45};
        int num1 = 7;
        int num2 = 23;

        int indexNum1 = -1;
        int indexNum2 = -1;
        for(int i = 0; i < numbers.length; i++){
            if(num1 == numbers[i]){
                indexNum1 = i;
            }
            if(num2 == numbers[i]){
                indexNum2 = i;
            }
        }

        int indexToNum1 = 0;
        int indexToNum2 = 1;
        swap(numbers, indexNum1, indexToNum1);
        swap(numbers, indexNum2, indexToNum2);

        System.out.println("Array before: " + Arrays.toString(numbers));

        System.out.println("indexNum1: " + indexNum1 + ", indexNum2: " + indexNum2);
        //do swap
        //go by each and do swap

        System.out.println("Array after: " + Arrays.toString(numbers));

      }

      public void swap(int[] numbers, int indexFrom, int indexTo){
         int temp = numbers[indexFrom];
         numbers[indexFrom] = numbers[indexTo];
         numbers[indexTo] = temp;
      }


   /* @Test
    public void rankTest(){
    	int[] array = new int[]{ 5,6,7,8,9,2,3,1,4,10};
    	hard.rank(array, 0, array.length -1, 10);
    	System.out.println("rank: " +  Arrays.toString(array));
    }*/

    @Test
    public void rotateArray(){
        int[] array = new int[] {1, 2, 3, 4 , 5 };
        int[] arrayRotated = new int[] {4, 5, 1, 2, 3}; 
        hard.rotate(array, 2);
        System.out.println("aray to string: " + Arrays.toString(array));
        assertTrue(Arrays.equals(array, arrayRotated));
        
    }

    @Test
    public void reverseWords(){
        String words = "King kong was defeated by the beauty";
        char[] reversed = hard.reverseWords(words.toCharArray());
        String wordsReversed = new String(reversed);
        System.out.println("string reverse: " + wordsReversed);

        String wordReversed = hard.reverseWord("Kong");
        System.out.println("reversed: " + wordReversed);

        assertTrue(wordReversed.equals("gnoK"));
    }


}