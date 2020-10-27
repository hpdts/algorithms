/**
coding solution 1 2 design
log file
start and end time

foo 20 + 5

task start and end
single thread

Format of input
Output:


Input:
foo start 100
foo end 120
bar start 125
bar end 130
foo start 130
foo end 160

Output:
foo 25
bar 5

Input 2:
foo start 100
bar start 110
bar end 115
foo end 120

Input 3:
foo start 100
bar start 110
 fuzz start 111
 fuzz end 113
bar end 115
foo end 120

One more case
method calling another method INPUT pending!!!
extra case

Always an end
out: each task and its exec time average

Analysis
Input:
foo start 100
foo end 120
bar start 125
bar end 130
foo start 130
foo end 160

String split by whitespace
0 1 2
start an end
n log n no sorted
O(1)

class Task{
  int timeSum;
  int count;
}

Map<String, Integer> taskExecTime save start and end
Map<String, Task> taskSums
if task not on the map I will add it
count of each task

foo on the map
   foo,100
   check if map.containsKey(foo) true
   int lastTime = 100
   end - lastTime = 20
   taskSums.put("foo", newTime);

List<Integer> startTimes
//corner case recursion
foo start 100
foo start 105
foo start 100
foo start 105
bar start 110
bar end 115
>foo end 120
foo end 120
foo end 120
foo end 120


taskExecTime foo,<>
             bar, 110

taskSums bar, 5, 1
         foo, 50, 120
         go trough map and get average
         
if start and task on the map

else end
do the diff and put taskSums
I need to get the last timeSum and add and increment the count
get the last on the list
list.get(size-1)
remove from list


taskSums 

fib(n-2) + fib(n-1)

List<String> tasks
for each task

foo start 50
foo start 100
bar start 110
bar end 115

helper(row+1,col)
helper(row-1,col)
helper(row,col+1)
helper(row,col-1)
foo end 120
foo end 125

fib start 10 <---
helper start 15 <-
helper end 20   <-
helper start 20 <-
helper end 25   <-
helper start 25 <-
helper end 40   <-
helper start 50 <-
helper end 60   <-
fib end 70   <---


**/
package accelerator;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.Queue;
import java.util.LinkedList;

class Task {
  public class Method{
    int timeSum;
    int count;
    
    public Method(int timeSum, int count){
      this.timeSum = timeSum;
      this.count = count;
    }
  }
  
  /**
  
  taskExecTime foo,<>
             bar, 110

taskSums bar, 5, 1
         foo, 50, 120
         go trough map and get average
         
if start and task on the map

else end
do the diff and put taskSums
I need to get the last timeSum and add and increment the count
get the last on the list
list.get(size-1)
remove from list

**/
  public void getAverageTimesTasks(List<String> tasks){
    Map<String, List<Integer>> taskExecTime = new HashMap<>();
    Map<String, Method> taskSums = new HashMap<>();
    
    for(String task : tasks){
      String[] taskDetails = task.split(" ");
      String taskName = taskDetails[0];
      String startEnd = taskDetails[1];
      String timeStamp = taskDetails[2];
      int timeStampInt = Integer.parseInt(timeStamp);
      
      if(taskExecTime.containsKey(taskName)){
        List<Integer> prevsTimeStamp = taskExecTime.get(taskName);
        if(startEnd.contains("start")){
          prevsTimeStamp.add(timeStampInt);
        }else{
          int lastTimeStart = prevsTimeStamp.get(prevsTimeStamp.size()-1);
          int diff = timeStampInt - lastTimeStart;
          if(taskSums.containsKey(taskName)){
            Method currTask = taskSums.get(taskName);
            //int lastDiff = task.timeSum;
            //int lastCount = task.count;
            currTask.timeSum+=diff;
            currTask.count++;
            taskSums.put(taskName, currTask);
            prevsTimeStamp.remove(prevsTimeStamp.size()-1);
          }else{
            taskSums.put(taskName, new Method(diff,1));
          }
        }
        
      }else{
        taskExecTime.put(taskName, new ArrayList<>(Arrays.asList(timeStampInt)));
      }
    }
    
    for(Map.Entry<String, Method> entry : taskSums.entrySet()){
      String taskName = entry.getKey();
      Method task = entry.getValue();
      System.out.println("Task: " + taskName + ", Avg: " + (task.timeSum / task.count));    
    }
    
  }
  
}
