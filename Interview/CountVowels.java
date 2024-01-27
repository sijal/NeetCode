public class CountVowels {
    public static void main(String[] args) {
        String a ="SAAomething";
        a = a.toLowerCase();
        long v = a.chars().filter(x -> "aeiou".indexOf(x) != -1).count();
    }
}