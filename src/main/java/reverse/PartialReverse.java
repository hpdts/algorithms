package reverse;

import java.util.*;

public class PartialReverse{

	public void execute(Integer[] numbers, int from , int to){
        Collections.reverse(Arrays.asList(numbers).subList(from, to + 1));
    }

}