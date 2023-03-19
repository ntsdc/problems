import java.util.Arrays;
import java.util.Random;

public class MajorityElement {

}
class Solution169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement_randomized_selection(int[] nums){
        Random random = new Random();
        int len = nums.length;
        while (true){

            int index = random.nextInt(len);
            if(count(nums, nums[index]) > len / 2){
                return nums[index];
            }
        }
    }
    public int count(int[] nums, int num){
        int count = 0;
        for (int i : nums) {
            if(i == num){
                count++;
            }
        }
        return count;
    }


    public int majorityElement_vote(int[] nums) {
        int winner = 0;
        int count = 0;
        for (int num : nums) {
            if(count == 0){
                winner = num;
                count++;
            } else if (num != winner) {
                count--;
            }else {
                count++;
            }
        }
        return winner;
    }

}