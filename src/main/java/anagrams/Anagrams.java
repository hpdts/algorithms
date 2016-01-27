package anagrams;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

    public Map<String, String> getAnagrams(List<String> words) {
        //Input {star, arts, bike, piso, sopi} -> Output {{start, arts},{bike}, {copi, pico} }

        //List<String> words = Arrays.asList("star", "arts", "bike", "piso", "sopi");
        Map<String, String> anagrams = new HashMap<>();

        words.stream().forEach(word -> {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);


            if (anagrams.containsKey(String.valueOf(charArray))) {
                anagrams.put(String.valueOf(charArray), anagrams.get(String.valueOf(charArray)) + ";" + word);
            } else {
                anagrams.put(String.valueOf(charArray), word);
            }
        });

        System.out.println(anagrams.values().toString());
        return anagrams;

    }
}
