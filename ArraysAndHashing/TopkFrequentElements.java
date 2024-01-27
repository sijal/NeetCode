import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopkFrequentElements {
    // https://leetcode.com/problems/top-k-frequent-elements/

    public static void main(String[] args) {
        int[] in = {1,1,1,2,2,3,3,3,3,3};
        int[] out = topKFrequent2(in, 2); // 19ms time | 46MB memory
        System.out.println(Arrays.toString(out));
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0).intValue()+1);
        }
        List<Integer> collect = map.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
            .limit(k)
            .collect(Collectors.mapping(
                x -> x.getKey(),
                Collectors.toList()
            ));
            
        return collect.stream().mapToInt(x -> x.intValue()).toArray();
    }
}
