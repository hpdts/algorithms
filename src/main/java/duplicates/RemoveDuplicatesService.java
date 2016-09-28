package duplicates;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesService {


    // write a method that returns a list of duplicates in a list of integers.
    // input  -> list
    // output -> list of duplicate number
    public List<Integer> execute(List<Integer> numbers) {

        Set<Integer> lookup = new HashSet<Integer>();
        List<Integer> duplicates = new ArrayList<Integer>();

        for(Integer number : numbers){  //O(n)
            if(lookup.contains(number)) //O(1)
            {
                duplicates.add(number);
            }else{
                lookup.add(number);
            }
        }

        return duplicates;
    }
}
