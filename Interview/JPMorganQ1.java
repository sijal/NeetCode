import java.util.ArrayList;
import java.util.List;

public class JPMorganQ1 {
        // Almost equavilant string hackerrank question solution
    public static List<String> determineEquivalence(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();

        if (list1.length != list2.length) {
            return result;  // Return an empty list if the arrays are of different lengths
        }

        for (int i = 0; i < list1.length; i++) {
            result.add(areAlmostEquivalent(list1[i], list2[i]) ? "Yes" : "No");
        }

        return result;
    }

    public static boolean areAlmostEquivalent(String word1, String word2) {
        int[] freqWord1 = new int[26];
        int[] freqWord2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freqWord1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freqWord2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (Math.abs(freqWord1[i] - freqWord2[i]) > 3) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test case for lists
        String[] list1 = {"abc", "def", "xyz"};
        String[] list2 = {"bcd", "dfe", "xyy"};

        List<String> result = determineEquivalence(list1, list2);
        System.out.println(result);  // Output: [Yes, Yes, Yes] (all corresponding words are almost equivalent)
    }
}