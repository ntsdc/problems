public class MaxProduct {
}
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];     //max
        dp[0][1] = nums[0];     //min

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(nums[i], Math.max(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));
            dp[i][1] = Math.min(nums[i], Math.min(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));
        }
        int max = -10;
        for (int i = 0; i < len; i++) {
            if(dp[i][0] > max){
                max = dp[i][0];
            }
        }
        return max;
    }
}