import static ds.MatrixMultiply.multiply;

public class climbStairs {

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs_matrix(45));
    }
}
class Solution70 {
    public int climbStairs(int n) {
//        if(n == 3) return 3;
//        if(n == 2) return 2;
//        if(n == 1) return 1;
//
//        return climbStairs(n-1) + climbStairs(n-2);   //time limit

        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
    public int climbStairs_matrix(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;    //二分法---矩阵快速幂算法
            a = multiply(a, a);
        }
        return ret;

    }
}