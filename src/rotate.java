public class rotate {

    public static void main(String[] args) {
        new Solution48().rotate(new int[][]{{1,2},{3,4}});
    }

}

class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {   //矩阵转置
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {   //镜像对称
                int temp;
                temp = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }

}