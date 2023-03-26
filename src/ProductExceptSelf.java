import ds.ArrayOps;

public class ProductExceptSelf{
    public static void main(String[] args) {
        int[] a = new Solution238().productExceptSelf(
                new int[]{1,2,3,4}
        );
        System.out.println();
    }
}
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int temp = 1;
        for (int i = 0; i < len; i++) { //每个数左边的乘积
            res[i] = temp;
            temp = temp * nums[i];
        }
        temp = 1;
        for (int i = len - 1; i >= 0; i--) {    //右边
            res[i] *= temp;
            temp = temp * nums[i];
        }

        return res;
    }


}