import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    // https://leetcode.com/problems/product-of-array-except-self/
    public static int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        pre[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            pre[i] = nums[i] * pre[i-1];
        }
        post[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>0; i--) {
            post[i] = nums[i] * post[i+1];
        }
        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                out[i] = 1 * post[i+1];
            } else if(i == nums.length-1) {
                out[i] = pre[i-1] * 1;
            } else {
                out[i] = pre[i-1] * post[i+1];
            }
        }
        return out;
    }
    public static void main(String[] args) {
        int[] in = {1,2,3,4};
        // int[] in = {-1,1,0,-3,3};
        int[] productExceptSelf = productExceptSelf(in);
        System.out.println(Arrays.toString(productExceptSelf));
    }
}
