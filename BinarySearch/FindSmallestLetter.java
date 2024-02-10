package BinarySearch;

public class FindSmallestLetter {
    public static void main(String[] args) {
        // https://leetcode.com/problems/find-smallest-letter-greater-than-target/
        char[] letters = {'c','f','j', 'l'};
        char target = 'l';
        System.out.println(nextGreatestLetter(letters, target));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        for(char c : letters) {
            if(c > target) {
                ans = c;
                break;
            }
        }
        return ans;
    }
}
