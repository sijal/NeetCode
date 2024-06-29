package BinarySearch;

public class FindRotationCountRotatedSortedArray {
  // https://www.geeksforgeeks.org/problems/rotation4723/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
  public static void main(String[] args) {
    findKRotation(new int[]{66, 72, 79, 86, 95, 104, 106, 110, 119, 123, 124, 129, 132, 136, 137, 142, 150, 2, 12, 14, 17, 26, 30, 36, 38, 46, 52, 60}, 28);
  }
  static void findKRotation(int arr[], int n) {
    System.out.println(
            findPivotIndex(arr)+1
    );
  }

  static int findPivotIndex(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    int mid;
    if(arr[start] < arr[end]) {
      return -1;
    }
    while (start <= end) {
      mid = start + (end - start) / 2;
      if((mid > end || mid == start) && arr[mid] > arr[mid+1]) {
        return mid;
      } else if(mid > start && arr[mid] < arr[mid - 1]) {
        return mid - 1;
      } else if(arr[mid] > arr[start]) {
        start = mid;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}
