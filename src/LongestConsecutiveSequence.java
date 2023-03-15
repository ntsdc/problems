import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new Solution128().longestConsecutive(new int[]
                {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));

    }
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);       //集合去重
        }
        for (int num : nums) {
            if (hashSet.contains(num - 1)) {    //包含x-1跳过，保证从最长序列起点开始遍历
                continue;
            }
            int cur = num + 1;
            int count = 1;
            while (hashSet.contains(cur++)) {
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
/*
    cannot work
    Map<Integer, AtomicInteger> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            AtomicInteger value;

            if (hashmap.containsKey(nums[i] + 1)) {
                count++;
                value = hashmap.get(nums[i] + 1);
                if (count > value.get()) {
                    hashmap.replace(nums[i] + 1, new AtomicInteger(count));
                }
            }
            if (hashmap.containsKey(nums[i] - 1)) {
                count++;
                value = Math.max(hashmap.get(nums[i] - 1), value);
                if (count > value.get()) {
                    hashmap.replace(nums[i] - 1, count);
                }
            }
            int biggerVal = Math.max(count, value);
            hashmap.put(nums[i], biggerVal);


            if (biggerVal > max) {
                max = biggerVal;
            }
        }
        return max;*/
