import java.util.ArrayList;
import java.util.List;

public class permute {
    public static void main(String[] args) {
        new Solution46().permute(new int[]{1,2,3});
    }

}
class Solution46 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> permute = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        backtrack(nums, visited);
        return res;

    }
    public void backtrack(int[] nums, int[] visited){

        if(permute.size() == nums.length){
            res.add(new ArrayList<>(permute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i] == 0){
                permute.add(nums[i]);
                visited[i] = 1;
            }else continue;
            backtrack(nums, visited);
            permute.remove(permute.size()-1);
            visited[i] = 0;
        }
    }
}