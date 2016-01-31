package anagrams;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;

public class Anagrams {

    public Map<String, List<String>> getAnagrams(List<String> words) {
        //Input {star, arts, bike, piso, sopi} -> Output {{start, arts},{bike}, {copi, pico} }

        Map<String, List<String>> unique = words.stream().collect(groupingBy(w -> {
            char[] c = w.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }));

        return unique;

    }
}
