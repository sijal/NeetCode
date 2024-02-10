package BinarySearch;

public class PeakIndexMountainArray {

    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
    // https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    // https://leetcode.com/problems/find-peak-element/description/
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] < arr[mid+1]) {
                start = mid + 1;
            } else if(arr[mid] > arr[mid+1]) {
                end = mid;
            }
        }

        return start;
    }
    
}