public class canJump {
    public static void main(String[] args) {
        System.out.println(new Solution55_new().canJump(new int[]{0,2,3}));
    }
}

class Solution55 {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if(dp[i]){
                if (i + nums[i] >= nums.length) {
                    return true;
                }
                for (int j = 1; i + j < nums.length && j <= nums[i]; j++) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
class Solution55_new {
    public boolean canJump(int[] nums) {
        int max_dis = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i <= max_dis){
                max_dis = Math.max(max_dis, i + nums[i]);
                if(max_dis >= nums.length - 1) {
                    return true;
                }
            }
        }
        return max_dis >= nums.length - 1;
    }
}