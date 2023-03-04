package ds;

public class MatrixMultiply {
    public static int[][] multiply(int[][] a, int[][] b) {

        if (a[0].length != b.length) throw new RuntimeException("Matrix not fit");
        int[][] res = new int[a.length][b[0].length];
        int i,j;
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[0].length; j++) {
                for (int k = 0; k < b[0].length; k++) {
                    res[i][k] += a[i][j]*b[j][k];
                }
            }
        }
        return res;
    }
}
