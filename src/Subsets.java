import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        new Solution78().subsets(new int[]{1, 2, 3});
    }
}

class Solution78 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int index) {
        res.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}