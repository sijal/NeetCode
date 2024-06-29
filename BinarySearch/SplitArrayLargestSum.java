package BinarySearch;

import java.util.Arrays;

public class SplitArrayLargestSum {
  // https://leetcode.com/problems/split-array-largest-sum/

  public static void main(String[] args) {
    int[] nums = {7,2,5,10,8};
    int k = 2;
    System.out.print(splitArray(nums, k));
  }

  public static int splitArray(int[] nums, int k) {
    int start = Arrays.stream(nums).max().orElse(nums[0]);
    int end = Arrays.stream(nums).sum();

    return binarySearch(nums, k, start, end);
  }

  private static int binarySearch(int[] nums, int k, int start, int end) {
    while(start < end) {
      int mid = start + (end - start) / 2;
      int sum = 0;
      int pieces = 1;
      for (int num : nums) {
        if (sum + num <= mid)
          sum = sum + num;
        else {
          sum = num;
          pieces++;
        }
      }

      if(pieces > k) {
        start = mid + 1;
      } else {
        end = mid;
      }

    }
    return end;
  }
}
