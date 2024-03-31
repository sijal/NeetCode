package BinarySearch;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] array = //{0,1,2,4,2,1};
        // {1,2,3,4,5,3,1};
        {0,5,3,1};
        int target = 1;
        System.out.println(findInMountainArray(target, array));
    }
// https://leetcode.com/problems/find-in-mountain-array/description/
    public static int findInMountainArray(int target, int arr[]) {
        int peakIndex = findPeakIndex(arr);
        int targerIndex = orderAgnosticBinarySearch(target, 0, peakIndex, arr);
        if(targerIndex == -1) {
            System.out.println("Loop 2");
            targerIndex = orderAgnosticBinarySearch(target, peakIndex+1, arr.length-1, arr);
        }
        return targerIndex;
    }
    public static int orderAgnosticBinarySearch(int target, int start, int end, int arr[]) {
        boolean asc = false;
        if(arr[start] < arr[end]) {
            asc = true;
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            if(asc) {
                if(arr[mid] > target) {
                    end = mid - 1;
                } else if(arr[mid] < target) {
                    start = mid + 1;
                }
            } else {
                if(arr[mid] > target) {
                    start = mid + 1;
                } else if(arr[mid] < target) {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    public static int findPeakIndex(int[] array) {
        int start = 0;
        int end = array.length-1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(array[mid] < array[mid+1]) {
                start = mid + 1;
            } else if(array[mid] > array[mid+1]) {
                end = mid;
            }
        }
        return start;
    }
}
