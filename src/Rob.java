public class Rob {
    public static void main(String[] args) {
        System.out.println(
                new Solution198().rob_new(
                        new int[]{
                                2
                        }
                )
        );
    }
}
class Solution198 {
    public int rob(int[] nums) {

        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
    public int rob_new(int[] nums) {    //内存空间优化版
        if(nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int last_true = nums[0];
        int last_false = 0;
        for (int i = 1; i < len; i++) {
            int temp = last_true;
            last_true = last_false + nums[i];
            last_false = Math.max(temp, last_false);
        }
        return Math.max(last_true, last_false);
    }
}