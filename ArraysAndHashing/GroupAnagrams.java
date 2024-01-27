import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        anagrams(s);
    }

    public static List<List<String>> anagrams(String[] s) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : s) {
            String sorted = sort(str);
            List<String> orDefault = map.getOrDefault(sorted, new ArrayList<>());
            orDefault.add(str);
            map.put(sorted, orDefault);
        }
        return new ArrayList<>(map.values());
    }

    public static String sort(String in) {
        
        char[] c = in.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
        // return in.chars().mapToObj(x -> (char) x)
        //         .sorted()
        //         .map(String::valueOf)
        //         .collect(Collectors.joining());
    }

}
