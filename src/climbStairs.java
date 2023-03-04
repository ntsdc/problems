public class climbStairs {

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(45));
    }
}
class Solution70 {
    public int climbStairs(int n) {
        if(n == 3) return 3;
        if(n == 2) return 2;
        if(n == 1) return 1;

        return climbStairs(n-1) + climbStairs(n-2);

    }
}