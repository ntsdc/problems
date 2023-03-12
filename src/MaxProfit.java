public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(new Solution121_dp()
                .maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
class Solution121_dp{
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return dp[n - 1];
    }
}
class Solution121 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;
            if(profit > maxProfit){
                maxProfit = profit;
            }
            if(prices[i] < min){
                min = prices[i];
            }
        }
        return maxProfit;
    }
}