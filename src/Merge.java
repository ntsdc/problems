import java.util.*;

/**
 * @author Lenovo
 */
public class Merge {
    public static void main(String[] args) {
        new Solution56().merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
//                {1, 4}, {4, 5}
        });
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {//与官方解法相同，但逻辑比较乱
        if(intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> res = new ArrayList<>();
        int l = intervals[0][0], r = intervals[0][1];
        int n = intervals.length;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= r) {
                r = Math.max(intervals[i][1], r);
            }
            if(i == n-1){
                int[] range = new int[2];
                range[0] = l;
                range[1] = r;
                res.add(range);
                break;
            }
            if (intervals[i][0] > r) {
                int[] range = new int[2];
                range[0] = l;
                range[1] = r;
                res.add(range);
                l = intervals[i][0];
                r = intervals[i][1];
            }
        }
        if (r < intervals[n - 1][0]) {
            int[] range = new int[2];
            range[0] = intervals[n - 1][0];
            range[1] = intervals[n - 1][1];
            res.add(range);
        }
        int[][] merged = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            merged[i] = res.get(i);
        }
        return merged;
    }
}

class Solution56_official {// 官方解法
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}