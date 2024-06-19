package BinarySearch;

public class SearchInRotatedSortedArrayWithDuplicates {
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    public static void main(String[] args) {
        int[] in = { 1, 1, 3 };
        System.out.println(search(in, 3));
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivotIndex(nums);
        if (pivot == -1)
            return binarySearch(nums, target, 0, nums.length - 1);
        if (target >= nums[0])
            return binarySearch(nums, target, 0, pivot);
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
//        return pivot;
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        int mid;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] < target) {
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
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid+1]) {
                return mid;
            } else if(mid > start && nums[mid] < nums[mid-1]) {
                return mid-1;
            } else if(nums[start] == nums[mid] && nums[end] == nums[mid]) {
                if(start < nums.length-1 && nums[start] > nums[start+1]) {
                    return start;
                }
                start++;
                if(end != 0 && nums[end] < nums[end-1]) {
                    return end-1;
                }
                end--;
            }
            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[end] < nums[start])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
