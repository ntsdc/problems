import java.util.Arrays;

public class search {
    public static void main(String[] args) {

        System.out.println(new Solution33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
    }
}

class Solution33 {
    public int search(int[] nums, int target) {
//        int index = -1;
//        if (nums[0] < nums[nums.length / 2]) {
//            if (target <= nums[nums.length / 2] && target >= nums[0])
//                index =  target - nums[0];
//            else search(Arrays.copyOfRange(nums, nums.length / 2 , nums.length), target);
//        } else {
//            if (target <= nums[nums.length - 1] && target >= nums.length / 2)
//                index = nums[nums.length-1]-target;
//            else search(Arrays.copyOfRange(nums, 0, nums.length / 2 - 1), target);
//        }
//        return index;
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return target == nums[0] ? 0 : -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    r = mid - 1;
                } else
                    l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[n - 1]) {
                    l = mid + 1;
                } else
                    r = mid - 1;
            }
        }
        return -1;

    }
}