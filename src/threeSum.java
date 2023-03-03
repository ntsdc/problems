import java.util.*;


public class threeSum {
    public static void main(String[] args) {
        System.out.println(new Solution15().threeSum(new int[]
                {1,-1,-1,0}
        ));
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i]== nums[i-1]) continue;
            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;//remove dupes
                    L++; R--;
                }
                else if(sum > 0) R--;
                else L++;
            }
        }
        return res;
    }
}
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            Map<Integer,Integer> map = new HashMap<>();
//            for (int j = i + 1; j < nums.length; j++) {
//                if(map.containsKey(-nums[i]-nums[j])) {
//                    ArrayList<Integer> res_arr = new ArrayList<>();
//                    res_arr.add(nums[i]);
//                    res_arr.add(nums[j]);
//                    res_arr.add(-nums[i]-nums[j]);
//                    res.add(res_arr);
//                }else map.put(nums[j],j);
//            }
//        }
//        return res;