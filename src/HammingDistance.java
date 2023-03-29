public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(new Solution461().hammingDistance(3,1));
    }
}

class Solution461 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & (1 << i)) != (y & (1 << i))) {
                count++;
            }
        }
        return count;
    }
}
class Solution461_API {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
class Solution461_SIMLI {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
