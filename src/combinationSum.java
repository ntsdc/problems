import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {

    public static void main(String[] args) {
        new Solution39().combinationSum(new int[]{1, 3, 5, 7, 9}, 15);
    }
}

class Solution39 {
    private List<List<Integer>> res = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }
    public void backtrack(int[] candidates, int target, int idx) {
        if (idx == candidates.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }
        backtrack(candidates, target, idx + 1);
        if (target >= candidates[idx]) {
            nums.add(candidates[idx]);
            backtrack(candidates, target - candidates[idx], idx);
            nums.remove(nums.size() - 1);
        }
    }
}
