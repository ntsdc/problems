public class CoinChange {
    public static void main(String[] args) {
        System.out.println(
                new Solution322().coinChange(
                        new int[]{2}, 3
                )
        );
    }
}

class Solution322 {
    public int coinChange(int[] coins, int amount) {

        int[] F = new int[amount + 1];
        F[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int curMin = amount + 1;    //定义最大值：：金额+1就是最多（全1块）
            F[i] = amount + 1;
            for (int coin : coins) {
                int remain = i - coin;
                if (remain < 0) {
                    continue;
                }
                curMin = Math.min(curMin, F[remain] + 1);
            }
            F[i] = curMin;
        }
        return F[amount] > amount ? -1 : F[amount];
    }
}