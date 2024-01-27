import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FindDuplicateNumbersInList {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(5);
        l.add(1);
        l.add(2);
        l.add(1);
        l.add(2);
        l.add(3);
        
        Set<Integer> num = new HashSet<>();
        List<Integer> out = new ArrayList<>();

        for(int i=0; i<l.size(); i++) {
            if(num.contains(l.get(i)))
                out.add(l.get(i));
            else
                num.add(l.get(i));
        }
        System.out.println(out);
    }
}