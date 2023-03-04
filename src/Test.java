import ds.MatrixMultiply;

public class Test {
    /////
    public static void main(String[] args) {
        MatrixMultiply.multiply(new int[][]{
                        {1,0,0},
                        {0,1,0},
                        {0,0,1},
        },
                new int[][]{
                        {1,0,0},
                        {0,1,0},
                        {0,0,1},
                });
    }
}
