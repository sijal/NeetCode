package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] in = { -10, -5, 0, 12, 23, 45, 56, 67, 78, 89, 90 };
        int target = 100;
        int index = search(in, target);
        System.out.println(index);
    }

    public static int search(int[] in, int target) {
        int start = 0;
        int end = in.length - 1;
        int mid = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (in[mid] > target) {
                end = mid - 1;
            } else if (in[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
