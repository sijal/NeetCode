package BinarySearch;

import java.util.Arrays;

public class FindPositionOfElementInSortedArrayOfInfiniteNumbers {
    //https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    public static void main(String[] args) {
        System.out.println(searchRange(
                                new int[]{ 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170, 171, 172, 173 },
                                100)
                            );
    }
    public static int searchRange(int[] nums, int target) {
        int start = 0;
        int end = 1;
        
        while(nums[end] < target) {
            int newstart = end + 1;
            end = end + (end - start + 1) * 2 ;
            start = newstart;
        }
        return search(nums, start, end, target);
    }
    private static int search(int[] nums, int start, int end, int target) {
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
