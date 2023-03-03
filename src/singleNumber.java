public class singleNumber {

    public static void main(String[] args) {
        System.out.println(new Solution137().singleNumber(new int[]{1,1,1,3,3,3,5}));
    }
}
class Solution137{
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num :nums) {
                total += ((num>>i)&1);
            }
            if(total % 3 != 0){
                ans |= (1<<i);
            }
        }
        return ans;
    }
}
