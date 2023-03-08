import java.math.BigDecimal;

/**
 * @author Lenovo
 */
public class uniquePaths {
    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths(10, 10));
    }
}

class Solution62 {
    public int uniquePaths(int m, int n) {
        return cal_new(m + n - 2, n - 1);
    }

    public int cal(int m, int n) {
        if (n > m / 2) {
            n = m - n;
        }
        BigDecimal res = new BigDecimal(1);
        BigDecimal fac = new BigDecimal(1);
        for (int i = 0; i < n; i++) {
            res = res.multiply(BigDecimal.valueOf(m - i));
        }
        for (int i = 2; i <= n; i++) {
            fac = fac.multiply(BigDecimal.valueOf(i));
        }
        return res.divide(fac).intValue();
    }

    public int cal_new(int m, int n) {
        if (n > m / 2) {
            n = m - n;
        }
        long ans = 1;
        for (int i = 0, y = 1; i < n; i++, y++) {
            ans = ans * (m - i)/y;
        }
        return (int) ans;
    }
}
class dp62 {    //动态规划
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
