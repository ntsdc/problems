public class MaximalSquare {

    public static void main(String[] args) {
        System.out.println(
                new Solution221_official().maximalSquare(
                        new char[][]
                                {
//                                        {'0','0','0','1'},
//                                        {'1','1','0','1'},
//                                        {'1','1','1','1'},
//                                        {'0','1','1','1'},
//                                        {'0','1','1','1'},
//
                                        {'1','1','1','1','1','1','1','1'},
                                        {'1','1','1','1','1','1','1','0'},
                                        {'1','1','1','1','1','1','1','0'},
                                        {'1','1','1','1','1','0','0','0'},
                                        {'0','1','1','1','1','0','0','0'}
                                }
                )
        );
    }

}

class Solution221_official {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}



class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 1; j < n; j++) {
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j] = check(matrix, dp, i, j);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
    public int check(char[][] matrix, int[][] dp, int m, int n){
        int num = dp[m - 1][n - 1];
        if(num == 0){
            return 1;
        }
        for (int i = 0; i < num; i++) {
            if(dp[m][n - 1 - i] == 0 || dp[m - 1 - i][n] == 0){
                return i + 1;
            }
        }
        return num + 1;
    }
}