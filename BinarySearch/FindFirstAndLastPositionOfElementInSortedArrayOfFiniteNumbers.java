package BinarySearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArrayOfFiniteNumbers {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1165718941/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange1(new int[]{2}, 2))); // without binary search
        System.out.println(Arrays.toString(searchRange2(new int[]{2}, 2))); // with binary search
    }
    public static int[] searchRange2(int[] nums, int target) {
        int ans[] = {-1, -1};
        ans[0] = search(nums, target, true);
        if(ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }
    private static int search(int[] nums, int target, boolean findFirstElement) {
        int ans = -1;
        int start = 0;
        int end = nums.length -1;
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if(findFirstElement) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
    public static int[] searchRange1(int[] nums, int target) {
        int[] ans = { -1, -1 };
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (!flag && nums[i] == target) {
                ans[0] = i;
                ans[1] = i;
                flag = true;
            } else if (flag && nums[i] == target) {
                ans[1] = i;
            }
        }
        return ans;
    }
}
