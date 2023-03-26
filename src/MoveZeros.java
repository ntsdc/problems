public class MoveZeros {
    public static void main(String[] args) {
        new Solution283().moveZeroes(
                new int[]{0,1,0,3,12}
        );
        System.out.println();
    }
}
class Solution283 {
    public void moveZeroes_(int[] nums) {
        int len  = nums.length;
        int[] res = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] == 0){
                res[len - count - 1] = 0;
                count++;
            }else {
                res[i - count] = nums[i];
            }
        }
    }
    public void moveZeroes(int[] nums) {
        int len  = nums.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            if(nums[i] == 0){
                count++;
                continue;
            }
            nums[i - count] = nums[i];
        }
        while (count > 0){
            nums[len - count] = 0;
            count--;
        }
        return;
    }
}