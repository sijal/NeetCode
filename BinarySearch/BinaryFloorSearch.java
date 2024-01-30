package BinarySearch;

public class BinaryFloorSearch {
    public static void main(String[] args) {
        // Find target or number less than target
        int[] in = {12, 23, 34, 45, 56, 67, 78, 89};
        int target = 30;
        int index = search(in, target);
        System.out.println(in[index]);
    }

    private static int search(int[] in, int target) {
        int start = 0;
        int end = in.length;
        int mid = 0;
        while(start<end) {
            mid = start + (end - start) / 2;
            if(in[mid] < target) {
                start = mid + 1;
            } else if(in[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        if(end >= 0) {
            return end;
        }
        return -1;
    }
}
