package BinarySearch;

public class SearchInRotatedSortedArray {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static void main(String[] args) {
        int[] in = { 5, 1, 3 };
        System.out.println(search(in, 1));
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivotIndex(nums);
        if (pivot == -1)
            return search(nums, target, 0, nums.length - 1);
        if (target >= nums[0])
            return search(nums, target, 0, pivot);
        return search(nums, target, pivot + 1, nums.length - 1);
    }

    public static int search(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
            start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int findPivotIndex(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = start + ( end - start ) / 2;
            if(mid < end && nums[mid] > nums[mid+1]) {
                return mid;
            } else if(mid > start && nums[mid] < nums[mid-1]) {
                return mid-1;
            } else if(nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
         
    
