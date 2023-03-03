import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {

    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i :
                nums) {
            if (hashMap.containsKey(target - nums[i]))
                return new int[] {hashMap.get(target - nums[i]),i};
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }
}

