package BinarySearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        // int[] in = { -10, -5, 0, 12, 23, 45, 56, 67, 78, 89, 90 };
        int[] in = { 90, 89, 78, 67, 56, 45, 0, -5, -8, -10 };
        int target = -8;
        int index = search(in, target);
        System.out.println(index);
    }

    private static int search(int[] in, int target) {
        int start = 0;
        int end = in.length - 1;
        int mid = -1;

        while (start < end) {
            mid = start + (end - start) / 2;
            if (in[mid] == target) {
                return mid;
            }
            if (in[start] < in[end]) {
                if (in[mid] < target) {
                    start = mid + 1;
                } else if (in[mid] > target) {
                    end = mid - 1;
                }
            } else if (in[start] > in[end]) {
                if (in[mid] > target) {
                    start = mid + 1;
                } else if (in[mid] < target) {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
