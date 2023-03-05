public class searchRange {
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int lid = binarySearch(nums, target, true); //第一个大于等于target的下标
        int rid = binarySearch(nums, target, false) - 1;    //第一个大于target的下标
        if (lid <= rid && rid < nums.length && nums[rid] == target && nums[lid] == target)
            return new int[]{lid, rid};
        else return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean condition) {
        int n = nums.length;
        int l = 0, r = n - 1, mid, ans = nums.length;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target < nums[mid] || condition && nums[mid] >= target) {
                r = mid - 1;
                ans = mid;  //一直查找最后返回的就是条件最先出现的（先查前半部分）
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}