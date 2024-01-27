public class Anagram {
    public static void main(String[] args) {
        Anagram an = new Anagram();
        an.isAnagram("suman","mansu");
    }

    public boolean isAnagram(String s, String t) {

        int[] a1 = new int[26];

        for(char c : s.toCharArray()) {
            a1[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            a1[c - 'a']--;
        }

        for(int i : a1) {
            if(i!=0) return false;
        }

        return true;
    }
}
